package com.sandao.javalearning.algorithm.offer;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2020/09/12
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{64, 16, 4, 1};
        System.out.println(coinChange(coins,1024-200));
    }

    /**
     * 斐波那契算法
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { //将逆序遍历改为正序遍历
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
