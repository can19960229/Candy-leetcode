package org.example; /**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/8 15:46
 * version 1.0
 * Description: org.example.LinkedListDemo 理解link结构
 */

/**
 *
 */
public class LinkedListDemo {
    private class Node {
        public Object elem;

        Node(Object o) {
			this.o = o;
		}

		Object o;
		Node next;
	}

	private Node first;

	public void add(Object elem) {
		Node node = new Node(elem);
		if (first == null) {
			first = node;
		} else {
			append(node);
		}
	}

	private void append(Node node) {
		// TODO 自动生成的方法存根
		Node last = first;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
	}

	private int size() {
		int count = 0;
		Node last = first;
		while (last != null) {
			last = last.next;
			count++;
		}
		return count;
	}

	public Object get(int index) {
		checkSize(index);
		return findElemOf(index);
	}

	private void checkSize(int index) throws IndexOutOfBoundsException {
		int size = size();
		if (index >= size) {
			throw new IndexOutOfBoundsException(String.format("Index：%d，Size：%d", index, size));
		}
	}

	private Object findElemOf(int index) {
		int count = 0;
		Node last = first;
		while (count < index) {
			last = last.next;
			count++;
		}
		return last.elem;//？？？
	}

}
