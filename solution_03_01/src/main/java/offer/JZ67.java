package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/24 17:16
 *
 * @Classname JZ67
 * Description: 剪绳子
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class JZ67 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(cutRope(n));
    }

    private static int cutRope(int target) {

        int a = 0;
        int c = 0;
        int maxValue = 2;
        if (target == 2){
            return 1;
        }
        if (target == 3){
            return 2;
        }
        if (target % 3 == 0){
            maxValue = (int) Math.pow(3,target/3);
        }else {
            a = target - 2;
            c = a % 3;
            maxValue = maxValue * (int)Math.pow(3,a/3);
            if ( 0 != c){
                maxValue = maxValue * c;
            }
        }
        return maxValue;
    }

}
