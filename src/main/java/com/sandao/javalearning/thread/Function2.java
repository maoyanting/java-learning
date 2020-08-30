package com.sandao.javalearning.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2020/05/20
 */
@Slf4j
public class Function2 {

    private static final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("readLog-pool-%d").build();
    private static final ExecutorService pool = new ThreadPoolExecutor(2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    private static final int MAX_NUM = 100;

    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(1);
        pool.execute(() -> print(num,"even: ",0));
        pool.execute(() -> print(num," odd: ",1));
    }

    /**
     * print
     */
    private static void print(AtomicInteger num,String name,int remainder){
        while (num.get() <= MAX_NUM){
            if (num.get() %2 ==remainder && num.get() <= MAX_NUM){
                System.out.println(name+num.get());
                num.incrementAndGet();
            }
        }
    }
}


