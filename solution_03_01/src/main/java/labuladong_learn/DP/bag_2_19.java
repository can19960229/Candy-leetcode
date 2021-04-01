package labuladong_learn.DP;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/1 11:17
 *
 * @Classname bag_2_19
 * Description: 测试
 */

import java.util.HashMap;

/**
 *
 */
public class bag_2_19 {
    static int result = 0;
    /**
     * 回溯法
     */
    static int findTargetSumWays_1(int[] nums, int target){
        if (nums.length == 0)
            return 0;
        backtrack(nums,0,target);
        return result;
    }

    private static void backtrack(int[] nums, int i, int rest) {
        //base case
        if(i == nums.length){
            if (rest == 0){
                //说明恰好凑出target
                result++;
            }
            return;
        }
        //给nums[i] 选择 - 号
        rest += nums[i];
        //穷举nums[i+1]
        backtrack(nums, i+1, rest);
        //撤销选择
        rest -= nums[i];

        //给nums[i]选择 + 号
        rest -= nums[i];
        //穷举nums[i+1]
        backtrack(nums,i+1,rest);
        //撤销选择
        rest += nums[i];
    }

    /**
     * 消除重复子问题
     */
    public static int findTargetSumWays_2(int[] nums,int target){
        if (nums.length == 0)
            return 0;
        return dp(nums,0,target);
    }

    //备忘录
    private static HashMap<String,Integer> memo = new HashMap<>();
    private static int dp(int[] nums, int i, int rest) {
        //base case
        if(i == nums.length){
            if (rest == 0)
                return 1;
            return 0;
        }
        //把它们转成字符串才能作为哈希表的键
        String key = i + "," + rest;
        System.out.println(key);
        //避免重复计算
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        //还是穷举
        int result = dp(nums,i + 1,rest - nums[i]) + dp(nums,i+1,rest + nums[i]);
        //记入备忘录
        memo.put(key,result);
        System.out.println(memo.toString());
        return result;
    }

    /**
     * 动态规划
     *
     */
     public static int findTargetSumWays_3(int[] nums,int target){
         int sum = 0;
         for (int n : nums) {
             sum += n;
         }
         //这两种情况，不可能存在合法的子集划分
         if (sum < target || (sum + target) % 2 == 1){
             return 0;
         }
         return subsets(nums,(sum + target) / 2);
     }

     //状态转移方程：dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]
    private static int subsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1]){
                    //两种选择的结果之和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }else {
                    //背包的空间不足，只能选择不装物品
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
         return dp[n][sum];
    }

    /**
     * 一维状态的动态规划
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays(int[] nums,int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        //这两种情况，不可能存在合法的子集划分
        if (sum < target || (sum + target) % 2 == 1){
            return 0;
        }
        return subsets_1(nums,(sum + target) / 2);
    }

    private static int subsets_1(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        //base case
        dp[0] = 1;
        for (int i = 1;i <= n;i++){
            //j要从后往前遍历
            for (int j = sum;j >= 0;j--){
                //状态转移方程
                if (j >= nums[i - 1]){
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }else {
                    dp[j] = dp[j];
                }
            }
        }
         return dp[sum];
    }


    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,3,1,4,2},5));
    }
}
