package com.sandao.javalearning.interface0;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/30
 */
public class _InterfaceTest {

    public static void main(String[] args) {
        testDefault();
        testStatic();
        testExtend();
    }

    /**
     * 测试 default 方法
     */
    private static void testDefault(){
        //普通实现 不需要覆写
        InterfaceAImpl interfaceA = new InterfaceAImpl();
        interfaceA.defaultPrint();
        //实现的两个接口有相同的default 方法 必须覆写
        InterfaceABImpl interfaceAB = new InterfaceABImpl();
        interfaceAB.defaultPrint();
        //实现的两个接口有相同的default 方法 必须覆写 但是又想实现某个接口的default方法
        InterfaceABImplPlus interfaceABImplPlus = new InterfaceABImplPlus();
        interfaceABImplPlus.defaultPrint();

    }

    /**
     * 测试 接口的 static 方法
     */
    private static void testStatic(){
        InterfaceA.staticPrint();
    }

    private static void testExtend(){
        //如果子类继承父类，父类中有方法，该子类同时实现的接口中也有b方法，那么子类会继承父类的方法而不是实现接口中的方法
        InterfaceACImpl interfaceAC = new InterfaceACImpl();
        interfaceAC.defaultPrint();
    }
}
