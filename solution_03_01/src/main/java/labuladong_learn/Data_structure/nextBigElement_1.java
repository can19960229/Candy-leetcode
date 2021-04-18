package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/18 11:04
 *
 * @Classname nextBigElement
 * Description: 近几天的气温
 */

import java.util.Arrays;
import java.util.Stack;

/**
 *  计算对于每一天，至少还要等多少天才能等到一个更暖和的气温，如果等不到那一天就填 0
 *  输入T = [73,74,75,71,69,72,76,73] 算法应该返回 [1,1,4,2,1,1,0,0]
 */
public class nextBigElement_1 {
    public static int[] dailyTemperatures(int[] nums){
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();  //这里放索引，而不是元素
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.empty() && nums[s.peek()] <= nums[i]){  //单调栈实现的原理关键点
                s.pop();
            }
            ans[i] = s.isEmpty() ? 0 : (s.peek() - i); // 得到索引间距
            s.push(i); //加入索引，而不是元素
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
