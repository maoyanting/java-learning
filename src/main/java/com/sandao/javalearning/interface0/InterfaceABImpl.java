package com.sandao.javalearning.interface0;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/30
 */
public class InterfaceABImpl implements InterfaceA, InterfaceB {
    /**
     * 如果同时实现的两个接口都有相同的default方法，则必须覆写该方法
     */
    @Override
    public void defaultPrint() {
        System.out.println("实现的A、B接口有相同的default 方法 必须覆写");
    }

    @Override
    public void print() {
        System.out.println("普通 print 方法");
    }
}
