package com.sandao.javalearning.algorithm.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2020/09/08
 */
public class PrintList {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode nodeA = new ListNode(4);
        ListNode nodeB = new ListNode(9);
        ListNode nodeC = new ListNode(1);
        node.next = nodeA;
        nodeA.next = nodeB;
        nodeB.next = nodeC;
//        System.out.println(printListFromTailToHead(node));
        System.out.println(printListFromTailToHeadA(node));
//        System.out.println(printListFromTailToHeadB(node));
    }

    /**
     * 递归
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHeadA(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHeadA(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    public static ArrayList<Integer> printListFromTailToHeadB(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }


}
