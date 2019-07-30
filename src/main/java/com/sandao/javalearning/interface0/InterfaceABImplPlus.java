package com.sandao.javalearning.interface0;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/30
 */
public class InterfaceABImplPlus implements InterfaceA, InterfaceB {
    /**
     * 实现的两个接口有相同的default 方法 必须覆写 但是又想实现某个接口的default方法
     */
    @Override
    public void defaultPrint() {
        InterfaceA.super.defaultPrint();
    }

    @Override
    public void print() {
        System.out.println("普通 print 方法");
    }
}
