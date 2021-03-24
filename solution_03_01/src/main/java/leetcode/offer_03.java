package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/24 14:51
 *
 * @Classname offer_03
 * Description: 测试
 */

/**
 *
 */
public class offer_03 {
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == nums[i] && i != j){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{0,1,2,3,4,11,5,6,7,8,9,10,11,12,13}));
    }
}
