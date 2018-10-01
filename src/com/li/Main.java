package com.li;

public class Main {

    public static void main(String[] args) {
        int order = 1000;  //每个节点关键字个数的最大值
        //创建索引
        BplusTree<String, String> tree = new BplusTree(order);
        long startTime=System.currentTimeMillis();
        //向索引中插入数据
        tree.testRandomInsert(tree);
        //查找数据
        tree.testRandomSearch(tree);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
