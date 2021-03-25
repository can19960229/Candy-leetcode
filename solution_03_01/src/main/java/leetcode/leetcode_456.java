package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/25 10:35
 *
 * @Classname leetcode_456
 * Description: 测试
 */

import java.util.Stack;

/**
 * 所谓「单调栈」就是栈中的元素都是依次递增或者递减的 如 [4, 3, 2, 1]
 *
 * 132模式至少存在三个数字 分别为 min， max， med
 * min， max， med 顺序不可调换
 * 遍历数组找 med 的位置
 * 如果当前遍历大于栈顶元素 则栈的单调性被破坏，清空栈 将当前值压入栈底 将栈底元素作为med
 * 如果 med max 都存在 遍历到 比med小的值 可放入min位置 返回true
 *
 */
public class leetcode_456 {
    /**
     * 单调栈
     * @param nums
     * @return
     */
    public static boolean find132pattern(int[] nums){
        int len = nums.length;
        if (len < 3){
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int k = -1;
        for (int i = len - 1;i >= 0 ;i--){
            if (k > - 1 && nums[k] > nums[i])  //找到num[i]
                return true;
            while (!st.isEmpty() && nums[st.peek()] < nums[i])
                k = st.pop(); //pop() 出去的最后一个元素就是 比 num[i] 小的所有元素中的最大元素 nums[k] 。
            st.push(i);
        }
        return false;
    }


    /**
     * 暴力求解 时间复杂度 o（n^3）
     * @param nums
     * @return
     */
    public static boolean find132pattern_1(int[] nums) {
        if (nums.length < 3){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[i] && nums[k] < nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;

    }


    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{9,4,5,2,1,4}));
    }
}
