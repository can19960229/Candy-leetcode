package labuladong_learn.DP;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/24 10:55
 *
 * @Classname four_Keys_Keyboard_2_11
 * Description: labuladong算法书学习——动态规划之四键键盘
 */

/**
 * 四键键盘
 *  题目描述：
 *
 *
 */
public class four_Keys_Keyboard_2_11 {
        public static int maxA(int N){
            int[] dp = new int[N + 1];
            dp[0] = 0;
            for (int i = 1;i <= N;i++){
                //按A键
                dp[i] = dp[i - 1] + 1;
                for (int j = 2;j < i;j++){
                    //全选 & 复制dp[j - 2],连续粘贴i - j次
                    //屏幕上共dp[j-2] * (i - j + 1)个A
                    dp[i] = Math.max(dp[i],dp[j -2]*(i - j + 1));
                }
            }
            //N次按键之后最多有几个A？
            return dp[N];
        }

    public static void main(String[] args) {
        System.out.println(maxA(15));
    }
}
