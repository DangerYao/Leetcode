package com.danger.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * @author Danger
 *
 */
public class P3_LengthOfLongetSubstring {

	public static void main(String[] args) {

		String s1 = "abcabcd";
		String s2 = "bbbbb";
		String s3 = "pwwkew";
		String s4 = "";
		String s5 = null;
		
		String s6 = "abcdefghiabcndheg";
		String s7 = "tmmzuxt";
		
		assert lengthOfLongestSubstring(s1) == 4 : "expect 4";
		assert lengthOfLongestSubstring(s2) == 1 : "expect 1";
		assert lengthOfLongestSubstring(s3) == 3 : "expect 3";
		assert lengthOfLongestSubstring(s4) == 0 : "expect 0";
		assert lengthOfLongestSubstring(s5) == 0 : "expect 0";
		assert lengthOfLongestSubstring(s6) == 10 : "expect 10";
		assert lengthOfLongestSubstring(s7) == 5 : "expect 5";
		
	}
	
	/**
	 * 考虑情况：
	 * 1、s 为空或者空串；
	 * 2、全是同一字符
	 * 3、有特殊字符
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		
		// 算法时间复杂度 O(n) 空间复杂度O(n)
		
		// 边界检查
		if(s == null || s.isEmpty()) {
			return 0;
		}
		
		// 存储字符位置
		Map<Character, Integer> map = new HashMap<>();
		int maxLength = 0;	// 最大长度
		int localLength = 0;	// 局部长度
		Integer charIndex;	// 字符缓存的位置
		
		char[] chars = s.toCharArray();
		for (int i=0; i < chars.length; i++) {
			
			// 如果map中不存在，就先记录下字符的位置
			if((charIndex = map.get(chars[i])) == null) {
				localLength ++;	// 局部长度增加1
			} else {
				// 说明遇到了重复字符
				maxLength = Math.max(maxLength, localLength); // 缓存最大长度
				localLength = Math.min(i - charIndex, localLength+1);  // 重新设置局部长度
			}
			map.put(chars[i], i);		
		}
		
		maxLength = Math.max(maxLength, localLength); // 最后又可能最大长度是局部长度
		
		return maxLength;
    }

}
