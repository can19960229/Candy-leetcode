package array;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/25 10:01
 *
 * @Classname 单调栈
 * Description:
 *
 * 单调递增栈：单调递增栈就是从栈底到栈顶数据是从大到小
 * 单调递减栈：单调递减栈就是从栈底到栈顶数据是从小到大
 */

import java.util.Stack;

/**
 *
 */
public class 单调栈 {

    public static int FieldSum(int [] v){
        Stack<Integer> st = null;
        int sum = 0;
        for (int i = 0; i < v.length; i++) {
            if (st.empty() || v[st.pop()] >v[i]){ //小于栈顶元素入栈
                st.push(i);
            }else{
                while (!st.empty() && v[st.pop()] <= v[i]){
                    int top = st.pop(); //取出栈顶元素
                    st.pop();
                    sum += (i - top -1); //这里需要少减一个1

                }
                st.push(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
