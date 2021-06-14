package com.star.jvm.demo.redis.list;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ListPosition;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * OA系统的待办事项的管理案例
 */
public class TodoEventDemo {

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
     * 添加待办事项
     * @param todoEvent
     */
    public void addTodoEvent(long userId, String todoEvent) {
        jedis.lpush("todo_event::" + userId, todoEvent);
    }

    /**
     * 分页查询待办事项列表
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<String> findTodoEventByPage(long userId, int pageNo, int pageSize) {
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = pageNo * pageSize - 1;
        return jedis.lrange("todo_event::" + userId, startIndex, endIndex);
    }

    /**
     * 插入待办事项
     */
    public void insertTodoEvent(long userId,
                                ListPosition position,
                                String targetTodoEvent,
                                String todoEvent) {
        jedis.linsert("todo_event::" + userId, position, targetTodoEvent, todoEvent);
    }

    /**
     * 修改一个待办事项
     * @param userId
     * @param index
     * @param updatedTodoEvent
     */
    public void updateTodoEvent(long userId, int index, String updatedTodoEvent) {
        jedis.lset("todo_event::" + userId, index, updatedTodoEvent);
    }

    /**
     * 完成一个待办事项
     * @param userId
     * @param todoEvent
     */
    public void finishTodoEvent(long userId, String todoEvent) {
        jedis.lrem("todo_event::" + userId, 0, todoEvent);
    }

    public static void main(String[] args) throws Exception {
        TodoEventDemo demo = new TodoEventDemo();

        // 添加20个待办事项
        long userId = 2;
        for(int i = 0; i < 20; i++) {
            demo.addTodoEvent(userId, "第" + (i + 1) + "个待办事项");
        }

        // 查询第一页待办事项
        int pageNo = 1;
        int pageSize = 10;
        List<String> todoEventPage = demo.findTodoEventByPage(
                userId, pageNo, pageSize);

        System.out.println("第一次查询第一页待办事项......");
        for(String todoEvent :todoEventPage) {
            System.out.println(todoEvent);
        }

        // 插入一个待办事项
        Random random = new Random();
        int index = random.nextInt(todoEventPage.size());
        String targetTodoEvent = todoEventPage.get(index);

        demo.insertTodoEvent(userId, ListPosition.BEFORE,
                targetTodoEvent, "插入的待办事项");
        System.out.println("在" + targetTodoEvent + "前面插入了一个待办事项");

        // 重新分页查询第一页待办事项
        todoEventPage = demo.findTodoEventByPage(
                userId, pageNo, pageSize);

        System.out.println("第二次查询第一页待办事项......");
        for(String todoEvent :todoEventPage) {
            System.out.println(todoEvent);
        }

        // 修改一个待办事项
        index = random.nextInt(todoEventPage.size());
        demo.updateTodoEvent(userId, index, "修改后的待办事项");

        // 完成一个待办事项
        demo.finishTodoEvent(userId, todoEventPage.get(0));

        // 最后查询一次待办事项
        todoEventPage = demo.findTodoEventByPage(
                userId, pageNo, pageSize);

        System.out.println("第三次查询第一页待办事项......");
        for(String todoEvent :todoEventPage) {
            System.out.println(todoEvent);
        }
    }

}
