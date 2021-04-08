package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/7 15:20
 *
 * @Classname JZ2
 * Description: 替换空格
 */

/**
 *
 */
public class JZ2 {

    public static String replaceSpace(String s){
        if (s == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(" ")){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return String.valueOf(sb);
    }
    public static String replaceSpace1(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int spaceNum = 0;
        int m = s.length();

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c == ' '){
                spaceNum++;//统计空格数
            }
        }
        //p1指向原字符串末尾
        int p1 = m - 1;
        //p2指向替换之后字符串的末尾，spaceNum为空格数，3是“%20”的长度
        int p2 = p1 + spaceNum * 2;

        char[] tmp = new char[p2 + 1]; //重新创建一个新的数组长度为替换之后的长度
        for (int i = 0; i < s.length(); i++) {
            tmp[i] = s.charAt(i); //把原字符串复制进新创建的数组中
        }
        //当p1和p2指向同一位置时，说明已经替换完毕
        while (p1 >= 0 && p1 != p2){
            if (tmp[p1] == ' '){
                tmp[p2--] = '0';
                tmp[p2--] = '2';
                tmp[p2--] = '%';
            }else {
                tmp[p2--] = tmp[p1];
            }
            p1--;//每判定一个字符串就向左移动一次
        }
        return new String(tmp);
    }


        public static void main(String[] args) {
        System.out.println(replaceSpace("we are happy"));
    }
}
