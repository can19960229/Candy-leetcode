package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/12 22:55
 *
 * @Classname HJ73
 * Description: 	计算日期到天数转换
 */

import java.util.Scanner;

/**
 *
 */
public class HJ73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int[] month_day = {31,28,31,30,31,30,31,31,30,31,30,31};
            int sum = 0;
            for (int i = 0; i < month - 1; i++) {
                sum += month_day[i];
            }
            sum += day;
            if (month > 2 && isleap(year)){
                sum += 1;
            }
            System.out.println(sum);
        }
    }

    private static boolean isleap(int n) {
        if (n % 4 ==0 && n % 100 != 0 || n % 400 == 0){
            return true;
        }else {
            return false;
        }
    }

}
