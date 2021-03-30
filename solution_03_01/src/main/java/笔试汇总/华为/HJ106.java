package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/29 20:51
 *
 * @Classname HJ106
 * Description: 字符逆序
 */

import java.util.Scanner;

/**
 * 题目描述
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 *
 *
 * 输入描述:
 * 输入一个字符串，可以有空格
 *
 * 输出描述:
 * 输出逆序的字符串
 *
 * 示例1
 * 输入
 *
 * I am a student
 * 输出
 *
 * tneduts a ma I
 */
public class HJ106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        char[] c = s.toCharArray();
        int d = c.length;
        for(int i = 0; i < d/2;i++){
            char cc = c[i];
            c[i] = c[d - i - 1];
            c[d - i - 1] = cc;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
        }
        System.out.println(sb.toString());

    }
}
