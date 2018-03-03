package com.danger.leetcode.easy;

/**
 * Given a string and an integer k, you need to reverse the first k characters 
 * for every 2k characters counting from the start of the string. 
 * If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, 
 * then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * 		 The string consists of lower English letters only.
 *    	 Length of the given string and k will in the range [1, 10000]
 * @author DangerYao
 *
 */
public class P541_ReverseString2 {
	public static void main(String[] args) {
		System.out.println(reverseString("abcdefghijklmnobq",3));
	}
	
	// use StringBuffer
	public static String reverseString(String s,int k) {
		if(s == null || s.length() < 1) 
			return "";
		if(k < 0) 
			return s;
		char[] chs = s.toCharArray();
		int nk = (int)Math.ceil(chs.length/(double)k); // 向上取整
		for(int i = 0; i<= nk; i+=2) {			
			int start = i * k;
			int end = start + k-1;
			end = end < chs.length ? end : chs.length-1 ;
			while(start < end) {
				char temp = chs[start];
				chs[start] = chs[end];
				chs[end] = temp;
				start++;
				end--;
			}
		}
		return new String(chs);
	}
}
