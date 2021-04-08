package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/2 10:59
 *
 * @Classname HJ14
 * Description: 字符串排序
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] ss = new String[num];
        for (int i = 0; i < num; i++) {
            ss[i] = sc.next();
        }
        Arrays.sort(ss);
//        for (int i = 0; i < num - 1; i++) {
//            for (int j = 0; j < num - 1 - j; j++) {
//                if (ss[i].compareTo(ss[i + 1]) > 0){
//                    String temp = ss[i];
//                    ss[i] = ss[i+1];
//                    ss[i+1] = temp;
//                }
//            }
//        }

        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }
}
