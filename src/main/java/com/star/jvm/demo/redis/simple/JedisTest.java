package com.star.jvm.demo.redis.simple;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JedisTest {

    private static JedisCluster jedis;
    static {
        // 添加集群的服务节点Set集合
        Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
        // 添加节点
        hostAndPortsSet.add(new HostAndPort("192.168.31.101", 7001));
        hostAndPortsSet.add(new HostAndPort("192.168.31.101", 7002));
        hostAndPortsSet.add(new HostAndPort("192.168.31.102", 7003));
        hostAndPortsSet.add(new HostAndPort("192.168.31.102", 7004));
        hostAndPortsSet.add(new HostAndPort("192.168.31.103", 7005));
        hostAndPortsSet.add(new HostAndPort("192.168.31.103", 7006));

        // Jedis连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(100);
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(500);
        //最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(0);
        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setMaxWaitMillis(2000); // 设置2秒
        //对拿到的connection进行validateObject校验
        jedisPoolConfig.setTestOnBorrow(true);
        jedis = new JedisCluster(hostAndPortsSet, jedisPoolConfig);
    }

    public static void main(String[] args) {
        //Jedis jedis = new Jedis("127.0.0.1");
        //setNxTest(jedis);
        //mkeyTest(jedis);
        //incrTest(jedis);
        appendTest(jedis);
    }

    /**
     * 最简单的分布式锁样例
     * @param jedis
     */
    private static void  setNxTest(JedisCluster jedis){
        //还原锁
        jedis.del("lock_test");
        //第一次加锁
        String set = jedis.set("lock_test", "value1", SetParams.setParams().nx());
        System.out.println("第一次加锁：结果"+set);
        //第二次加锁,已存在的key进行 set nx操作会返回失败状态，可以利用这个特性实现分布式锁
        String set1 = jedis.set("lock_test", "value1", SetParams.setParams().nx());
        System.out.println("第二次加锁：结果"+set1);
    }

    /**
     * 博客发布/查看/点赞
     * mget mset msetnx 批量操作key
     * m-< multi
     * 如果是redis Cluster key值需要加大括号{}，会将大括号内的key放在同一个slot内，否则批量操作会因为不同key在slot内而失败
     * 单机redis则无需加大括号{}
     * @param jedisCluster
     */
    private static void mkeyTest(JedisCluster jedisCluster){
        String mset = jedisCluster.mset("{blog}:author1", "xjx", "{blog}:content1", "沙雕一号", "{blog}:title1", "略略略略略");
        System.out.println("博客发布结果："+mset);
        List<String> mget = jedisCluster.mget("{blog}:author1", "{blog}:content1", "{blog}:title1");
        System.out.println("博客查看结果："+mget);
        Long msetnx = jedisCluster.msetnx(
                "{blogauthor1}11", "xjx",
                "{blogauthor1}22", "沙雕二号",
                "{blogauthor1}33", "略略略略略",
                "{blogauthor1}44", "123");
        System.out.println("msetnx结果："+msetnx);
    }

    /**
     * 统计长度或字数
     * strlen 统计
     * getrange
     * @param jedisCluster
     */
    private static void countAndLenthTest(JedisCluster jedisCluster){
        //按照字节数统计，中文两个字节，英文数字一个字节
        jedisCluster.set("strContent","测试test123");
        Long strlen = jedisCluster.strlen("strContent");
        System.out.println("博客正文统计："+strlen);
        //按照字节数截取，中文两个字节，英文数字一个字节
        String getrange = jedisCluster.getrange("strContent", 0, 5);
        System.out.println("博客摘要结果："+getrange);
    }

    /**
     * 点赞/唯一ID生成
     * incr每调用一次value值就+1
     * @param jedisCluster
     */
    private static void incrTest(JedisCluster jedisCluster){
        jedisCluster.del("idKey1");
        for(int i = 0; i < 10; i++){
            Long idKey1 = jedisCluster.incr("idKey1");
            System.out.println("循环次数"+(i+1)+"，id为"+idKey1);
        }
    }

    /**
     * 用户操作日志审计
     * append 每次调用都将value拼接
     * @param jedisCluster
     */
    private static void appendTest(JedisCluster jedisCluster){
        jedisCluster.set("appContent","");
        //用append加入未存在的key和set是一个效果，但是已存在的key，set是覆盖,append是拼接
        //jedisCluster.append("appContent1111","");
        for(int i = 0; i < 10; i++){
            jedisCluster.append("appContent","用户操作第"+(i+1)+"次,");
            System.out.println(jedisCluster.get("appContent"));
        }
    }
}
