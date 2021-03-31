package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/30 22:38
 *
 * @Classname HJ23
 * Description: 测试
 */

import java.util.*;

/**
 *
 */
public class HJ23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(test(str));
        }
    }

    //对输入的字符串一直进行判断
    private static StringBuilder test(String str) {
        StringBuilder sb = new StringBuilder();
        //统计字符出现的次数
        int[] a = new int[26];
        for (int i = 0; i < str.length(); i++) {
            a[str.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(a));
        int min = 100;
        //找出出现最小的次数
        for (int i = 0; i < 26; i++) {
            if (a[i] < min && a[i] != 0) {
                min = a[i];
            }
        }
        System.out.println(Arrays.toString(a));

        //出现次数最小的字符都统计出来
        for (int i = 0; i < 26; i++) {
            if (a[i] == min) {
                char c = (char) ('a' + i);
                sb.append(c);
            }
        }
        System.out.println(sb);
        String temp = sb.toString();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //去掉出现次数最小的字符，并把接轨加入res中
            if (!temp.contains(str.charAt(i) + "")) {
                res.append(str.charAt(i));
            }
        }
        return res;
    }


}
