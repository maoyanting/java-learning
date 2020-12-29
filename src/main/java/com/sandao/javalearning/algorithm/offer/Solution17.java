package com.sandao.javalearning.algorithm.offer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 * @author maoyanting
 * @version V1.0
 * @date 2020/09/12
 */
public class Solution17 {
    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }


    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        //构造大小为n数组
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private static void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            //这个数组已经被填满了
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            //递归填写下一个位置的数字
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    /**
     * 打印数组
     * @param number
     */
    private static void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

}
