package content;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/14 21:11
 *
 * @Classname test_10
 * Description: 测试
 */

/**
 *
 */
public class test_02 {
    public static void main(String[] args) {

        String s = "ibti lbtlovebte lbtlibtinbtnkbtkebtezbas jebte dosadnbtna ovakbtkebtemibtijaxaszxdbtddbtddbtddbtddbtddbtd";
        int n = s.length();
        for(int i = 0; i < n; i++) {
            System.out.print(s.charAt(i));
            if(s.charAt(i)=='l' || s.charAt(i)=='i' || s.charAt(i)=='n' || s.charAt(i)=='k' || s.charAt(i)=='e') i += 3;
        }

    }
}
