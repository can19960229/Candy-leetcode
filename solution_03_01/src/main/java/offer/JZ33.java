package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/21 9:39
 *
 * @Classname JZ33
 * Description: 丑数
 */

import java.util.Scanner;

/**
 *
 */
public class JZ33 {

    public static int ugly(int n){
        if(n <= 0)return 0;
        int p2 = 0,p3 = 0,p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2,Math.min(dp[p3] * 3,dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}
