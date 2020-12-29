package com.sandao.javalearning.algorithm.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2020/09/12
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int[] num = {16,14,12,10,8,6,4};
        System.out.println(maxInWindows2(num,5));
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) {
            return ret;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        /* 大顶堆 */
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        ArrayList<Integer> ret = new ArrayList<>();
        if (size == 0 || num.length == 0){
            return ret;
        }
        int i = 0;
        for(int n : num){
            if(i >= size){
                max.remove(num[i-size]);
            }
            max.add(n);
            if(i >= size-1){
                ret.add(max.peek());
            }
            i++;
        }
        return ret;
    }
}
