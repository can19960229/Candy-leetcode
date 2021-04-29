package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/28 10:05
 *
 * @Classname JZ25
 * Description: 复杂链表的复制
 */

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 */
public class JZ25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        while (p1 != null){
            map.put(p1,new RandomListNode(p1.label));
            p1 = p1.next;
        }
        while (p2 != null){
            if (p2.next != null){
                map.get(p2).next = map.get(p2.next);
            }else {
                map.get(p2).next = null;
            }
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }
}
