package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/20 13:50
 *
 * @Classname HJ19
 * Description: 简单错误记录
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/**
 *
 */
public class HJ19 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str;
        LinkedHashMap<String,Integer> data = new LinkedHashMap<>();
        while ((str = buffer.readLine()) != null){
            int idx1 = str.lastIndexOf(" ");
            int idx2 =  str.lastIndexOf("\\");
            String key = (idx1 - idx2)> 16 ? str.substring(idx1 - 16) : str.substring(idx2 + 1);
            data.put(key,data.getOrDefault(key,0) + 1);
        }
        int count = 0;
        for (String key : data.keySet()) {
            count++;
            if (count> (data.size() - 8)){
                System.out.println(key + " " + data.get(key));
            }
        }
    }
}
