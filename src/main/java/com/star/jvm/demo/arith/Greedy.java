package com.star.jvm.demo.arith;

import java.util.*;

/**
 * 贪婪算法-近似算法
 * 广播台覆盖问题实现
 */
public class Greedy {

    /**
     * # 地域集合
     * states_needed = set(["mt", "wa", "or", "id", "nv", "ut","ca", "az"])
     * # 广播台覆盖地域的散列表
     * stations = {}
     * stations["kone"] = set(["id", "nv", "ut"])
     * stations["ktwo"] = set(["wa", "id", "mt"])
     * stations["kthree"] = set(["or", "nv", "ca"])
     * stations["kfour"] = set(["nv", "ut"])
     * stations["kfive"] = set(["ca", "az"])
     */

    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet<>();
        statesNeeded.addAll(Arrays.asList("mt","wa","or","id","nv","ut","ca","az"));
        Map<String,Set<String>> stations = new HashMap<>();
        stations.put("kone",new HashSet<>());
        stations.get("kone").addAll((Arrays.asList("id","nv","ut")));
        stations.put("ktwo",new HashSet<>());
        stations.get("ktwo").addAll((Arrays.asList("wa","id","mt")));
        stations.put("kthree",new HashSet<>());
        stations.get("kthree").addAll((Arrays.asList("or","nv","ca")));
        stations.put("kfour",new HashSet<>());
        stations.get("kfour").addAll((Arrays.asList("nv","ut")));
        stations.put("kfive",new HashSet<>());
        stations.get("kfive").addAll((Arrays.asList("ca","az")));
        //最佳广播台集合
        List<Set<String>> result = new ArrayList<>();
        //循环地域
        while (!statesNeeded.isEmpty()){
            //当前最佳集合
            Set<String> bestSet = null;
            //已经被覆盖的地域/上一次的集合之间的交集
            Set<String> interSet = new HashSet<>();
            //遍历广播台散列表
            for (Map.Entry<String, Set<String>> entry : stations.entrySet()) {
                Set<String> interItem = getIntersection(entry.getValue(), statesNeeded);
                //这一次的交集，大于上一次的交集，说明这一次广播台覆盖的区域更多
                if(interItem.size() > interSet.size()){
                    bestSet = entry.getValue();
                    interSet = interItem;
                }
            }
            //去除已经覆盖的地域
            removeSet(statesNeeded,interSet);
            //将最佳广播台添加到结果
            result.add(bestSet);
        }
        System.out.println(result);
    }

    /**
     * 获取两个Set集合之间的交集
     * @param oneSet
     * @param twoSet
     * @return
     */
    private static Set<String> getIntersection(Set<String> oneSet,Set<String> twoSet){
        Set<String> result = new HashSet<>();
        Iterator<String> iterator = oneSet.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(twoSet.contains(next)){
                result.add(next);
            }
        }
        return result;
    }

    /**
     * 根据源集合去除已存在的数据
     * @param sourceSet
     * @param removeSet
     */
    private static void removeSet(Set<String> sourceSet,Set<String> removeSet){
        Iterator<String> iterator = removeSet.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            sourceSet.remove(next);
        }
    }
}
