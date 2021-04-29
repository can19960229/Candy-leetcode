package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 22:29
 *
 * @Classname JZ21
 * Description: 栈的压入、弹出序列
 */

import java.util.Stack;

/**
 *
 */
public class JZ21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for (int i = 0;i < pushA.length;i++){
            st.push(pushA[i]);
            while (!st.isEmpty() && st.peek() == popA[j]){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}
