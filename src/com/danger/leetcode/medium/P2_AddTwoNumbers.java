package com.danger.leetcode.medium;

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

	如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	
	您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	
	示例：
	
	输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	输出：7 -> 0 -> 8
	原因：342 + 465 = 807
 * @author Danger
 *
 */
public class P2_AddTwoNumbers {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(9);
		node1.next = new ListNode(9);
		node1.next.next = new ListNode(9);
		
		ListNode node2 = new ListNode(9);
		node2.next = new ListNode(9);
		node2.next.next = new ListNode(9);
		
		ListNode result = addTwoNumbers(node1,node2);
		
		while(result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}
	
	
	/**
	 * 考虑情况：
	 * 1、链表长度不一致
	 * 2、只有1个节点时
	 * 3、链表为空（题目注明不为空）
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		// 时间复杂度O(n) 空间复杂度O(n)
        
		if(l1 == null || l2 == null) {
			throw new RuntimeException("The parameter is null");
		}
		
		ListNode result,resultP;
		ListNode p1 = l1.next, p2 = l2.next;
		int carryBit = 0;	//	进位标志
		int temp = l1.val + l2.val;
		carryBit = temp / 10;
		result = new ListNode(temp % 10);
		resultP = result;
		
		while (p1 != null && p2 != null) {
			temp = p1.val + p2.val + carryBit;
			carryBit = temp / 10;
			resultP.next = new ListNode(temp % 10);
			
			p1 = p1.next;
			p2 = p2.next;
			resultP = resultP.next;
		}
		
		while (p1 != null) {
			temp = p1.val + carryBit;
			carryBit = temp / 10;
			resultP.next = new ListNode(temp % 10);
			
			p1 = p1.next;
			resultP = resultP.next;
		}
		
		while (p2 != null) {
			temp = p2.val + carryBit;
			carryBit = temp / 10;
			resultP.next = new ListNode(temp % 10);

			p2 = p2.next;
			resultP = resultP.next;
		}
		
		if(carryBit > 0) {
			resultP.next = new ListNode(carryBit);
		}
		
		return result;
    }
	

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x; 
		}
	}
}