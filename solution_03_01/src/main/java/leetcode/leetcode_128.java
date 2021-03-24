package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/21 19:59
 *
 * @Classname leetcode_128
 * Description: 测试
 */

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class leetcode_128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;

        for (Integer num : num_set) {
            if (!num_set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,1,1,2}));

    }
}
