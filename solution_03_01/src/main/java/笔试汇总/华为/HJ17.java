package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/10 15:36
 *
 * @Classname HJ17
 * Description: 坐标移动
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 用正则表达式 + HashMap
 */
public class HJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        while (sc.hasNext()){
            String s = sc.nextLine();
            int x = 0,y = 0; //起始坐标
            String[] sArray = s.split(";");
            String res = "[ADWS]\\d{1}\\d?";
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i].matches(res)){
                    map.put(sArray[i].charAt(0),map.getOrDefault(sArray[i].charAt(0),0) + Integer.valueOf(sArray[i].substring(1)));
                }
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x + "," + y);
            map.clear();
        }
        sc.close();
    }
}
