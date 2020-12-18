package array;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/19 20:10
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public interface MyStack<Item> extends Iterable<Item> {

    MyStack<Item> push(Item item);
    Item pop() throws Exception;
    boolean isEmpty();
    int size();
}