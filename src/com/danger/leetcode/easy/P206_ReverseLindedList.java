package com.danger.leetcode.easy;

/**
 * Reverse a singly linked list.
 * @author DangerYao
 *
 */
public class P206_ReverseLindedList {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode node = head;
		for (int i=1; i<10000;i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
		
		ListNode rev = reverseList(head);
		
		while(rev != null) {
			System.out.print(rev.val + " ");
			rev = rev.next;
		}
	}
	
	// 非递归方式
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) 
			return head;
		ListNode pre = head;
		ListNode before = null;				//记录前一个节点
		ListNode next = head.next;			// 记录下一个节点
		head.next = null;
		while(next.next != null) {
			before = pre;
			pre = next;
			next = next.next;
			pre.next = before;
		}
		before = pre;
		pre = next;
		pre.next = before;
		return pre;
	}
	// 递归方式 
	public static ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x; 
		}
	}
}

