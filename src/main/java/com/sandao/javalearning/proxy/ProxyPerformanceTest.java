package com.sandao.javalearning.proxy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 代码来自：https://zhuanlan.zhihu.com/p/67041662
 * 总结 ：Cglib 创建代理对象的速度明显比JDK慢
 * JDK代理 执行方法的 速度会 随着执行次数的增加变快，会比CGlib还快
 * JDK8的情况下
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/04
 */
public class ProxyPerformanceTest {
    public static void main(String[] args) {
        runTest();
    }

    //Cglib 执行方法的 速度会 随着执行次数的增加变快，会比JDK还快
    private static void runTest() {
        //创建测试对象
        Target nativeTest = new TargetImpl();

        //Cglib 创建代理对象的速度明显比JDK慢
        long start = System.currentTimeMillis();
        Target dynamicProxy = JdkDynamicProxyTest.newProxyInstance(nativeTest);
        long end = System.currentTimeMillis();
        System.out.println("[ dynamicProxy ] build Time:" + (end - start) + "ms");

        long startB = System.currentTimeMillis();
        Target cglibProxy = CglibProxyTest.newProxyInstance(TargetImpl.class);
        long endB = System.currentTimeMillis();
        System.out.println("[ Cglib ] build Time:" + (endB - startB) + "ms");

        //预热一下（预热过后 JDK代理的执行速度明显变快）
        int preRunCount = 10000;
        runWithoutMonitor(nativeTest, preRunCount);
        runWithoutMonitor(cglibProxy, preRunCount);
        runWithoutMonitor(dynamicProxy, preRunCount);

        //执行测试
        Map<String, Target> tests = new LinkedHashMap<>();
        tests.put("Native   ", nativeTest);
        tests.put("Dynamic  ", dynamicProxy);
        tests.put("Cglib    ", cglibProxy);
        int repeatCount = 3;
        int runCount = 1000000;
        runTest(repeatCount, runCount, tests);
        runCount = 50000000;
        runTest(repeatCount, runCount, tests);
    }


    private static void runTest(int repeatCount, int runCount, Map<String, Target> tests) {
        System.out.println(
                String.format("\n===== run test : [repeatCount=%s] [runCount=%s] [java.version=%s] =====",
                        repeatCount, runCount, System.getProperty("java.version")));
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(String.format("\n--------- test : [%s] ---------", (i + 1)));
            for (String key : tests.keySet()) {
                runWithMonitor(tests.get(key), runCount, key);
            }
        }
    }

    private static void runWithoutMonitor(Target target, int runCount) {
        for (int i = 0; i < runCount; i++) {
            target.test(i);
        }
    }

    private static void runWithMonitor(Target target, int runCount, String tag) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < runCount; i++) {
            target.test(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("[" + tag + "] Total Time:" + (end - start) + "ms");
    }
}
