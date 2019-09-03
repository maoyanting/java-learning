package com.sandao.javalearning.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/03
 */
public class Solution673 {
    /**
     * Given an unsorted array of integers, find the number of longest increasing subsequence.
     *
     * Example 1:
     * Input: [1,3,5,4,7]
     * Output: 2
     * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
     * Example 2:
     * Input: [2,2,2,2,2]
     * Output: 5
     * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
     * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
     */
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLISMySelf(nums));
    }
    /**
     * 寻找最长递增子序列 的个数
     */
    public static int findNumberOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        // nums[i]之前的最长递增数列 的 长度
        int[] len = new int[nums.length];
        // nums[i]之前的最长递增数列 的 个数
        int[] count = new int[nums.length];
        //数组填充
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);
        //子序列的个数
        int lisCount = 0;
        //子序列的长度
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //相对于 nums[j] 是递增的状态下
                if (nums[i] > nums[j]) {
                    //如果当前 的 子序列长度 正好是 nums[j] 的子序列的长度 +1
                    if (len[i] == len[j] + 1) {
                        //这里注意是相加。
                        count[i] += count[j];
                    } else if (len[i] < len[j] + 1) {
                        //len[i] 的子序列还没有 nums[j] 的子序列的长度 长 ；还是递增的话，就在 len[j] 的基础上加1，子序列的数量一致。
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }

                }
            }
            System.out.println("---- i: "+i+" len: "+Arrays.toString(len));
            System.out.println("---- i: "+i+" len: "+Arrays.toString(count));
            if (maxLength == len[i]) {
                //如果当前递增数列的长度和现有最长子序列相同，增加1
                lisCount += count[i];
            } else if (maxLength < len[i]) {
                //如果 更大 则更换最长子序列
                maxLength = len[i];
                lisCount = count[i];
            }
        }
        return lisCount;
    }

    public static int findNumberOfLISMySelf(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        //最长子序列的长度和个数
        int maxLength = 0;
        int maxCount = 0;
        //
        int[] maxLengthArray = new int[nums.length];
        int[] maxCountArray = new int[nums.length];
        Arrays.fill(maxLengthArray,1);
        Arrays.fill(maxCountArray,1);

        for (int i =0;i < nums.length;i++){
            for (int j = 0;j < i;j++){
                if (nums[i] > nums[j]){
                    if (maxLengthArray[i] == maxLengthArray[j] + 1){
                        maxCountArray[i] += maxCountArray[j] + maxCountArray[i];
                    }else if (maxLengthArray[i] < maxLengthArray[j] + 1){
                        maxLengthArray[i] = maxLengthArray[j] + 1;
                        maxCountArray[i] = maxCountArray[j];
                    }
                }
            }

            if (maxLength  == maxLengthArray[i]){
                maxCount = maxCountArray[i] +maxCount;
            }else if (maxLength < maxLengthArray[i]){
                maxLength = maxLengthArray[i];
                maxCount = maxCountArray[i];
            }
        }
        return maxCount;
    }
}
