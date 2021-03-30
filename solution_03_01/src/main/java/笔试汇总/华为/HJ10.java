package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/30 16:18
 *
 * @Classname HJ10
 * Description: 字符个数统计
 */

import java.util.HashSet;
import java.util.Scanner;

/**
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 输入描述:
 * 输入一行没有空格的字符串。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 *
 * abc
 * 输出
 *
 * 3
 */
public class HJ10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){//如果有输入，则一直执行该方法，即方法不关闭
            String str = sc.nextLine();
            System.out.println(test(str));
            System.out.println(test01(str));
        }
        sc.close();
    }

    private static int test(String str) {

        char[] chars = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        return set.size();
    }

    private static int test01(String str) {
        int count = 0;
        int [] tab = new int[128];
        for (int i = 0; i < str.length(); i++) {
            if (tab[str.charAt(i)] == 0) //如果已经统计过，则不进行+1
                tab[str.charAt(i)]++;//没有出现过的字符则就进行统计，将数组值进行+1
        }
        //统计字符个数
        for (int value : tab) {
            if (value != 0) {
                count++;
            }
        }
        return count;

    }
}
