package com.danger.leetcode.easy;

/**
 * 合并两个有序列表

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

 * @author Danger
 * @Date 2019年3月31日
 *
 */
public class P21_MergeTwoSortedLists {

	public static void main(String[] args) {

		// 测试用例
		// 1. 两个正常链表
		// 2. 第一个链表为空
		// 3. 第二个链表为空
		// 4. 两个链表都为空
		// 5. 不等长链表
		// 		第一个长
		//		第二个长
		// 6. 两个链表数据完全相同
		
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(4);
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		
		ListNode result = mergeTwoLists(node1,node2);
		
		while(result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		
	}
	
	/**
	 * 直接将l2的相关节点拼接到l1上
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
		// 边界检查
		if(l1 == null) return l2;
		
		if(l2 == null) return l1;
		
		ListNode p1 = new ListNode(0), p2 = new ListNode(0); //创建两个哨兵，定义两个next指针指向l1,l2
		p1.next = l1;
		p2.next = l2;
		
		ListNode h1 = p1;
		
		ListNode temp;
		
		while (p1.next != null && p2.next != null) {
			if(p1.next.val >= p2.next.val) {
				temp = p2.next.next;
				p2.next.next = p1.next;
				p1.next = p2.next;
				p2.next = temp;
			} else {
				p1 = p1.next;
			}
		}
		
		if (p2.next != null) {
			p1.next = p2.next;
		}
		
		return h1.next; // 返回去掉哨兵后的合并链表
    }
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x; 
		}
	}
}
