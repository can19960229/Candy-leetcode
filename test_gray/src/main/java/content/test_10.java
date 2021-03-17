package content;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/14 21:11
 *
 * @Classname test_10
 * Description: 测试
 */

import java.util.Scanner;

/**
 *
 */
public class test_10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int K = (int) Math.ceil((A - a + 0.000001) / (2 * a - 0.000001));
        int C = (int) Math.ceil((B - b + 0.000001) / (2 * b - 0.000001));
        System.out.println(K * C);

    }
}
