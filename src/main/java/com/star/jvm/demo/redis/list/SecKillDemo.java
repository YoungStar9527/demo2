package com.star.jvm.demo.redis.list;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * 秒杀活动案例
 */
public class SecKillDemo {

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

    /**
     * 秒杀抢购请求入队
     * @param secKillRequest
     */
    public void enqueueSecKillRequest(String secKillRequest) {
        jedis.lpush("sec_kill_request_queue", secKillRequest);
    }

    /**
     * 秒杀抢购请求出队
     * @return
     */
    public String dequeueSecKillRequest() {
        return jedis.rpop("sec_kill_request_queue");
    }

    public static void main(String[] args) throws Exception {
        SecKillDemo demo = new SecKillDemo();

        for(int i = 0; i < 10; i++) {
            demo.enqueueSecKillRequest("第" + (i + 1) + "个秒杀请求");
        }

        while(true) {
            String secKillRequest = demo.dequeueSecKillRequest();

            if(secKillRequest == null
                    || "null".equals(secKillRequest)
                    || "".equals(secKillRequest)) {
                break;
            }

            System.out.println(secKillRequest);
        }
    }

}
