package com.sandao.javalearning.algorithm.leetcode;

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

    }

    /**
     * 题目分解下来就是 每一段时间内的 大于8的次数要大于小于8的次数，寻找最长的时间段
     */
    public int longestWPI(int[] hours) {

        for (int i = 0; i < hours.length; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        return 1;
    }
}
