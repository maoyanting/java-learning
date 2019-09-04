package com.sandao.javalearning.collection;

import java.util.Stack;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/04
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //入栈
        stack.push(3444);
        stack.push(3445);
        stack.push(3446);
        //出栈
        System.out.println("let first out :"+stack.pop());
        //判定是否为空
        System.out.println("is empty ? "+stack.empty());
        //获取栈顶元素
        System.out.println("get first :"+stack.peek());
        //查找元素 如果在返回位置（栈顶元素为1），不在返回-1。
        System.out.println("search 3444 :"+stack.search(3444));
        System.out.println("search 3445 :"+stack.search(3445));
        //
        stack.pop();
        stack.pop();
        //判定是否为空
        System.out.println("is empty ? "+stack.empty());
        //元素全部出栈以后，再pop/peek 则抛出异常 EmptyStackException
        stack.pop();
    }
}
