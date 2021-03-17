package content;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/14 21:11
 *
 * @Classname test_10
 * Description: 测试
 */

import java.util.Scanner;

/**
 *
 */
public class test_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[500];
        int[] sum = new int[500];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 600000; i++) {
            int x = f(i);

            if(cnt[x] < n) {
                cnt[x]++;
                sum[x] += i;
            }
            if (cnt[x] == n) {
                ans = Math.min(ans, sum[x]);
            }


        }
        System.out.println(ans);


    }
    public static int f(int x) {
        int tot = 0;
        while (x != 0) {
            tot += x % 10;
            x /= 10;
        }
        return tot;
    }
}
