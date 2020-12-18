package some_problem;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/7/17 21:03
 * version 1.0
 * Description: 最小栈的实现
 */

import java.util.Stack;

/**
 *设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 */
public class minStack {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 入栈操作
     * @param element 入栈元素
     */
    public void push(int element){
        mainStack.push(element);
        //如果辅助栈位空，或者新元素小于或等于辅助栈栈顶，则将新元素压入辅助栈
        if (minStack.empty() || element <= minStack.peek()){
            minStack.push(element);
        }
    }

    /**
     * 出栈操作
     * @return
     */

    public Integer pop(){
        //如果出栈元素和辅助栈栈顶元素值相等，辅助栈出栈
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }
    /**
     * 获取栈的最小元素
     */
    public int getMin() throws Exception {
        if (mainStack.empty()){
            throw new Exception("栈是空的");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        some_problem.minStack stack = new minStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
