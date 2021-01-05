package org.example;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/20 12:40
 * version 1.0
 * Description: 程序设计赛题目
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        //存储的数据的
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split(" ");
            list.add(s);
        }
        //存储步数
        int num = sc.nextInt();

        //总价格
        double sum = 0;
        //折扣
        double count = 1;
        if (num < 5999) {
            count = 1;
        } else if (num < 9999 && num > 6000) {
            count = 0.9;
        } else if (num > 10000) {
            count = 0.8;
        }
        for (String[] arr : list) {
            if (arr[0].equals("R")) {
                if (Integer.valueOf(arr[1]) <= 200) {
                    continue;
                }else {
                    sum +=( (Integer.valueOf(arr[1]) - 200) * Double.valueOf(arr[2])) / 100;
                }
            } else {
                sum += (Integer.valueOf(arr[1]) * Double.valueOf(arr[2]) / 100);
            }
        }
        double res = sum * count;
        System.out.println(String.format("%.2f", res));
    }
}
