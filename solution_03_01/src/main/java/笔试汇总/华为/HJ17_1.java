package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/10 15:36
 *
 * @Classname HJ17
 * Description: 坐标移动
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串
 */
public class HJ17_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] strs = s.split(";");
        int[] point = new int[2];
        for (String str : strs) {
            //长度超过3，跳过
            if (str.length() > 3){
                continue;
            }
            int length;
            try {
                length = Integer.parseInt(str.substring(1));
            }catch (Exception e){
                continue;
            }
            if (str.charAt(0) == 'A' || str.charAt(0) =='S' || str.charAt(0) == 'D' || str.charAt(0) == 'W'){
                if(str.charAt(0)=='A'){
                    point[0] -= length;
                }
                if(str.charAt(0)=='S'){
                    point[1] -= length;
                }
                if(str.charAt(0)=='D'){
                    point[0] += length;
                }
                if(str.charAt(0)=='W'){
                    point[1] += length;
                }
            }else {
                continue;
            }
        }
        System.out.printf("%d,%d\n",point[0],point[1]);
    }
}
