package com.danger.leetcode.medium;

/**
 * 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 * @author Danger
 * @Date 2019年4月3日
 *
 */
public class P19_RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		
		// 测试用例
		// 1. 空链表
		// 2. 链表长度比n小
		// 3. 链表长度等于n
		// 4. 链表长度大于n
		
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);
		node1.next.next.next = new ListNode(4);
		node1.next.next.next.next = new ListNode(5);
		
		ListNode result1 = removeNthFromEnd(node1, 2);
		
		System.out.println("1:");
		while (result1 != null) {
			System.out.print(result1.val + " -> ");
			result1 = result1.next;
		}
		System.out.println();
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(2);
		node2.next.next = new ListNode(3);
		node2.next.next.next = new ListNode(4);
		node2.next.next.next.next = new ListNode(5);
		
		ListNode result2 = removeNthFromEnd(node2, 5);
		
		System.out.println("2:");
		while (result2 != null) {
			System.out.print(result2.val + " -> ");
			result2 = result2.next;
		}
		System.out.println();
		
		ListNode node3 = new ListNode(1);
		node3.next = new ListNode(2);
		node3.next.next = new ListNode(3);
		node3.next.next.next = new ListNode(4);
		node3.next.next.next.next = new ListNode(5);
		
		ListNode result3 = removeNthFromEnd(node3, 6);
		
		System.out.println("3:");
		while (result3 != null) {
			System.out.print(result3.val + " -> ");
			result3 = result3.next;
		}
		System.out.println();
		
		ListNode node4 = null;
		
		ListNode result4 = removeNthFromEnd(node4, 2);
		
		System.out.println("4:");
		while (result4 != null) {
			System.out.print(result4.val + " -> ");
			result4 = result4.next;
		}
		System.out.println();
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        
		// 边界检查
		if(head == null) {
			return null;
		}
		
		if(n<=0) {
			return head;
		}
		
		// 定义前后指针,用哨兵占用第一个节点, 用哨兵主要是处理n等于链表长度的边界问题
		ListNode pre = new ListNode(0), tail = pre, h = tail;	
		pre.next = head;
		
		// 前指针先走n个节点
		while( n>0 && pre.next != null) {
			pre = pre.next;
			n--;
		}
		
		// 说明链表长度比n小，没有办法删除倒数第n个节点
		if(n > 0) {
			return head;
		}
		
		// 前后指针同时移动
		while (pre.next != null) {
			pre = pre.next;
			tail = tail.next;
		}
		
		tail.next = tail.next.next;
		
		return h.next;
    }
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x; 
		}
	}
}
