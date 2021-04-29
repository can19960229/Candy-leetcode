package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/24 17:15
 *
 * @Classname JZ47
 * Description: 求 1 + 2 + 3 + 4 +...+ n
 */

/**
 *
 */
public class JZ47 {
    public int Sum_Solution(int n) {
        //等差数列的和，n/2 + n方/2
        int sum = (int)Math.pow(n,2) + n;
        //右移一位除以2
        return sum >> 1;
    }
}
