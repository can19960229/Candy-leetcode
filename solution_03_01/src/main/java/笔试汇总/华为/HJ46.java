package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/18 17:07
 *
 * @Classname HJ46
 * Description: 截取字符串
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class HJ46 {
    public static void main(String[] args) throws IOException {
        /*
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            int i = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int m = 0;
            while (m < i){
                sb.append(s.charAt(m));
                m++;
            }
            System.out.println(sb);
        }

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res;
        int len;
        while ((res = br.readLine())!= null) {
            len = Integer.parseInt(br.readLine());
            System.out.println(res.substring(0, len));
        }
    }

}
