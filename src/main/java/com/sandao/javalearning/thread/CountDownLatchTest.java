package com.sandao.javalearning.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 代码来自：https://juejin.im/post/5aeec3ebf265da0ba76fa327
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/10
 */
public class CountDownLatchTest {
    private static CountDownLatch startSignal = new CountDownLatch(1);
    //用来表示裁判员需要维护的是6个运动员
    private static CountDownLatch endSignal = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(6, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        //这里问题使，所有线程可能都还没有准备好，发令员就准备开始了。
        for (int i = 0; i < 6; i++) {
            pool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 运动员等待裁判员响哨！！！");
                    //此处 startSignal 使所有线程暂停，等待 startSignal执行
                    startSignal.await();
                    System.out.println(Thread.currentThread().getName() + "正在全力冲刺");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName() + "  到达终点");
                    endSignal.countDown();
                }
            });
        }
        System.out.println("裁判员发号施令啦！！！");
        //此处 startSignal 使所有线程开始
        startSignal.countDown();
        //此处 等待 endSignal 所有线程执行完毕
        endSignal.await();
        System.out.println("所有运动员到达终点，比赛结束！");
        pool.shutdown();
    }
}
