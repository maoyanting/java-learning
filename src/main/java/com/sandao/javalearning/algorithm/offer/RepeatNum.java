package com.sandao.javalearning.algorithm.offer;

/**
 *
 * @author maoyanting
 * @version V1.0
 * @date 2020/09/08
 */
public class RepeatNum {

    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * @param args
     */
    public static void main(String[] args) {
        int[] num = {1,2,7,3,4,5,6,7,8};
        System.out.println(duplicate(num));
    }

    public static int duplicate(int[] nums) {
        int length = nums.length;
        if (length <= 0)
            return -1;
        for (int i = 0; i < length; i++) {
            //只要当前的位置不是位置的位数，就往后面开始替换
            while (nums[i] != i) {
                //看看这个位置的数字是不是已经在他位数已经存在了
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //不是则调换这个数字到他正确的位置
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
