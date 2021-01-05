package org.example;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/20 12:41
 * version 1.0
 * Description: 程序设计赛题目
 */

import java.util.Scanner;

public class Main_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int des = (int)s2.charAt(4);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9'){
                int tmp = (int) s1.charAt(i);
                if (tmp > max){
                    max = tmp;
                }
                if (tmp < min){
                    min = tmp;
                }
            }
        }
        System.out.println((des - min) + " " + (max -des));
    }
}
