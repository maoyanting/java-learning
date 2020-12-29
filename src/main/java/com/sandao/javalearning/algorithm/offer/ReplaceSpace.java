package com.sandao.javalearning.algorithm.offer;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2020/09/12
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("helloworld ")));
        System.out.println(replaceSpace(new StringBuffer(" helloworld")));
        System.out.println(replaceSpace(new StringBuffer("hello world")));
    }

    public static String replaceSpace(StringBuffer str) {
        int length = str.length();
        for(int i  = 0; i < length;i++){
            char current = str.charAt(i);
            if(' ' == current){
                str.append("  ");
            }
        }

        for(int i = length-1,j = str.length()-1;i>-1;i--){
            char current = str.charAt(i);
            if(' ' == current){
                str.setCharAt(j--,'0');
                str.setCharAt(j--,'2');
                str.setCharAt(j--,'%');
            }else {
                str.setCharAt(j--,current);
            }
        }
        return str.toString();
    }
}
