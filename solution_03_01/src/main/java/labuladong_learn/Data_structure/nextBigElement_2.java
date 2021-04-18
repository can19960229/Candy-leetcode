package labuladong_learn.Data_structure;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/18 11:04
 *
 * @Classname nextBigElement
 * Description: 循环数组的下一个更大元素
 */

import java.util.Arrays;
import java.util.Stack;

/**
 *  给你一个数组，具有环形属性，
 *  输入[2,1,2,4,3]
 *  返回数组[4,2,4,-1,4]
 *  最后一个元素3绕了一圈后找到了比自己大的元素4
 */
public class nextBigElement_2 {

        /*
        模拟环形数组的效果，一般通过%运算符求模(余数)，获得环形特效
         */
        /*
        int[] arr = {1,2,3,4,5};
        int n = arr.length,index = 0;
        while(true){
            print(arr[index]);
            index = (index + 1) % n;
        }
         */
        public static int[] nextGreaterElements(int[] nums){
            int n = nums.length;
            int[] res = new int[n];  //存放结果
            Stack<Integer> s = new Stack<>();
            //假装这个数组的长度翻倍了
            for(int i = 2 * n - 1;i >= 0;i--){
                while (!s.isEmpty() && s.peek() <= nums[i % n]){
                    s.pop();
                }
                //利用%求模防止索引越界
                res[i %n] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i % n]);
            }
            return res;
        }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{73,74,75,71,69,72,76,73})));
    }
}
