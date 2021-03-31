package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/31 17:36
 *
 * @Classname HJ2
 * Description: 计算字符个数
 */

/**
 * 题目描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 *
 * ABCabc
 * A
 * 输出
 *
 * 2
 */

import java.util.Scanner;
public class HJ2{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        char c = sc.nextLine().toLowerCase().charAt(0);
        System.out.println(nums(str,c));
    }

    public static int nums(String str,char c){
        int i = 0;
        char[] chars = str.toCharArray();
        for(char ch:chars){
            if(c == ch ){
                i++;
            }
        }
        return i;
    }
}
