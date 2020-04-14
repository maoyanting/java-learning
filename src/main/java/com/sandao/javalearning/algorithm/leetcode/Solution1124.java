package com.sandao.javalearning.algorithm.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
 * Return the length of the longest well-performing interval.
 *
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 *
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/11
 */
public class Solution1124 {
    public static void main(String[] args) {
        int[] example = new int[]{9,9,6,0,6,6,9};
//        int[] example = new int[]{6,6,9};
//        int[] example = new int[]{6,6,9};
        System.out.println(longestWPI(example));
    }

    /**
     * 题目分解下来就是 每一段时间内的 大于8的次数要大于小于8的次数，寻找最长的时间段
     * 数据量巨大的情况下，考虑到n^2 的时间会超长，需要优化
     * how to update it ?
     * if it is 每次都获取一部分
     * duiyu j laishuo i yijing bianli guo  yibenfen l ,suoyi qishi
     *
     */
    public static int longestWPI(int[] hours) {
        int[] count = new int[hours.length];
        Arrays.fill(count,0);
        int max = 0;

        for (int i = 0; i < hours.length; i++) {
            for (int j = i; j < hours.length; j++) {
                int countNum = 0;
                for (int m = i;m < j +1; m++){
                    if (hours[m] > 8){
                        countNum++;
                    } else{
                        countNum--;
                    }
                }
                if (countNum > 0 && j-i+1 > count[i]){
                    count[i] = j-i+1;
                }
            }
            if (count[i] > max){
                max = count[i];
            }
        }
        return max;
    }

    public static int longestWPI2(int[] hours) {
        int length = hours.length;
        int[] count = new int[length];
        Map<Integer, List<Integer>> integerListMap = new HashMap<>();
        Arrays.fill(count,0);
        int max = 0;
        for (int i = 0;i < length;i++){
            for (int j = 0;j < length; j++){

            }
        }
        return max;
    }
}
