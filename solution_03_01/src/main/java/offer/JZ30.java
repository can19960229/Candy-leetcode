package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/13 10:54
 *
 * @Classname JZ30
 * Description: 连续子数组的最大和
 */

/**
 *
 */
public class JZ30 {
    public int FindGreatestSumOfSubArray(int[] array){
        int len = array.length;
        if (len <= 0){
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        int res = array[0];
        for (int i = 1; i <= len ; i++) {
            dp[i] = Math.max(array[i - 1],dp[i - 1] + array[i - 1]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
