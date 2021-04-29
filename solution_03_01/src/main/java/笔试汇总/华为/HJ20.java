package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 22:39
 *
 * @Classname HJ20
 * Description: 密码验证合格程序
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有相同长度大于2的子串重复
 */
public class HJ20 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuffer sb = new StringBuffer();
        while ((input = br.readLine()) != null){
            //设置四种类型数据初始化为空，即false，有数据了就更改为true
            boolean[] flag = new boolean[4];
            char[] chars = input.toCharArray();

            //第一个条件 长度超过8位
            if (chars.length < 9){
                sb.append("NG").append("\n");
                continue;
            }

            //第二个条件  包括大小写字母.数字.其它符号,以上四种至少三种
            for (int i = 0;i < chars.length; i++){
                if ('A' <= chars[i] && chars[i] <= 'Z') {
                    flag[0] = true;
                } else if ('a' <= chars[i] && chars[i] <= 'z') {
                    flag[1] = true;
                } else if ('0' <= chars[i] && chars[i] <= '9') {
                    flag[2] = true;
                } else {
                    flag[3] = true;
                }
            }
            int count = 0;
            for (int i = 0;i < 4;i++){
                if (flag[i]){
                    count++;
                }
            }
            // 第三个条件
            boolean sign = true;        //不存在两个大于2的子串相同，即！（i=i+3,i+1=i+4,i+2=i+5）
            for (int i = 0; i < chars.length - 5; i++) {
                for (int j = i + 3; j < chars.length - 2; j++) {
                    if (chars[i] == chars[j] && chars[i + 1] == chars[j + 1] && chars[i + 2] == chars[j + 2]) {
                        sign = false;
                    }
                }
            }
            if (count >= 3 && sign){
                sb.append("OK").append("\n");
            }else {
                sb.append("NG").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
