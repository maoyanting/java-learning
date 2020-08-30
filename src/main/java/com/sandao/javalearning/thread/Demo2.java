package com.sandao.javalearning.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * //评测题目: java多线程
 * //1、两个线程交替打印1-100的整数，一个打印奇数，一个打印偶数，要求输出结果有序
 * @author maoyanting
 * @version V1.0
 * @date 2020/05/20
 */
public class Demo2 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Thread thread2 = new Thread(() -> print(1,atomicInteger," odd: "));
        Thread thread = new Thread(() -> print(0,atomicInteger,"even: "));
        thread.start();
        thread2.start();
    }

    private static void print(int num,AtomicInteger atomicInteger,String name){
        while (atomicInteger.get() <= 100) {
            if (atomicInteger.get() % 2 == num && atomicInteger.get() <= 100) {
                System.out.println(name+ atomicInteger.get());
                atomicInteger.incrementAndGet();
            }
        }
    }
}
