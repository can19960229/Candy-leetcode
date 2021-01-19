package 左程云算法课.class_03;

/**
 * 三个题目：
 * 1. 判断链表是否成环
 * 		方法一：存在HashMap中，遍历一遍map，判断遍历的值是否在map中出现过，如果出现过则该节点就是第一个相交的节点；没出现过则就没有成环
 * 2. 判断两个不成环的单链表的第一个相交的节点
 * 3. 判断两个成环的单链表的第一个相交的节点
 */

public class Code_14_FindFirstIntersectNode {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);//得到链表第一个入环节点
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {//两个无环链表的相交问题
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {//两个有环链表的相交问题
			return bothLoop(head1, loop1, head2, loop2);//把两个链表和两个链表的第一个入环节点都传进去
		}
		return null;//loop1或者loop2有一个为空，另一个不为空，则不可能相交返回null
	}

	/**
	 * 求 链表第一个入环节点
	 * @param head
	 * @return
	 */
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {//快指针和慢指针在环中相遇的时候停止
			if (n2.next == null || n2.next.next == null) {//快指针提前遇到结尾了，则直接返回空，不可能有环
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head 快指针走到开头，并且快指针变为只走一步
		while (n1 != n2) { //再次相交的时候就是第一个入环的节点
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	/**
	 * 两个无环链表相交的问题
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0; // 两个链表的差值
		while (cur1.next != null) {//走到最后一个结点则跳出
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) { //cur1 cur2 表示两个链表的最后一个结点，如果两个链表的最后一个节点不相等，则不可能相交
			return null;
		}
		//定位谁是长链表，谁是短链表
		cur1 = n > 0 ? head1 : head2; //cur1  为 长链表的头部
		cur2 = cur1 == head1 ? head2 : head1; // cur2 为短链表的头部
		n = Math.abs(n); //求两个链表的差值
		while (n != 0) {
			n--; // 长的链表先走差值的步数够再和短的链表一起走
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1; //相遇的时候返回变量，则为共同进入的第一个节点
	}


	/**
	 * 两个成环链表相交的问题
	 * @param head1
	 * @param loop1
	 * @param head2
	 * @param loop2
	 * @return
	 */
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) { //情况2
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else { //情况1或者情况3
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) { //遇到loop2
					return loop1; //返回节点
				}
				cur1 = cur1.next; // loop1 一直在转，如果loop1 都跑完了还没有碰到loop2，则返回空
			}
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
