package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/13 21:47
 *
 * @Classname HJ26
 * Description: 字符串排序
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class HJ26 {
    
    public static void main(String[] args)  {
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            char[] ch = s.toCharArray();
            char[] chars = new char[ch.length];
            int flag = 65,j = 0;
            while (flag <= 90){
                //遍历输入的字符串，查看是否是英文字母
                for (int i = 0; i < ch.length; i++) {
                    if ((ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122)){
                        if (ch[i] == flag || ch[i] == flag + 32){
                            chars[j] = ch[i];
                            j++;
                        }
                    }
                }
                flag++;
            }
            j=0;
            for (int i = 0; i < ch.length; i++) {
                if ((ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122)){
                    ch[i] = chars[j];
                    j++;
                }
            }
            System.out.println(String.valueOf(ch));
        }
        */
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str = in.nextLine();
            System.out.println(sort(str));
        }
    }

    private static String sort(String str) {
        //先将英文字母收集起来
        List<Character> letters = new ArrayList<>(str.length());
        for (char ch : str.toCharArray()) {
            //Character.isLetter(ch)该函数是判断该字符是否是字母的函数
            if (Character.isLetter(ch)){
                letters.add(ch);
            }
        }
        //将英文字母先排好序
        letters.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {

                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        //若是非英文字母则直接添加
        StringBuilder result = new StringBuilder();
        for (int i = 0,j = 0;i < str.length();i++){
            if (Character.isLetter(str.charAt(i))){
                //如果是英文字母则将英文字母按照之前收集的英文字母的顺序进行加入
                result.append(letters.get(j++));
            }else {
                //如果不是英文字母，则直接将字符串的该位置的字符进行加入到结果中
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }


}
