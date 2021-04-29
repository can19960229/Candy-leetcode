package labuladong_learn.someIdea;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/26 15:16
 *
 * @Classname twoSum
 * Description: 两数之和
 */

import java.util.HashMap;

/**
 *
 */
public class TwoSum {
    //暴力法
    int[] twoSum1(int[] nums,int target){
        //穷举这两个数的可能
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        //不存在这两个数
        return new int[]{-1,-1};
    }

    //空间换时间，通过一个哈希表记录元素值直到索引的映射，减少时间复杂度
    int[] twoSum2(int[] nums,int target){
        //构造一个哈希表，元素映射到相应的索引
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0;i < nums.length;i++){
            int other = target - nums[i];
            //如果other存在且不是nums[i]本身
            if (map.containsKey(other) && map.get(other) != i){
                return new int[]{map.get(other),i};
            }
        }
        return new int[]{-1,-1};
    }

}
