package labuladong_learn.DP;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/28 20:18
 *
 * @Classname bag_2_17
 * Description: 测试
 */

/**
 *
 */
public class bag_2_17 {
    public static int change_1(int amount,int[] coins){
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    //状态压缩，二维变一维
    public static int change(int amount,int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;//base case
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount ; j++) {
                if (j - coins[i] >= 0){
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5,new int[]{1,2,5}));
    }
}
