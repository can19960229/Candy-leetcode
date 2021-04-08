package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/8 10:33
 *
 * @Classname JZ5
 * Description: 用两个栈实现队列
 */

import java.util.Stack;

/**
 * 一个栈压入元素，而另一个栈最为缓冲，将栈1的元素出栈后压入栈2中。也可以将栈1中的最后一个元素直接出栈，而不用压入栈2中再出栈。
 */
public class JZ5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        if (stack2.isEmpty()){
            if (stack1.isEmpty()){
                return 0;
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

    }
}
