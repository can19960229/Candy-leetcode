package labuladong_learn.DP;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/1 21:19
 *
 * @Classname Data_structure_3_1
 * Description: 测试
 */

import java.util.Scanner;

/**
 *
 */
public class Data_structure_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long number = 0;
        while (sc.hasNextLong()){
            number = sc.nextLong();
            isPrimerFactors(number);
        }
    }

    private static void isPrimerFactors(long num) {
        long number = num;
        while (number != 1){
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (number % i == 0){
                    number /= i;
                    System.out.println(i + " ");
                    break;
                }
            }
        }
    }
}
