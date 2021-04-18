package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/18 15:05
 *
 * @Classname test
 * Description: 数组中的元素进行加一操作
 */

import java.util.Arrays;

/**
 *
 */
public class leetcode_66{
    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        System.out.print(Arrays.toString(plusOne(nums)));
    }
    public static int[] plusOne(int[] nums) {
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            nums[i]++; //从后面开始，给数加1
            nums[i] = nums[i] % 10; //取余数
            //System.out.println(nums[i]);
            //如果没有余数等于0的，就直接返回
            if(nums[i] != 0)
                return nums;
        }
        //余数后，最高位是 1 ，所以  nums[0] = 1;
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }
}