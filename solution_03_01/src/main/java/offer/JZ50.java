package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/11 22:13
 *
 * @Classname JZ50
 * Description: 数组中重复的数字
 */

import java.util.HashSet;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数字的范围是0——n-1范围内的
 */
public class JZ50 {
    /**
     * hashSet方法
     * @param numbers
     * @return
     */
    public int duplicate (int[] numbers) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!set.add(numbers[i])){
                return numbers[i];
            }
        }
        return -1;
    }

    /**
     * 将出现的字符的次数存储到数字对应的下标中，如果出现的次数不为1，则出现了多次，返回数字
     * @param numbers
     * @return
     */
    public int duplicate_1 (int[] numbers) {
        int[] res = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            res[numbers[i]]++;
            if (res[numbers[i]] == 2){
                return numbers[i];
            }
        }
        return -1;
    }



}
