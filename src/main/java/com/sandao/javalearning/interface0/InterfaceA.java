package com.sandao.javalearning.interface0;

/**
 * 接口
 *
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/30
 */
public interface InterfaceA {

    /**
     * 常量默认是public、static、final的
     */
    String CONSTANT = "接口的常量";

    /**
     * 方法默认是public、abstract的
     */
    void print();

    /**
     * default 方法 jdk1.8以后
     * 只能通过接口实现类的对象来调用。可以被覆写，但是不能再加default修饰符。
     */
    default void defaultPrint() {
        System.out.println("A接口的default 方法");
    }

    /**
     * 静态方法，只能通过接口名调用，不可以通过实现类的类名或者实现类的对象调用。
     */
    static void staticPrint() {
        System.out.println("A接口的static 方法");
    }
}
