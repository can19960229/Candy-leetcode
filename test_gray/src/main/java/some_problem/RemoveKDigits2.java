package some_problem;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/7/29 17:11
 * version 1.0
 * Description: 删去K个数组后的最小值
 */

/**
 * 给出一个整数，从该整数中去掉k个整数，要求剩下的整数形成新的整数尽可能小，则该如何选取去掉的数字
 */
public class RemoveKDigits2 {

    /**
     * 删除整数的k个数字，获得删除后的最小值
     * @param num   原整数
     * @param k     删除数量
     * @return  返回删除后获得的数
     */
    public static String removeKDigits(String num,int k){
        //新整数的最终长度 = 原整数长度 - k
        int newLength = num.length()-k;
        //创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0;i<num.length();i++){
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字时，栈顶数字出栈（相当于删除数字）
            while (top > 0 && stack[top -1]>c&&k>0){
                top = top -1;
                k = k -1;
            }
            //遍历到的当前数字入栈
            stack[top++]= c;

        }
        //找到栈中第1个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset<newLength && stack[offset] == '0'){
            offset++;
        }
        return offset == newLength? "0" : new String(stack,offset,newLength -offset);
    }


    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212",3));
        System.out.println(removeKDigits("30200",1));
        System.out.println(removeKDigits("10",2));
        System.out.println(removeKDigits("541270936",3));

    }

}
