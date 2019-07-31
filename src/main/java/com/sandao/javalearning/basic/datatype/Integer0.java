package com.sandao.javalearning.basic.datatype;

/**
 * 整型
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/29
 */
public class Integer0 {
    public static void main(String[] args) {
        testNumberType();
        testCache();
    }

    /**
     * jdk1.7以后，允许在数字之间增加下划线来提高代码可读性
     */
    private static void testNumberType(){
        int a = 100__000, b = 100000, c = 10_0000;
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
    }

    /**
     * 缓存适用于整数值区间-128 至 +127。
     * Byte, Short, Long 同理
     * 此处使用了自动装箱，实际上为调用 Integer.valueOf(125)
     * 缓存的主要原因在于 valueOf 方法中的 IntegerCache 内部类
     */
    private static void testCache(){
        Integer a = 125;
        Integer b = 125;
        Integer c = 129;
        Integer d = 129;
        System.out.print("两个整型 125 对比：");
        System.out.println(a == b);
        System.out.print("两个整型 129 对比：");
        System.out.println(d == c);
    }
}
