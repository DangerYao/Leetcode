package com.danger.leetcode.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.

	click to show spoilers.
	Some hints:
	
	Could negative integers be palindromes? (ie, -1)
	
	If you are thinking of converting the integer to string, 
	note the restriction of using extra space.
	
	You could also try reversing an integer. However, 
	if you have solved the problem "Reverse Integer", 
	you know that the reversed integer might overflow. 
	How would you handle such case?

	There is a more generic way of solving this problem.

 * @author DangerYao
 *
 */
public class P9_PalindromeNumber {

	public static void main(String[] args) {
		int x = 0;
		System.out.println(isPalindrome(x));
	}
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
	
	public static boolean isPalindrome(int x) {
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
