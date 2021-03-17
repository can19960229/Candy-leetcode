package content;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/14 20:39
 *
 * @Classname test_01
 * Description: 测试
 */

/**
 *
 */
public class test_01 {
/*

    public static void main(String[] args) {
        String res = "";
        List<StringBuilder> word = new ArrayList<>();
        String s = null;
        Scanner sc = new Scanner(System.in);
        while (sc.nextLine() != null){
            if (s.length() == 0){
                break;////如果输入为空就停止
            }
            StringBuilder w = new StringBuilder();
            for (int i=0;i<s.length();i++){//循环s
                if (bigletter(s.charAt(i))||smallletter(s.charAt(i)))
                    w.append(s.charAt(i));//如果是字母则直接压到s里
                if (!bigletter(s.charAt(i))&&!smallletter(s.charAt(i))){//否则把单词压到word了，并把符号也压进去
                    word.add(w);
                    w = new StringBuilder();
                    w.append(s.charAt(i));
                    word.add(w);
                    w = new StringBuilder();
                }
            }

            word.add(w);//把最后一个单词压进去
            work(word);
            word.clear();//清空word

        }
    }
    public static boolean bigletter(char c){//判断是不是大写字母
        if(c>='A'&&c<='Z') return true;
        return false;
    }
    public static boolean smallletter(char c){//判断是不是小写字母
        if (c>='a'&&c<='z') return true;
        return false;
    }
    public static boolean bigletterword(String s){//判断是不是word
        if (!bigletter(s.charAt(0))) return false;
        if (s.length()<=1) return false;
        for (int i=1;i<s.length();i++){
            if (!smallletter(s.charAt(i))) return false;
        }
        return true;
    }
    public static void work(List<StringBuilder> word){//处理每一个单词或符号
        int n=word.size();
        for (int i=0;i<n;i++){
            int inow=i;
            if (!bigletterword(String.valueOf(word.toString().length())))//如果不需要缩写则直接输出
                System.out.print(word[i]);
            if (bigletterword(word[i])) {
                if (i!=n-1){//最后一位要么跟着前面的缩写，要么就是只有一个符合的所以不用缩写
                    if (word[i+1]==" "&&bigletterword(word[i+2])){
                        int j;
                        for (j=i;j<n;j++){
                            if ((j-i)%2==0){
                                if (!bigletterword(word[j])){
                                    j--;
                                    break;
                                }

                                else
                                    System.out.print(word[j][0]);
                            }
                            else if (word[j]!=" ") break;

                        }//j停在了最后符合要求的word的最后一位的后面一位
                        System.out.print(" (");
                        for (int k=i;k<j-1;k+=2)
                            System.out.print(word[k] + ' ');
                        System.out.print(word[j-1]+')');

                        inow=j-1;//i直接跳过缩写的部分
                    }
                    else
                        System.out.print(word[i]);
                }
                else
                    System.out.print(word[i]);
            }
            i=inow;
        }
    }
*/

}
