package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/13 11:16
 *
 * @Classname HJ84
 * Description: 统计大写字母个数
 */

import java.util.Scanner;

/**
 *
 */
public class HJ84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
