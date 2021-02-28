package some_problem;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/2/27 15:45
 *
 * @Classname argueCount
 * Description: 丑数问题
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class uglyCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] spilt = sc.nextLine().trim().split(",");
        int[] array = new int[spilt.length];
        for (int i = 0; i < spilt.length; i++) {
            array[i] = Integer.valueOf(spilt[i]);
        }
        int res = rob2(array);
        System.out.println(res);
    }

    private static int rob2(int[] nums) {

        int n = nums.length;
        if (n ==0) return 0;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0 ; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i],nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }
}
