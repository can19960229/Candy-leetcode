package labuladong_learn.someIdea.Conquer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 15:43
 *
 * @Classname permute
 * Description: 全排列
 */

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Permute {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //到达叶子结点
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            //排除不合法的选择
            if (track.contains(num)) {
                continue;
            }
            //做选择
            track.add(num);
            //进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }
}
