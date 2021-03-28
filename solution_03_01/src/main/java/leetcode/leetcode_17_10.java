package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/26 20:42
 *
 * @Classname leetcode_17_10
 * Description: 主要元素
 */

import java.util.Arrays;

/**
 *
 */
public class leetcode_17_10 {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]){
                end++;
            }else {
                start = end + 1;
                end++;
            }
            if (end - start + 1 > nums.length / 2){
                return nums[start];
            }
        }

        return -1;


    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
