package com.sandao.javalearning.interface0;

/**
 * 接口
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/30
 */
public interface InterfaceA {

    /**
     * default 方法 jdk1.8以后
     */
    default void defaultPrint(){
        System.out.println("A接口的default 方法");
    }

    static void staticPrint(){
        System.out.println("A接口的static 方法");
    }

    void print();
}
