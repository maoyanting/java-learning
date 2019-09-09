package com.sandao.javalearning.function;

import java.util.concurrent.*;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/09
 */
public class InnerClasses {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        final Future<?> task1 = ForkJoinPool.commonPool().submit(() ->{
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                latch.countDown();
            }
        });
        final Future<?> task2 = ForkJoinPool.commonPool().submit(() -> {
            final long start = System.currentTimeMillis();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Done after " + (System.currentTimeMillis()
                        - start) + "ms");
            }
        });
        try {
            task1.get();
            task2.get();
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
}
