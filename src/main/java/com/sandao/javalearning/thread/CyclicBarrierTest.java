package com.sandao.javalearning.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/10
 */
public class CyclicBarrierTest {
    //指定必须有6个运动员到达才行
    private static CyclicBarrier barrier = new CyclicBarrier(6, () -> {
        System.out.println("所有运动员入场，裁判员一声令下！！！！！");
    });

    public static void main(String[] args) {
        System.out.println("运动员准备进场，全场欢呼............");

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("ThreadPoolExecutor-pool-%d").build();

        ExecutorService pool = new ThreadPoolExecutor(6, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 6; i++) {
            pool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 运动员，进场");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + "  运动员出发");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
