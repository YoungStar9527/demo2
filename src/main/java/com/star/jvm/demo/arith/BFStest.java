package com.star.jvm.demo.arith;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 广度有限搜索(BFS)
 */
public class BFStest {

    /**
     * 这个函数检查人的姓名是否以m结尾：如果是，他就是芒果销售商。这种判断方法有点搞笑，
     * 但就这个示例而言是可行的。下面来看看广度优先搜索的执行过程
     */
    private static boolean isDistributor(String name){
        if(name.substring(name.length()-1,name.length()).equals("m")){
            return true;
        }
        System.out.println("验证过的不是的老哥："+name);
        return false;
    }

    private static void test1(){
        //图-哈希表
        Map<String,String[]> mapData = new HashMap<>();
        mapData.put("you",new String[]{"alice","bob","claire"});
        mapData.put("bob",new String[]{"anuj","peggy"});
        mapData.put("alice",new String[]{"peggy"});
        mapData.put("claire",new String[]{"thom","jonny"});
        mapData.put("anuj",new String[]{});
        mapData.put("peggy",new String[]{});
        mapData.put("thom",new String[]{});
        mapData.put("jonny",new String[]{});
        //待检查队列
        Queue<String> checkQueue = new ArrayBlockingQueue(50);
        checkQueue.addAll(Arrays.asList(mapData.get("you")));
        Iterator<String> iterator = checkQueue.iterator();
        //已经检查过的数组
        List<String> checkDo = new ArrayList<>();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(checkDo.contains(next)){
                //System.out.println("这个老哥已经检查过啦:"+next);
                continue;
            }
            if(isDistributor(next)){
                System.out.println("找到啦:"+next);
                break;
            }else {
                checkQueue.addAll(Arrays.asList(mapData.get(next)));
            }
            checkDo.add(next);
        }
    }


    public static void main(String[] args) {
        //test1();
        //System.out.println(1.0d/0);
        System.out.println(1D/0);
        //System.out.println(1/0);
    }
}
