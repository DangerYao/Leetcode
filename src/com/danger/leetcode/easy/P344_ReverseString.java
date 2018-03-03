package com.danger.leetcode.easy;

public class P344_ReverseString {
	
	public static void main(String[] args) {
		System.out.println(reverseString2(""));
	}
	
	// use StringBuffer
	public static String reverseString(String s) {
		StringBuffer sb = new StringBuffer(s);
		sb = sb.reverse();
		return sb.toString();
	}
	
	// 
	public static String reverseString2(String s) {
		if(s == null || s.length() < 1) 
			return "";
		char[] chs = s.toCharArray();
		int start = 0;
		int end = chs.length-1;
		while(start < end) {
			char temp = chs[start];
			chs[start] = chs[end];
			chs[end] = temp;
			start++;
			end--;
		}
		return new String(chs);
	}
}
