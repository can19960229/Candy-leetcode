package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/10 19:58
 *
 * @Classname HJ91
 * Description: 走方格的方案数
 */

import java.util.Scanner;

/**
 *
 */
public class HJ91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(methods(num1,num2));
            System.out.println(count(num1 + 1,num2 + 1));
        }
    }

    /**
     * 递归
     * @param num1
     * @param num2
     * @return
     */
    private static int methods(int num1, int num2) {

        if (num1 ==0 || num2 == 0){
            return 1;
        }
        return methods(num1 - 1,num2) + methods(num1,num2 - 1);
    }

    /**
     * DP
     * @param n
     * @param m
     * @return
     */
    public static int count(int n, int m) {
        int[][] dp = new int [n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
