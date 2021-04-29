package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/29 20:05
 *
 * @Classname HJ75
 * Description: 公共子串计算
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 */
public class HJ75 {
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        String nextLine1 = sc.nextLine();
        String lstr = nextLine.length() > nextLine1.length() ? nextLine : nextLine1;
        String rstr = nextLine.length() < nextLine1.length() ? nextLine : nextLine1;
        int max = 0;
        for (int i = 0; i < rstr.length(); i++) {
            for (int j = i + 1; j <= rstr.length(); j++) {
                String subString = rstr.substring(i,j);
                if (lstr.contains(subString)){
                    max = Math.max(subString.length(), max);
                }
            }
        }
        System.out.println(max);
    }

     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";
        while ((str1 = bf.readLine()) != null && (str2 = bf.readLine()) != null){
            int max = 0;
            char[] cha1 = str1.toCharArray();
            char[] cha2 = str2.toCharArray();
            for (int i = 0; i < str1.length(); i++) {
                for (int j = 0; j < str2.length(); j++) {
                    int t1 = i;
                    int t2 = j;
                    int count = 0;
                    while (cha1[t1] == cha2[t2]){
                        t1++;
                        t2++;
                        count++;
                        max = Math.max(count,max);
                        if (t1 == cha1.length || t2 == cha2.length)
                            break;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
