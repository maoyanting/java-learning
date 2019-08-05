package com.sandao.javalearning.algorithm.LRU;


import java.util.Hashtable;

/**
 * 来自网络
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/05
 */
public class LRUCache {
    /**
     * 用于快速获取节点
     */
    private Hashtable<String, DLinkedNode> cache = new Hashtable<>();
    /**
     * 当前节点数
     */
    private int count;
    /**
     * 容量
     */
    private int capacity;
    /**
     * 头尾节点
     */
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    /**
     * 获取节点时，把当前节点移到头部
     */
    public int get(String key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            // should raise exception here.
            return -1;
        }

        this.moveToHead(node);
        return node.value;
    }

    /**
     * 设置节点，如果存在，移动到头部
     * 如果不存在，新建节点
     */
    public void set(String key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                //尾部节点舍去
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * 添加头部节点（实质上是第二个节点）
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * 删除节点，获取当前节点的前后节点，拼接
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * 移动节点至头部，先删除节点，再添加节点至头部
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * 删除最后一个节点（实际上是最后第二个）
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
}
