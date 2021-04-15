package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/13 22:41
 *
 * @Classname HJ81
 * Description: 字符串字符匹配
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 判断短字符串中的所有字符是否在长字符串中全部出现。
 */
public class HJ81 {
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < c2.length; i++) {
                set.add(c2[i]);
            }
            System.out.println(Arrays.toString(set.toArray()));
            int count = 0;
            for (char c : c1) {
                if (set.add(c)) {
                    System.out.println(false);
                    break;
                }
                count++;
            }
            if (count == c1.length)
                System.out.println(true);
        }
    }

    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String str2 = "";
        while( (str = br.readLine()) != null && !"".equals(str)){
            str2 = br.readLine();
            char[] arr = str.toCharArray();
            boolean judge = true;
            for (char c : arr) {
                if (!str2.contains(String.valueOf(c))){
                    judge = false;
                    break;
                }
            }
            System.out.println(judge);
        }
        br.close();
    }

}
