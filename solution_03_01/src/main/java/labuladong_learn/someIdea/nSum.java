package labuladong_learn.someIdea;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/26 19:49
 *
 * @Classname nSum
 * Description: 测试
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class nSum {
    public List<List<Integer>> nsum(int[] nums){
        Arrays.sort(nums);
        return nSumEqualsTarget(nums,3,0,0);
    }

    private List<List<Integer>> nSumEqualsTarget(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        //至少是2Sum，且数组大小不应该小于n
        if (n < 2 || sz < n){
            return res;
        }
        //2Sum是base case
        if (n == 2){
            int low = start,high = sz - 1;
            while (low < high){
                int sum = nums[low] + nums[high];
                //记录索引low和high最初对应的值，方便跳过重复元素
                int left = nums[low],right = nums[high];
                if (sum == target){
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(left);
                    tmp.add(right);
                    res.add(tmp);
                    //两边跳过重复元素
                    while (low < high && nums[low] == left) low++;
                    while (low < high && nums[high] == right) high--;
                }else if (sum < target){
                    //左指针跳过重复元素
                    while (low < high && nums[low] == left) low++;
                }else if (sum > target){
                    //右指针跳过重复元素
                    while (low < high && nums[high] == right) high--;
                }
            }
        }else{
            //n > 2时，递归计算(n-1)Sum的结果
            for (int i = start;i< sz;i++){
                //对target - sum[i]计算(n-1)Sum
                List<List<Integer>> sub = nSumEqualsTarget(nums,n - 1,i + 1,target - nums[i]);
                for (List<Integer> arr : sub) {
                    //如果存在满足条件的(n-1)元组，则再加上nums[i]就是nSum
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
