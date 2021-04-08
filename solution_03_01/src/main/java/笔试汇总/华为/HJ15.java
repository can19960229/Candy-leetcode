package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/2 11:33
 *
 * @Classname HJ15
 * Description: 求int型数据在内存中存储时1的个数
 */

import java.util.Scanner;

/**
 *
 */
public class HJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n > 0){
            if ((n & 1) > 0){
                count++;
            }
            n = n>>1;
        }
        System.out.println(count);
    }
}
