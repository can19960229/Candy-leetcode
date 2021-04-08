package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/7 17:40
 *
 * @Classname HJ59
 * Description: 找出字符串中第一个只出现一次的的字符
 */

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 */
public class HJ59 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        outer:while (sc.hasNext()){
            String nextLine = sc.nextLine();
            char[] chars = nextLine.toCharArray();
            HashMap<Character,Integer> hashMap = new HashMap<>();
            for (char aChar : chars) {
                if (hashMap.containsKey(aChar)) {
                    hashMap.put(aChar, hashMap.get(aChar) + 1);
                } else {
                    hashMap.put(aChar, 1);
                }
            }
            for (char aChar : chars) {
                if (hashMap.get(aChar) == 1) {
                    System.out.println(aChar);
                    continue outer;
                }
            }
            System.out.println(-1);
        }
    }
}
