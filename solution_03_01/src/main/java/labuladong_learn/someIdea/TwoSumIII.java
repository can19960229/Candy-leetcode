package labuladong_learn.someIdea;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/26 16:31
 *
 * @Classname TwoSumIII
 * Description: 两数之和
 *
 * 排序加双指针
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * nums中可能有多对元素之和等于target，返回所有和为target的元素对，其中不能出现重复
 * 比如，输入nums = {1,3,1,2,2,3}，target = 4
 * 那么算法返回的结果就是[[1,3],[2,2]]
 */
public class TwoSumIII {
    public List<List<Integer>> twoSumTarget(int[] nums,int target) {
        //nums数组必须有序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        /* 双指针 */
        int low = 0, high = nums.length - 1;
        /* 不能重复取元素，所以是小于号 */
        while (low < high) {
            int sum = nums[low] + nums[high];
            /* 记录索引low和high最初对应的值，方便跳过重复元素 */
            int left = nums[low], right = nums[high];

            if (sum == target) {
                /* 把二元组{left, right}添加到res中 */
                List<Integer> tmp = new LinkedList<>();
                tmp.add(left);
                tmp.add(right);
                res.add(tmp);
                /* 两边跳过重复元素 */
                while (low < high && nums[low] == left) low++;
                while (low < high && nums[high] == right) high--;

            } else if (sum < target) {
                /* 左指针跳过重复元素 */
                while (low < high && nums[low] == left) low++;

            } else {
                /* 右指针跳过重复元素 */
                while (low < high && nums[high] == right) high--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
