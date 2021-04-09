package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 19:31
 *
 * @Classname JZ7
 * Description: 斐波那契数列
 */

/**
 *
 */
public class JZ7 {
    public int Fibonacci(int n){
        if (n == 0 || n == 1)
            return n;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n ; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
