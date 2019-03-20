package com.danger.leetcode.easy;

/**
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？

 * @author Danger
 *
 */
public class P9_PalindromeNumber {

	public static void main(String[] args) {
		int x = 100;
		System.out.println(isPalindrome(x));
	}
	
	/**
	 *  将其转换为字符串,并对字符串转换为Char数组，对数组进行处理
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String xStr = String.valueOf(x);
		char[] chars = xStr.toCharArray();
		int l,r; // 左右指针
		if(chars.length % 2 == 0) {
			r = chars.length / 2;
			l = r - 1;
			while(l>=0 && chars[l] == chars[r]) {
				l--;
				r++;
			}
			if(l >= 0) {
				return false;
			} 
		} else {
			l = r = chars.length / 2;
			while(l>=0 && chars[l] == chars[r]) {
				l--;
				r++;
			}
			if(l >= 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 *  不采用String处理
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome2(int x) {
		int div = 1;
		if (x < 0) {
			return false;
		}
		while (x/div >= 10) {
			div *= 10;
		}
		while (x > 0) {
			if(x/div != x%10) {
				return false;
			}
			x = (x%div)/10;
			div /= 100;
		}
		return true;
	}
	
	public static boolean isPalindrome3(int x) {
		// without extra space and no extra call stack
		// maybe this is a stupid way, but in line with the questions.
		// if we can use the space O(1),
		// we can try these code which in comments
		
		//		int div = 1;
		//		if (x < 0) {
		//			return false;
		//		}
		//		while (x/div >= 10) {
		//			div *= 10;
		//		}
		//		while (x > 0) {
		//			if(x/div != x%10) {
		//				return false;
		//			}
		//			x = (x%div)/10;
		//			div /= 100;
		//		}
		//		return true;
		
		if(x < 0) {	 
			return false;
		}
		if(x < 10) { // 1
			return true;
		} else if ( x < 100) { //2 
			if(x%10 == x/10) {
				return true;
			} else {
				return false;
			}
		} else if ( x < 1000) { //3
			if(x%10 == x/100) {
				return true;
			} else {
				return false;
			}
		} else if ( x < 10000) { //4
			if((x%10 == x/1000)) {
				x = x%1000;
				x = x/10;
				if(x%10 == x/10) {
					return true;					
				}
			}
			return false;
			
		} else if ( x < 100000) { //5
			if((x%10 == x/10000)) {
				x = x%10000;
				x = x/10;
				if(x%10 == x/100) {
					return true;					
				}
			}
			return false;
			
		} else if ( x < 1000000) { //6
			if((x%10 == x/100000)) {
				x = x%100000;
				x = x/10;
				if(x%10 == x/1000) {
					x = x%1000;
					x = x/10;
					if(x%10 == x/10) {
						return true;					
					}
				}
			}
			return false;
			
		} else if ( x < 10000000) { //7
			if((x%10 == x/1000000)) {
				x = x%1000000;
				x = x/10;
				if(x%10 == x/10000) {
					x = x%10000;
					x = x/10;
					if(x%10 == x/100) {
						return true;					
					}
				}
			}
			return false;
			
		} else if ( x < 100000000) { //8
			if((x%10 == x/10000000)) {
				x = x%10000000;
				x = x/10;
				if(x%10 == x/100000) {
					x = x%100000;
					x = x/10;
					if(x%10 == x/1000) {
						x = x%1000;
						x = x/10;
						if(x%10 == x/10) {
							return true;					
						}
					}
				}
			}
			return false;
			
		} else if ( x < 1000000000) { //9
			if((x%10 == x/100000000)) {
				x = x%100000000;
				x = x/10;
				if(x%10 == x/1000000) {
					x = x%1000000;
					x = x/10;
					if(x%10 == x/10000) {
						x = x%10000;
						x = x/10;
						if(x%10 == x/100) {
							return true;					
						}
					}
				}
			}
			return false;
			
		} else if ( x < Integer.MAX_VALUE) { //10
			if((x%10 == x/1000000000)) {
				x = x%1000000000;
				x = x/10;
				if(x%10 == x/10000000) {
					x = x%10000000;
					x = x/10;
					if(x%10 == x/100000) {
						x = x%100000;
						x = x/10;
						if(x%10 == x/1000) {
							x = x%1000;
							x = x/10;
							if(x%10 == x/10) {
								return true;					
							}
						}
					}
				}
			}
			return false;
		}        
		
		return false;
    }
}
