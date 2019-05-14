package com.danger.leetcode.easy;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
 * @author Danger
 *
 */
public class P83_RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {

		/**
		 * 测试用例：
		 * 1. null
		 * 2. 1->1->2->3->3
		 * 3. 3->3->3->3->3
		 */
		ListNode result0 = deleteDuplicates(null);
		
		System.out.println("0:" + result0);
		
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(1);
		node1.next.next = new ListNode(2);
		node1.next.next.next = new ListNode(3);
		node1.next.next.next.next = new ListNode(3);
		
		ListNode result1 = deleteDuplicates(node1);
		
		System.out.println("1:");
		while (result1 != null) {
			System.out.print(result1.val + " -> ");
			result1 = result1.next;
		}
		
		System.out.println();
		
		ListNode node2 = new ListNode(3);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(3);
		node2.next.next.next = new ListNode(3);
		node2.next.next.next.next = new ListNode(3);
		
		ListNode result2 = deleteDuplicates(node2);
		
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
		
		ListNode result3 = deleteDuplicates(node3);
		
		System.out.println("3:");
		while (result3 != null) {
			System.out.print(result3.val + " -> ");
			result3 = result3.next;
		}
	}

	/**
	 * 思路：从前向后遍历，如遇相同的继续向后遍历，当遇到不同的将他们链起来
	 * 在代码2上优化代码
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
        
		// 边界检查
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode now = head,
				 after = head.next;	
		
		while(after != null) {
			if(now.val == after.val) {
				now.next = after.next;
			} else {
				now = after;
			}
			after = after.next;
		}
		
		return head;
    }
	
	/**
	 * 思路：从前向后遍历，如遇相同的继续向后遍历，当遇到不同的将他们链起来
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates2(ListNode head) {
        
		// 边界检查
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode h = head, 
				 p = head,
				 temp = head;	// 保存头指针和定义移动指针
		boolean hasSame = false;
		
		while(p.next != null) {
			if(p.val == p.next.val) {
				if(!hasSame) { // 将相同的第一个赋值给temp
					temp = p;
				}
				hasSame = true;
			} else if(hasSame){
				hasSame = false;
				temp.next = p.next;
				temp = temp.next;
			} else {
				temp = p;
			}
			
			p = p.next;
		}
		
		if(hasSame) {
			temp.next = p.next;			
		}
		
		return h;
    }
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
