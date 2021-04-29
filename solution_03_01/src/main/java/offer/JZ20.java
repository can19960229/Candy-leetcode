package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 22:05
 *
 * @Classname JZ20
 * Description: 测试
 */

import java.util.Stack;

/**
 *
 */
public class JZ20 {
    private static Stack<Integer> stack = new Stack<>();
    private static Integer minElement = Integer.MAX_VALUE;
    public void push(int node) {
        if (stack.empty()){
            minElement = node;
            stack.push(node);
        }else {
            if (node <= minElement){
                stack.push(minElement);//在push更小的值时需要保留在此值之前的最小值
                minElement = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        //增加最后一个元素以及栈为空时候的检测
        if (stack.size() == 0)
            return;
        if (minElement == stack.peek()){  //如果栈顶是最小值，如果将栈顶元素弹出，则最小值改变
            if (stack.size() > 1){  //判断栈中元素是否有两个或两个以上
                stack.pop();  //弹出栈顶元素
                minElement = stack.peek();  //弹出栈中元素，并修改最小值为弹出栈顶元素后的元素
            }else {
                minElement = Integer.MAX_VALUE; //如果栈中只有一个元素，则修改最小值为无穷大后再弹出
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minElement;
    }
}
