package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 14:01
 *
 * @Classname HJ20
 * Description: 密码验证合格程序
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class HJ53 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null){
            System.out.println(getResult(line));
        }
    }

    private static int getResult(String str) {
        int i = Integer.parseInt(str);
        if (i <= 2){
            return -1;
        }else if (i % 2 == 1){
            return 2;
        }else {
            if (i % 4 == 0){
                return 3;
            }else {
                return 4;
            }
        }
    }
}
