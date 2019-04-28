package com.danger.leetcode.easy;

/**

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 * @author Danger
 *
 */
public class P66_PlusOne {

	public static void main(String[] args) {
		/**
		 * 测试用例：
		 * 1. 0
		 * 2. 产生进位的数，如 9
		 * 3. 位数+1增加的数： 如999
		 * 4. 一般的数，如4321
		 */
		int[] result1 = plusOne(new int[] {0});
		int[] result2 = plusOne(new int[] {9});
		int[] result3 = plusOne(new int[] {9,9,9});
		int[] result4 = plusOne(new int[] {4,3,2,1});
		int[] result5 = plusOne(new int[] {2,2,2,2,9});
		
		System.out.println();
		for (int i : result1) {
			System.out.print(i);
		}
		
		System.out.println();
		for (int i : result2) {
			System.out.print(i);
		}
		
		System.out.println();
		for (int i : result3) {
			System.out.print(i);
		}
		
		System.out.println();
		for (int i : result4) {
			System.out.print(i);
		}
		
		System.out.println();
		for (int i : result5) {
			System.out.print(i);
		}
		
	}
	
	/**
	 * 思路：从后向前遍历，没进位直接返回，进位后只能为0，前位+1，
	 * 	        如果第1位也产生进位，则为1+n个0
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
        
		// 边界检查
		if(digits == null || digits.length == 0) {
			return new int[] {0};
		}
		
		int len = digits.length;
		
		// 考虑到只能进1 , 因为+1, 进位后只能为0
		for(int i=len-1; i>=0; i--) {
			digits[i]++;
			if(digits[i] < 10) {
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		
		int[] newDigits = new int[len+1];
		newDigits[0] = 1;
		
		return newDigits;
    }

	/**
	 * 思路：
	 * 1. 最后一位+1，如果没有大于等于10，直接返回数组，如果大于10，最后一位等于其对10取模值
	 * 2. 然后最倒数第二位进行第1步
	 * 3. 如果最后第一位也是大于等于10，则数组扩大一位
	 * @param digits
	 * @return
	 */
	public static int[] plusOne1(int[] digits) {
        
		// 边界检查
		if(digits == null || digits.length == 0) {
			return new int[] {0};
		}
		
		int len = digits.length;
		digits[len-1] = digits[len-1] + 1;
		
		if(digits[len-1] < 10) { // 没有产生进位，可以直接返回数组
			return digits;
		}
		int p = len - 1 ;
		int carry = 0; // 进位标志
		// 产生了进位，处理
		while(p > 0) {
			carry = digits[p] / 10;
			digits[p] = digits[p] % 10;
			if(carry == 0) {	// 没有产生进位时，直接返回数组
				return digits;
			}
			digits[p-1] = digits[p-1] + carry;
			p--;
		}
		
		// 判定最后一位是否是否产生了进位
		if(digits[0] < 10) {
			return digits;
		} else {
			// 扩展1位
			int[] newDigits = new int[len+1];
			newDigits[0] = digits[0] / 10;
			digits[0] = digits[0] % 10;
			// 将其他数组迁移
			for(int i=0;i<len;i++) {
				newDigits[i+1] = digits[i];
			}
			return newDigits;
		}
    }
}
