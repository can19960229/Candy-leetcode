package cap_1_3;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/16 14:51
 * version 1.0
 * Description: 下压栈（能够动态调整数组大小的实现）
 *
 * 泛型的可迭代的Stack API的实现是所有集合类抽象的数据类型实现的模板
 * 将所有元素保存在数组中，并动态调用数组的大小以保持数组大小和栈大小之比小于一个常数
 */

import java.util.Iterator;

/**
 *动态调用数组的大小   扩容缩容问题
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a =(Item[]) new Object[1];
    private int N = 0;
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    private void resize(int max){
        //将栈移动到一个大小为max的新数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        //将元素添加到栈顶
        if (N == a.length)
            resize(2*a.length);
        a[N++] = item;
    }
    public Item pop(){
        //栈顶删除元素
        Item item = a[--N];
        a[N] = null;  //避免对象游离
        if (N > 0 && N == a.length/4){
            resize(a.length/2);
        }
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        //  支持后进先出的迭代
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
