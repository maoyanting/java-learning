package com.sandao.javalearning.basic.datatype;

/**
 * 字符串
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/22
 */
public class String0 {
    public static void main(String[] args) {
        testReplaceAll();
        testTrim();
    }

    /**
     * 驼峰 转 下划线
     */
    private static void testReplaceAll(){
        String word = "createTime";
        String regex = "([A-Z])+";
        System.out.println("驼峰 转 下划线:"+word.replaceAll(regex, "_$1").toLowerCase());
    }

    /**
     * 去掉头尾空格
     */
    private static void testTrim(){
        String word = "    去掉头尾空格     ";
        System.out.println(word.trim());
    }

    private static void testSpilt(){
        String range = "1-5";
        String range2 = "100-";
        String[] rangeS1 = range.split("-");
        String[] rangeS2 = range2.split("-");
        System.out.println(rangeS1[0]);
        System.out.println(rangeS1[1]);
        System.out.println(rangeS2[0]);
        System.out.println(rangeS2[1]);
    }

}
