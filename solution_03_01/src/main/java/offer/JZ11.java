package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 19:48
 *
 * @Classname JZ11
 * Description: 测试
 */

/**
 *
 */
public class JZ11 {
    public int NumberOf1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
