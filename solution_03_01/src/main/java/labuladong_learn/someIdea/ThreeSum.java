package labuladong_learn.someIdea;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/26 16:55
 *
 * @Classname ThreeSum
 * Description: 三数之和
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    /**
     * 从nums[start]开始，计算有序数组
     * nums中所有和为target的二元组
     * @return
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        return threeSumTarget(nums,0);
    }
    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target){
        //左指针改为start开始，其他不变
        int lo = start,hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while (lo < hi){
            int sum = nums[lo] + nums[hi];
            int left = nums[lo],right = nums[hi];
            if (sum < target){
                while (lo < hi && nums[lo] == left)
                    lo++;
            }
            else if (sum > target){
                while (lo < hi && nums[hi] == right)
                    hi--;
            }
            else {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(left);
                tmp.add(right);
                res.add(tmp);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }
    public List<List<Integer>> threeSumTarget(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //穷举threeSum 的第一个数
        for (int i = 0;i < nums.length;i++){
            List<List<Integer>> tuples = twoSumTarget(nums,i + 1,target - nums[i]);
            //如果存在满足条件的二元组，再加上nums[i]就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            //跳过第一个数字重复的情况，否则会出现重复结果
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return res;
    }

    /*
    思路：
        跟两数之和不同的是，三数之后要输出的是不同三元组的集合。
        因此，我们考虑先将nums进行排序，将nums[i]作为第一个加数，
        从i+1到nums.length-1之间初始化两个指针left，right，
        为了避免有重复的情况，当nums[i]==nums[i-1],说明有重复的情况，开始下一个循环。
        如果num[i]+num[left]+num[right]>0,说明加多了，让right–，
        如果num[i]+num[left]+num[right]<0,说明加少了，让left++，
        如果等于0，说明符合条件，将这一组解加到集合中，这是也应该避免第二个加数和第三个加数重复的情况。
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i < nums.length - 1; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] + nums[i] > 0){
                    right--;
                }else if (nums[left] + nums[right] + nums[i] < 0){
                    left++;
                }else {
                    list.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }
        return list;
    }

}
