package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/1 20:59
 *
 * @Classname HJ5
 * Description: 测试
 */

import java.util.Scanner;

/**
 *
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String num = str.substring(2,str.length());
            int result = 0;
            int power = 1;
            for (int i = num.length() - 1;i >= 0;i--){
                char c = num.charAt(i);
                if (c >= '0' && c <= '9'){
                    result += (c - '0') * power;
                }else if (c >= 'A' && c <= 'F'){
                    result += (c - 'A' + 10) * power;
                }
                power *= 16;
            }
            System.out.println(result);
        }
        sc.close();
    }
}
