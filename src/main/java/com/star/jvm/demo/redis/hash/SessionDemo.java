package com.star.jvm.demo.redis.hash;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用户会话管理案例
 */
public class SessionDemo {

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
     * 检查session是否有效
     * @return
     */
    public boolean isSessionValid(String token) throws Exception {
        // 校验token是否为空
        if(token == null || "".equals(token)) {
            return false;
        }

        // 这里拿到的session可能就是一个json字符串
        // 我们这里简化一下，就放一个用户user_id作为这里的value
        String session = jedis.hget("sessions", "session::" + token);
        if(session == null || "".equals(session)) {
            return false;
        }

        // 检查一下这个session是否在有效期内
        String expireTime = jedis.hget("sessions::expire_time",
                "session::" + token);
        if(expireTime == null || "".equals(expireTime)) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date expireTimeDate = dateFormat.parse(expireTime);

        Date now = new Date();

        if(now.after(expireTimeDate)) {
            return false;
        }

        // 如果token不为空，而且获取到的session不为空，而且session没过期
        // 此时可以认为session在有效期内
        return true;
    }

    /**
     * 模拟的登录方法
     * @param username
     * @param password
     * @return
     */
    public String login(String username, String password) {
        // 基于用户名和密码去登录
        System.out.println("基于用户名和密码登录：" + username + ", " + password);
        Random random = new Random();
        long userId = random.nextInt() * 100;
        // 登录成功之后，生成一块令牌
        String token = UUID.randomUUID().toString().replace("-", "");
        // 基于令牌和用户id去初始化用户的session
        initSession(userId, token);
        // 返回这个令牌给用户
        return token;
    }

    /**
     * 用户登录成功之后，初始化一个session
     * @param userId
     * @param token
     */
    public void initSession(long userId, String token) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 24);
        Date expireTime = calendar.getTime();

        jedis.hset("sessions",
                "session::" + token, String.valueOf(userId));
        //hash做令牌过不能设置key过期自动删除，需要自定义时间作为值，相对麻烦
        jedis.hset("sessions::expire_time",
                "session::" + token, dateFormat.format(expireTime));
    }

    public static void main(String[] args) throws Exception {
        SessionDemo demo = new SessionDemo();

        // 第一次访问系统，token都是空的
        boolean isSessionValid = demo.isSessionValid(null);
        System.out.println("第一次访问系统的session校验结果：" + (isSessionValid == true ? "通过" : "不通过"));

        // 强制性进行登录，获取到token
        String token = demo.login("zhangsan","123456");
        System.out.println("登陆过后拿到令牌：" + token);

        // 第二次再次访问系统，此时是可以访问的
        isSessionValid = demo.isSessionValid(token);
        System.out.println("第二次访问系统的session校验结果：" + (isSessionValid == true ? "通过" : "不通过"));
    }

}
