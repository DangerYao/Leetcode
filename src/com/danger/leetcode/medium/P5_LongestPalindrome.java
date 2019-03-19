package com.danger.leetcode.medium;

/**
 * 最长回文子串
 * 
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 * @author Danger
 *
 */
public class P5_LongestPalindrome {

	public static void main(String[] args) {
		String s1 = "babad";
		String s2 = "cbbd";
		String s3 = "bbbb";
		String s4 = "abcd";
		String s5 = "a";
		
		String s6 = "lkdasjkdljaskdljaskdhkjdfhasdjfds";
		
		System.out.println(longestPalindrome(s1));
		System.out.println(longestPalindrome(s2));
		System.out.println(longestPalindrome(s3));
		System.out.println(longestPalindrome(s4));
		System.out.println(longestPalindrome(s5));
		System.out.println(longestPalindrome(s6));
		
//		assert longestPalindrome(s1).equals("aba") : "expect 'aba'";
//		assert longestPalindrome(s2).equals("bb") : "expect 'bb'";
				
				
	}
	
	public static String longestPalindrome(String s) {
        
		// 动态规划实现  时间复杂度O(n^2)
		
		// 边界检查
		if(s == null) {
			return null;
		}
		
		// 如果字符串小于2个,回文是其本身,直接返回
		if(s.length() < 2) {
			return s;
		}
		
		int len = s.length();
		
		char[] chs = s.toCharArray();
		
		int[][] dp = new int[len][len]; // 动态规划数组，存储长度
		boolean[][] isPalindorme = new boolean[len][len]; // 存储是否是回文
		
		int max = 0;	// 记录最长回文子串长度
		int l=0, r=0;   // 记录最长回文子串的左右下标
		
		for(int i=len-1; i>=0; i--) {
			dp[i][i] = 1;
			isPalindorme[i][i] = true;
			for(int j=i+1; j<len; j++) {

				if(chs[i] == chs[j] && (isPalindorme[i+1][j-1] || i+1 > j-1)) {
					dp[i][j] = dp[i+1][j-1] + 2;
					isPalindorme[i][j] = true;
				} else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
				
				if(dp[i][j] != 1 && max < dp[i][j] ) {
					max = dp[i][j];
					l = i;
					r = j;
				}
			}
		}
		
		return s.substring(l, r+1);
    }

}
