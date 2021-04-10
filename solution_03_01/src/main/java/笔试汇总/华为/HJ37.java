package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/10 19:18
 *
 * @Classname HJ37
 * Description: 统计每个月兔子的总数
 */

import java.util.Scanner;

/**
 * 斐波那契数列
 */
public class HJ37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int monthCount = sc.nextInt();
            int result = getTotalCount(monthCount);
            System.out.println(result);
        }
    }

    private static int getTotalCount(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n ; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        return f[n];
    }


}
