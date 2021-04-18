package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/18 11:04
 *
 * @Classname nextBigElement
 * Description: 下一个更大元素I
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
 */
public class nextBigElement {
    public static int[] nextGreaterElement(int[] nums){
        int[] ans = new int[nums.length];  //存放答案的数组
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0 ; i--) {  //倒着往栈里放,其实就是正着出栈
            while (!s.isEmpty() && s.peek() <= nums[i]){ //判定个子高矮
                s.pop();  //矮个子出列，反正也被挡着了
            }
            ans[i] = s.isEmpty() ? -1 : s.peek();  //这个元素身后的第一个高个
            s.push(nums[i]);    //进队，接收之后的身高判定
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 1, 2, 4, 3})));
    }
}
