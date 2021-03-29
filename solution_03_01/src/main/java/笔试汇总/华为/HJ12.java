package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/29 20:48
 *
 * @Classname HJ12
 * Description: 字符串反转
 */

import java.util.Scanner;

/**
 * 题目描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述:
 * 输入一行，为一个只包含小写字母的字符串。
 *
 * 输出描述:
 * 输出该字符串反转后的字符串。
 *
 * 示例1
 * 输入
 *
 * abcd
 * 输出
 *
 * dcba
 */
public class HJ12 {
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
