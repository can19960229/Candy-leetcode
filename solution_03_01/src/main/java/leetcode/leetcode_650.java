package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/24 21:23
 *
 * @Classname leetcode_650
 * Description: 测试
 */

/**
 *
 */
public class leetcode_650 {
    public static int minSteps(int n){
        int[] dp = new int[n+1];
        int h=(int) Math.sqrt(n);
        for (int i=2;i <= n;i++){
            dp[i] = i;
            for (int j = 2; j <= h; j++) {
                if (i % j == 0){
                    dp[i] = dp[j] + dp[i/j];
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(3));
    }
}
