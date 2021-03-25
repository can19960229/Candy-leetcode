package leetcode;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/25 16:14
 *
 * @Classname leetcode_503
 * Description: 下一个更大元素
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * 循环数组：
 * 一种实现方式是，把数组复制一份到数组末尾，这样虽然不是严格的循环数组，但是对于本题已经足够了，因为本题对数组最多遍历两次。
 * 另一个常见的实现方式是，使用取模运算 %可以把下标 i 映射到数组 nums 长度的 0−N 内。
 *
 */
public class leetcode_503 {

    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int res[] = new int[length];
        Arrays.fill(res,-1); //默认都为1
        Stack<Integer> stack = new Stack<>();
        //相当于把数组遍历两遍
        for (int i = 0; i < length * 2; i++) {
            //遍历数组的第index（index从0开始）个元素，因为数组会遍历
            //两遍，会导致数组越界异常，所以这里要对数组长度进行求余
            int index = i % length;
            //单调栈，他存储的是元素的下标，不是元素具体值，从栈顶
            //到栈底所对应的值是递增的（栈顶元素在数组中对应的值最小，
            //栈底元素对应的值最大），如果栈顶元素对应的值比nums[index]小，
            //说明栈顶元素对应的值遇到了右边第一个比他大的值，然后栈顶元素出栈，
            //让他对应的位置变为nums[index]，也就是他右边第一个比他大的值，
            //然后继续判断……
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]){
                res[stack.pop()] = nums[index];
            }
            //当前元素的下标入栈
            stack.push(index);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
    }

}
