package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/29 19:42
 *
 * @Classname HJ11
 * Description: 数字颠倒
 */

import java.util.Scanner;

/**
 *题目描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 *
 * 1516000
 * 输出
 *
 * 0006151
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // 注意 while 处理多个 case
        int a = in.nextInt();
        StringBuilder s = new StringBuilder();
        while(a != 0){
            s.append( a % 10);
            a = a / 10;
        }
        System.out.println(s.toString());

    }
}
