package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/31 17:21
 *
 * @Classname HJ1
 * Description: 字符串最后一个单词的长度
 */

import java.util.Scanner;

/**
 *  题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 输入描述:
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * 示例1
 * 输入
 *
 * hello nowcoder
 * 输出
 *
 * 8
 */
public class HJ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        test(s);

    }

    private static void test(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count = 0;
        for (int i = n - 1; i >= 0 ; i--) {

            count++;
            if (chars[i] == ' ' ){
                count = count - 1;
                System.out.println(count);
                break;
            }
            if (i == 0){
                System.out.println(count);
            }
        }
    }

}
