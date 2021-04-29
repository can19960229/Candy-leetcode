package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/21 11:13
 *
 * @Classname JZ42
 * Description: 和为s的两个数字
 */

import java.util.ArrayList;

/**
 *
 */
public class JZ42 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length <= 1){
            return res;
        }
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            if (array[l] + array[r] == sum) {
                res.add(array[l]);
                res.add(array[r]);
                break;
            } else if (array[l] + array[r] < sum) {
                l++;
            }
            else
                r--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindNumbersWithSum(new int[]{1,3,4,5,7,9,13,54},16));
    }
}
