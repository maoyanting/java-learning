package com.sandao.javalearning.algorithm.base;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author maoyanting
 * @version V1.0
 * @date 2020/08/29
 */
public class SortTest {

    /**
     * 冒泡排序
     * 注意点：不断交换，把最大值或者最小值往一遍推过去，然后就不要处理那里的数据了。
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        boolean isSorted = false;
        for (int i = 0; i < nums.length && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
        }
    }

    /**
     * 选择排序
     * 注意点：遍历选一个最小值，放到最右边，，然后就不要处理那里的数据了。
     *
     * @param nums
     */
    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = 0;
            for (int j = 0; j < n - i; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, min, n - i - 1);
        }
    }

    /**
     * 插入排序
     * 注意点：选一个值，不断比较交换
     *
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //此时i及前面的数组是有序的
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] nums) {
    }


    /**
     * 快速排序
     * 注意点：分区，递归
     */
    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        int part = part(nums, start, end);
        if (part - 1 > start) {
            quickSort(nums, start, part - 1);
        }
        if (part + 1 < end) {
            quickSort(nums, part + 1, end);
        }
    }

    /**
     * 区分
     */
    private static int part(int[] nums, int start, int end) {
        int part = nums[start];
        int j = end;
        int i = start + 1;
        for (; j > i; ) {
            if (nums[i] < part) {
                i++;
                continue;
            }
            if (nums[j] > part) {
                j--;
                continue;
            }
            swap(nums, i, j);
        }
        if (part > nums[j]) {
            swap(nums, start, j);
        } else {
            swap(nums, start, j - 1);
        }
        return j;
    }


    private static void swap(int[] nums, int i, int j) {
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, 1, 6, 8, 2, 3, 5};
        bubbleSort(num);
        System.out.println("bubbleSort" + Arrays.toString(num));

        int[] numA = {3, 4, 1, 6, 8, 2, 3, 5};
        selectionSort(numA);
        System.out.println("selectionSort" + Arrays.toString(numA));

        int[] numB = {3, 4, 1, 6, 8, 2, 3, 5};
        insertionSort(numB);
        System.out.println("insertionSort" + Arrays.toString(numB));

        int[] numC = {3, 4, 1, 6, 8, 2, 3, 5};
        mergeSort(numC);
        System.out.println("mergeSort" + Arrays.toString(numC));

        int[] numd = {3, 4, 1, 6, 8, 2, 3, 5};
        quickSort(numd);
        System.out.println("quickSort" + Arrays.toString(numd));
    }
}
