package com.li;

import java.io.InputStream;
import java.util.Scanner;

/**
 * B+  树
 * @param <K>  键
 * @param <V>  值
 */
public class BplusTree<K extends Comparable<K>, V>{

    // 根节点
    protected BplusNode<K, V> root;

    // 每个节点的最大键值
    protected int order;

    // 叶子节点的链表头
    protected BplusNode<K, V> head;

    // 树高
    protected int height = 0;

    public BplusNode<K, V> getHead() {
        return head;
    }

    public void setHead(BplusNode<K, V> head) {
        this.head = head;
    }

    public BplusNode<K, V> getRoot() {
        return root;
    }

    public void setRoot(BplusNode<K, V> root) {
        this.root = root;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public V get(K key) {
        return root.get(key);
    }


    public void insertOrUpdate(K key, V value) {
        root.insertOrUpdate(key, value, this);

    }

    public BplusTree(int order) {
        if (order < 3) {
            System.out.print("order must be greater than 2");
            System.exit(0);
        }
        this.order = order;
        root = new BplusNode<K, V>(true, true);
        head = root;
    }


    /**
     * 根据键查找值
     * @param tree b+树索引
     */
    public void testRandomSearch(BplusTree<String, String> tree) {
        InputStream Systemin = this.getClass().getResourceAsStream("/searchData.txt");
        Scanner scanner = new Scanner(Systemin);
        while (scanner.hasNextLine()) {
            String key = scanner.nextLine();
            if (tree.get(key) == null) {
                System.out.println("索引中不存在键:" + key);
            }else {
                System.out.println("打印键"+key+"对应的值"+tree.get(key));
            }
        }
    }

    /**
     * 向索引中插入数据
     * @param tree
     */
    public void testRandomInsert(BplusTree<String, String> tree) {

        InputStream Systemin = this.getClass().getResourceAsStream("/insertData.txt");
        Scanner scanner = new Scanner(Systemin);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] strs = line.split(",");
            String key = strs[1];
            String value = strs[3].substring(0, strs[3].length() - 1);
            tree.insertOrUpdate(key, value);
        }

    }
}