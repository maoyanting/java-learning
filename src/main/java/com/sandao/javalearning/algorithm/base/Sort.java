package com.sandao.javalearning.algorithm.base;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author maoyanting
 * @version V1.0
 * @date 2020/08/29
 */
public class Sort {

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort(int[] nums){
        int N = nums.length;
        boolean isSorted = false;
        for (int i = N - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j + 1] < nums[j]) {
                    isSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param nums
     */
    public static void selectionSort(int[] nums){
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    public static void insertionSort(int[] nums){
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序基本
     */
    private static void mergeSort(int[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }

    /**
     * 归并排序的归并
     */
    private static void merge(int[] nums, int l, int m, int h) {

        int[] aux = new int[nums.length];
        int i = l, j = m + 1;

        for (int k = l; k <= h; k++) {
            // 将数据复制到辅助数组
            aux[k] = nums[k];
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                // 先进行这一步，保证稳定性
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序基本递归
     */
    private static void quickSort(int[] nums, int l, int h) {
        if (h <= l){
            return;
        }
        int j = partition(nums, l, h);
        quickSort(nums, l, j - 1);
        quickSort(nums, j + 1, h);
    }

    /**
     * 快排的切分
     */
    private static int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        int v = nums[l];
        while (true) {
            while (nums[++i] <  v && i != h) ;
            while ( v < nums[--j] && j != l) ;
            if (i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums,int i,int j){
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }

    public static void main(String[] args) {
        int[] num = {3,4,1,6,8,2,3,5};
        bubbleSort(num);
        System.out.println(Arrays.toString(num));

        int[] numA = {3,4,1,6,8,2,3,5};
        selectionSort(numA);
        System.out.println(Arrays.toString(numA));

        int[] numB = {3,4,1,6,8,2,3,5};
        insertionSort(numB);
        System.out.println(Arrays.toString(numB));

        int[] numC = {3,4,1,6,8,2,3,5};
        mergeSort(numC);
        System.out.println(Arrays.toString(numC));

        int[] numd = {3,4,1,6,8,2,3,5};
        quickSort(numd);
        System.out.println(Arrays.toString(numd));
    }
}
