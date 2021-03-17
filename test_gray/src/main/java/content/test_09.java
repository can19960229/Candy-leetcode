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
public class test_09 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        double nn = 0, st = 1;
        for (int i = 1; i <= 5; ++i)
            st *= 0.5;
        for (int i = 1; i <= y; ++i) {
            n *= 2.0 / 3;
            if (i == x)
                n += nn / 2;
            if (n < st * nn) {
                System.out.println("N0!" );
                System.out.println(i +" " + n);

            }
        }
        System.out.println("YE5!");
        System.out.println(n);

    }
}
