package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/1 20:47
 *
 * @Classname HJ4
 * Description: 字符串分隔
 */

import java.util.Scanner;

/**
 *
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = new String(sc.nextLine());
            if (s.length() % 8 != 0){
                s = s + "00000000";
            }
            while (s.length() >= 8){
                System.out.println(s.substring(0,8));
                s = s.substring(8);
            }
        }
    }
}
