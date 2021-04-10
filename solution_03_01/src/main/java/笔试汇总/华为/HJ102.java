package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/10 20:17
 *
 * @Classname HJ102
 * Description: 测试
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class HJ102{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            char[] chArr = str.toCharArray();
            int[] temp = new int[150];
            for(int i=0;i<chArr.length;i++){
                temp[chArr[i]]++; //统计字符出现的个数
            }
            int max = 0;
            for(int j=0;j<temp.length;j++){
                if(max<temp[j]){
                    max = temp[j]; //统计字符出现的最大的次数是哪个字符

                }
            }

            StringBuilder sbf = new StringBuilder();
            while(max!=0){
                for(int j=0;j<temp.length;j++){
                    if(temp[j] == max){
                        sbf.append((char)j);
                    }
                }
                max--;
            }
            System.out.println(sbf.toString());
        }
    }

}
