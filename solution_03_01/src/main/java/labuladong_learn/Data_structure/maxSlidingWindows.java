package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/18 14:38
 *
 * @Classname maxSlidingWindow
 * Description: 滑动窗口
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个数组nums 和一个正整数k，有一个大小为k的窗口在nums上从左至右滑动，请输出每次滑动时窗口中的最大值
 */
public class maxSlidingWindows {
    //双链表，支持头部和尾部增删元素
    private static LinkedList<Integer> q = new LinkedList<>();
    static class MonotonicQueue{
        //在队尾添加元素n
        void push(int n) {
            //将前面小于自己的元素都删除
            while (!q.isEmpty() && q.getLast() < n){
                q.pollLast();
            }
            q.addLast(n);
        }
        //返回当前队列中的最大值
        int max(){
            //队头的元素肯定是最大的
            return q.getFirst();
        }
        //队头元素如果是n，删除它
        void pop(int n){
            if (n == q.getFirst()){
                q.peekFirst();
            }
        }
    }
    static int[] maxSlidingWindow(int[] nums,int k){

        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0;i < nums.length;i++){
            if (i < k - 1){
                //先把窗口的前k - 1填满
                window.push(nums[i]);
            }else {
                //窗口开始向前滑动
                //移入新元素
                window.push(nums[i]);
                //将当前窗口中的最大元素记入结果
                res.add(window.max());
                //移出最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        //将list类型转换成int[] 数组作为返回值
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
