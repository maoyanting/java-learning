package com.sandao.javalearning.algorithm.leetcode;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/23
 */
public class Solution268 {
    public static void main(String[] args) {
        int[] example = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(example));
    }

    public static int missingNumber(int[] nums) {
        int[] result = new int[nums.length+1];
        Arrays.fill(result,0);
        for (int i : nums){
            result[i] = 1;
        }
        for (int i = 0; i < result.length; i++){
            if (result[i] == 0){
                return i;
            }
        }
        return 0;
    }
}
