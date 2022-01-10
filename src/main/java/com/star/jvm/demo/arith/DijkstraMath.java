package com.star.jvm.demo.arith;

import java.util.*;

/**
 * 狄克斯特拉算法
 */
public class DijkstraMath {

    //图,对应key的map记录对应节点到所有相邻节点的权重
    static Map<String, Map<String,Double>> graph = new HashMap<>();

    //起点到所有其他节点花费的时间
    static Map<String,Double> costs = new HashMap<>();

    //每个节点的父节点，主要是通过父节点来维护路径，最终形成的就是最短路径
    static Map<String,String> parents = new HashMap<>();

    //已检查数组
    static List<String> checkNode = new ArrayList<>();

    public static void main(String[] args) {
        //初始化图数据
        init();
        //被检查过的节点
        //获取距离起点开销最小的节点
        String minCostNode = getMinCostNode(costs);
        Double cost = costs.get(minCostNode);
        while (minCostNode!=null){
            //获取开销最小节点的相邻节点
            Map<String, Double> neighborMap = graph.get(minCostNode);
            //判断经过当前节点到达的开销是否小于初始化的开销，如果小于则更新开销及其父节点
            for (Map.Entry<String, Double> neighborItem : neighborMap.entrySet()) {
                if((neighborItem.getValue()+cost)<costs.get(neighborItem.getKey())){
                    //更新开销
                    costs.put(neighborItem.getKey(),(neighborItem.getValue()+cost));
                    //更新其父节点
                    parents.put(neighborItem.getKey(),minCostNode);
                }
            }
            //检查完成所有相邻节点，就加入已检查数组
            checkNode.add(minCostNode);
            //开销，已检查节点，都更新完了，接着下一轮检查，直到检查完所有节点为止
            minCostNode = getMinCostNode(costs);
            cost = costs.get(minCostNode);
        }
        //对应父节点map结果
        System.out.println("parents"+parents);
        //对应开销map结果
        System.out.println("costs"+costs);
        String nodeStr = "fin";
        //新增一个集合，根据将最短路径根据经过顺序加入集合
        List<String> nodeWay = new ArrayList<>();
        nodeWay.add(nodeStr);
        while (!nodeStr.equals("start")){
            nodeWay.add(parents.get(nodeStr));
            nodeStr = parents.get(nodeStr);
        }
        Collections.reverse(nodeWay);
        //加权有向图，最短路径结果
        System.out.println(nodeWay);
    }

    /**
     * 获取
     * @param map
     * @return
     */
    public static String getMinCostNode(Map<String,Double> map){
        Double min = Double.POSITIVE_INFINITY;
        String minStr = null;
        for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet()) {
            boolean anyMatch = checkNode.stream().anyMatch(a -> a.equals(stringDoubleEntry.getKey()));
            //最小开销，且不存在已检查数组中则更新
            if(stringDoubleEntry.getValue()<min && !anyMatch){
                minStr = stringDoubleEntry.getKey();
                min = stringDoubleEntry.getValue();
            }
        }
        return minStr;
    }

    public static void init(){
        //初始化数据
        graph.put("start",new HashMap<>());
        graph.put("A",new HashMap<>());
        graph.put("B",new HashMap<>());
        graph.put("fin",new HashMap<>());
        graph.get("start").put("A",6.0);
        graph.get("start").put("B",2.0);
        graph.get("A").put("fin",1.0);
        graph.get("B").put("A",3.0);
        graph.get("B").put("fin",5.0);
        //初始化数据
        costs.put("A",6.0);
        costs.put("B",2.0);
        costs.put("fin",Double.POSITIVE_INFINITY);
        //初始化数据
        parents.put("A","start");
        parents.put("B","start");
        parents.put("fin",null);
    }

}