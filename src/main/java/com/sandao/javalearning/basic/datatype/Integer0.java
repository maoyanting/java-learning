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
}
