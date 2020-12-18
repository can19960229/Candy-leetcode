package some_problem;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/7/23 20:35
 * version 1.0
 * Description: 用两个栈实现队列的功能
 */

import java.util.Stack;

/**
 *入队操作的时间复杂度为O(1)
 * 出队操作的时间复杂度为O(n),因为涉及栈A和栈B元素的迁移，如果不迁移则时间复杂度为O(1)
 * 均摊时间复杂度
 */
public class StackToQueue {

    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();

    /**
     * 入队操作
     * @param element 入队元素
     */
    public void enQueue(int element){
        stackA.push(element);
    }

    /**
     * 出队操作
     * @return
     */
    public Integer deQueue(){
        if (stackB.isEmpty()){
            if (stackA.isEmpty()){
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 栈A元素转移到栈B
     */
    private void transfer() {
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.enQueue(1);
        stackToQueue.enQueue(2);
        stackToQueue.enQueue(3);
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
        stackToQueue.enQueue(4);
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
    }
}
