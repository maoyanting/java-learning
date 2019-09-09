package com.sandao.javalearning.algorithm.leetcode;

/**
 * Given a string S, count the number of distinct, non-empty subsequences of S .
 * 寻找非空子序列
 * Since the result may be large, return the answer modulo 10^9 + 7.
 *
 * S contains only lowercase letters.
 * 1 <= S.length <= 2000
 *
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/09
 */
public class Solution940 {
    public static void main(String[] args) {

    }

    public static int distinctSubseqII(String S) {
        int[] dict = new int[26];
        int total = 1;
        for (char c : S.toCharArray()) {
            // 新生成的 - 重复的（原有的字母的）
            int combo = total * 2 - dict[c - 'a'];
            // 如果字母是重复了，则会刷新当前数量为之前的总数
            dict[c - 'a'] = total;
            // mod and fix negative mods
            total = combo < 0 ? combo + 1000000007 : combo % 1000000007;
        }
        // Subtract the empty string
        return total - 1;
    }
}
