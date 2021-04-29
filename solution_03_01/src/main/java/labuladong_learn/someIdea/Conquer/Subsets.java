package labuladong_learn.someIdea.Conquer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 15:13
 *
 * @Classname Subsets
 * Description: 子集
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null)
            return res;
        helper(res,nums,new ArrayList<>(),0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int index) {
        if (index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        helper(res,nums,list,index+1);
        list.add(nums[index]);
        helper(res,nums,list,index+1);
        list.remove(list.size() - 1);
    }
}
