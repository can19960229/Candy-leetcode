package org.example;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/20 12:41
 * version 1.0
 * Description: 程序设计赛题目
 */

import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt(),b = cin.nextInt();
        int ans = 0;
        int m = 10;
        while (m > 0){
            ans = a * b;
            if (ans < 10000){
                a = b;
                b = ans;
                System.out.print(b + " ");
                m--;
            }else if (ans > 10000){
                a = ans % 10000;
                System.out.print(a + " ");
                m--;
                if(m > 0){
                    b = ans / 10000;
                    System.out.print(b + " ");
                    m--;
                }
            }
        }
    }
}
