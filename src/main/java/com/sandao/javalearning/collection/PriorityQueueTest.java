package com.sandao.javalearning.collection;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/24
 */
public class PriorityQueueTest {
    /**
     * PriorityQueue内使用的是小顶堆的结构，所以为了维持二叉堆的特点，
     * 每向堆内插入一个元素的时候，都要维持好父节点的值大与两个子节点的值，所以需要遵循这样的插入算法：
     * <p>
     * 如果插入的节点值大于或等于它父节点的值，则插入成功。
     * 如果插入的节点值小于它父节点的值，则需要把刚插入的这个节点和它父节点做交换。交换后继续和它上层的父节点做比较，重复这个规则。
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(7);
        queue.add(3);
        queue.add(4);
        queue.add(2);
        queue.add(9);
        queue.add(1);

        //获取并移除一个元素
        Integer i = queue.poll();
        while (i != null) {
            System.out.println(i);
            i = queue.poll();
        }
    }
}
