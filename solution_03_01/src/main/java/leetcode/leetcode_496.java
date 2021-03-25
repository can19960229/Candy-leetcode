package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/25 15:43
 *
 * @Classname leetcode_496
 * Description: 下一个更大元素
 */

import java.util.*;

/**
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 */
public class leetcode_496 {
    /**
     * 暴力法
     * 关键信息：两个数组各自 没有重复元素。
     * 模拟题目的意思：对于每一个 nums1[i] 中的元素，先在 nums2 中找到它，然后向右遍历找到第 1 个大于 nums1[i] 的元素。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //把数组2的元素放进map中，键为num2的值，值为下标
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }
        //定义需要返回的数组
        int[] res = new int[nums1.length];
        //依次遍历num1中的元素，
        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]){
                    res[i] = nums2[j];
                    break;
                }
                else {
                    res[i] = -1;
                }
            }
        }
        return res;
    }

    /**
     * 单调栈
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        //先处理nums2，把对应关系存入哈希表
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]){
                map.put(stack.removeLast(),nums2[i]);
            }
            stack.addLast(nums2[i]);
        }
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2,4}, new int[]{1, 2,3,4})));
    }
}
