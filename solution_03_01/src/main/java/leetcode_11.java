/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/23 15:17
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
class leetcode_11 {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }


}
