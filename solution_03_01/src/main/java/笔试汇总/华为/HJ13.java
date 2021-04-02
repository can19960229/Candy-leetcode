package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/2 10:19
 *
 * @Classname HJ13
 * Description: 句子逆序
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class HJ13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(test(str));
            System.out.println(test_1(str));
        }
    }

    /**
     * 用split分割字符串后逆序输出
     * i am a boy=>boy a am i
     * @param str
     * @return
     */
    private static String test_1(String str) {
        String[] s = str.split(" ");
        System.out.println(Arrays.toString(s));
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0 ; i--) {
            sb.append(s[i]).append(" ");
        }
        return String.valueOf(sb);
    }

    /**
     * 全部字母都逆序
     * @param str
     * @return
     */
    private static String test(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char c = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = c;
        }
        return String.valueOf(chars);
    }

}
