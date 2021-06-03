package com.star.jvm.demo.redis.hash;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * 短网址追踪案例
 */
public class ShortUrlDemo {

    private static final String[] X36_ARRAY = "0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");

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

    public ShortUrlDemo() {
        //重置短连接生成值
        //jedis.set("short_url_seed", "77");
    }

    /**
     * 获取短连接网址
     * 每次调用都生成新的短连接地址，新的短连接地址和参数url绑定
     * url地址和短连接生成没有关系，同一个url重复调用该方法，也会生成新的短连接，造成不同的短连接指向同一个url
     * @param url
     * @return
     */
    public String getShortUrl(String url) {
        long shortUrlSeed = jedis.incr("short_url_seed");

        StringBuffer buffer = new StringBuffer();
        //利用redis的incr自增长，然后10进制转36进制，接着hset存放在hash数据结构里，再提供一个映射转换的hget获取方法
        while(shortUrlSeed > 0) {
            buffer.append(X36_ARRAY[(int)(shortUrlSeed % 36)]);
            shortUrlSeed = shortUrlSeed / 36;
        }
        String shortUrl = buffer.reverse().toString();
        //重置对应key的访问次数
        jedis.hset("short_url_access_count", shortUrl, "0");
        //关联短连接和url,每次新生成的短连接关联url
        //放在url_mapping中的hash结构内，url_mapping对应的数据相当于java的一个HashMap实例
        jedis.hset("url_mapping", shortUrl, url);
        return shortUrl;
    }

    /**
     * 给短连接地址进行访问次数的增长
     * @param shortUrl
     */
    public void incrementShortUrlAccessCount(String shortUrl) {
        //value设置为多少每次调用就增加多少
        jedis.hincrBy("short_url_access_count", shortUrl, 1);
    }

    /**
     * 获取短连接地址的访问次数
     * @param shortUrl
     */
    public long getShortUrlAccessCount(String shortUrl) {
        return Long.valueOf(jedis.hget("short_url_access_count", shortUrl));
    }

    public static void main(String[] args) throws Exception {
        ShortUrlDemo demo = new ShortUrlDemo();

        String shortUrl = demo.getShortUrl("http://redis.com/index.html");
        //String shortUrl = demo.getShortUrl("https://www.cnblogs.com/skyblue123/p/13287028.html?utm_source=tuicool");
        System.out.println("页面上展示的短链接地址为：" + shortUrl);

        for(int i = 0; i < 155; i++) {
            demo.incrementShortUrlAccessCount(shortUrl);
        }
        long accessCount = demo.getShortUrlAccessCount(shortUrl);
        System.out.println("短链接被访问的次数为：" + accessCount);
        System.out.println("真实连接地址为："+jedis.hget("url_mapping",shortUrl));
    }

}
