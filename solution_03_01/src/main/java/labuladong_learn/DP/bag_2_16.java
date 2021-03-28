package labuladong_learn.DP;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/28 19:40
 *
 * @Classname bag_2_16
 * Description: 测试
 */

/**
 *
 */
public class bag_2_16 {
    public static boolean canPartition(int[] nums){
        int sum = 0;
        for (int num : nums)
            sum += num;
        //和为奇数，则不可能分成两个和相等的集合
        if (sum % 2 != 0){
            return false;
        }
        int n = nums.length;
        sum = sum / 2;
        //构建dp数组
        boolean[][] dp = new boolean[n + 1][sum + 1];
        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        //开始状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0){
                    //背包容量不足，肯定不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                }else {
                    //装入或装入背包
                    //看着是否存在一种情况能够切好装满
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
    public static boolean canPartition_1(int[] nums) {
        int sum = 0,n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        //base case
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];

    }


     public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
}
