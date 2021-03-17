package content;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/14 21:11
 *
 * @Classname test_10
 * Description: 测试
 */

import java.util.Scanner;

/**
 *
 */
public class test_05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String V = sc.nextLine();
        int k = Integer.parseInt(V);
        String s = sc.nextLine();
        long ans = 0, cnt1 = 0, cnt2 = 0;


        long n = s.length();
        for (int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '2') {
                if(cnt1 + 2 * cnt2 + 2 <= k) cnt2++;
            } else {//chars[i]=='1'
                if(cnt1 + 2 * cnt2 + 1 <= k) cnt1++;
                else if(cnt2 > 0) {
                    cnt1++;
                    cnt2--;
                }
            }
            ans += cnt1 + cnt2; //计入答案
        }
        System.out.println(ans);



    }
}
