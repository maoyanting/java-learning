package com.sandao.javalearning.interface0;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/30
 */
public interface InterfaceB {
    /**
     * default 方法 jdk1.8以后
     */
    default void defaultPrint(){
        System.out.println("B接口的 default 方法");
    }
}
