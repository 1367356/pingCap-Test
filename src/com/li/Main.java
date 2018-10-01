package com.li;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int size = 5;  //总数据大小
        int order = 4;  //每个节点关键字的最大值
        BplusTree<String, String> tree = new BplusTree(order);
        tree.testRandomInsert(tree);
        tree.testRandomSearch(tree);
    }
}
