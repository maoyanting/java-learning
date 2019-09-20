package com.sandao.javalearning.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 创建线程池的几种方式
 * 不推荐使用 Executors 创建线程池
 * FixedThreadPool 和 SingleThreadPool: 允许的请求队列长度为 Integer.MAX_VALUE，会造成OOM
 * CachedThreadPool 和 ScheduledThreadPool: 允许的创建线程数量为 Integer.MAX_VALUE，会造成OOM
 *
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/10
 */
public class ThreadPool {
    public static void main(String[] args) {
        System.out.println("不推荐：使用 Executors  创建线程池");
//        testThred1();
//        testUseExecutors();
//        testFixedThreadPool();
//        testSingleThreadExecutor();
//        testCachedThreadPool();
        testScheduledThreadPool();
    }

    private static void testThreadPoolExecutor() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("ThreadPoolExecutor-pool-%d").build();

        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 7; i++) {
            pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        pool.shutdown();
    }

//    private static void testT(){
//        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
//                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
//    }


    /**
     * FixedThreadPool 规定线程池运行的数量
     * 比如这里限定了线程池的大小是3，最多只有3个线程在同时运行
     * 队列：LinkedBlockingQueue 无界缓存的等待队列。
     */
    private static void testFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            executorService.execute(() -> {
                System.out.println("FixedThreadPool : " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }

    /**
     * SingleThreadExecutor 只有一个线程在运行
     * 队列：LinkedBlockingQueue 无界缓存的等待队列。
     */
    private static void testSingleThreadExecutor() {
        //永远只有一个线程在运行
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 6; i++) {
            executorServiceSingle.execute(() -> {
                System.out.println("SingleThreadExecutor : " + Thread.currentThread().getName());
            });
        }
        executorServiceSingle.shutdown();
    }

    /**
     * CachedThreadPool
     * 线程池：无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
     * 队列：SynchronousQueue
     */
    private static void testCachedThreadPool() {
        ExecutorService executorServiceCache = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            executorServiceCache.execute(() -> {
                System.out.println("CachedThreadPool : " + Thread.currentThread().getName());
            });
        }
        executorServiceCache.shutdown();
    }

    /**
     * ScheduledThreadPool
     * 创建一个定长线程池，支持定时及周期性任务执行
     * 队列：DelayedWorkQueue
     */
    private static void testScheduledThreadPool() {
        ScheduledExecutorService executorServiceScheduled = Executors.newScheduledThreadPool(6);


        for (int i = 0; i < 6; i++) {
            executorServiceScheduled.schedule(() -> System.out.println("ScheduledThreadPool : " + System.currentTimeMillis()+"  "+Thread.currentThread().getName()),3,TimeUnit.SECONDS);
        }

        executorServiceScheduled.shutdown();
    }
}
