package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/14 22:47
 *
 * @Classname HJ100
 * Description: 等差数列
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 */
public class HJ100 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str=br.readLine())!=null){
            int n = Integer.parseInt(str);
            System.out.println((3*n*n+n)/2);
        }
    }

}
