package com.danger.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 * @author Danger
 *
 */
public class P14_LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs1 = new String[] {"flower","flow","flight"};
		String[] strs2 = new String[] {"dog","racecar","car"};
		String[] strs3 = new String[] {"a"};
		String[] strs4 = new String[] {"flower","flower","flower"};
		
		System.out.println(longestCommonPrefix(strs1));
		System.out.println(longestCommonPrefix(strs2));
		System.out.println(longestCommonPrefix(strs3));
		System.out.println(longestCommonPrefix(strs4));
	}

	
	public static String longestCommonPrefix(String[] strs) {
        
		//边界检查
		if(strs == null || strs.length < 1) {
			return "";
		}
		int p=0;	// 剪切指针
		String result = "";	
		
		if(strs[0].length() == 0) {
			return "";
		}
		
		outer: while(true) {
			result = strs[0].substring(0, p);
			for (String s : strs) {
				if(!s.startsWith(result)) {
					if(result.length() > 0) {
						result = result.substring(0, result.length()-1);
					}
					break outer;
				}
			}
			if(++p > strs[0].length()) {
				break;
			}
		}
		
		return result;
    }

	/**
	 * 拆分成char数组
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix2(String[] strs) {
        
		//边界检查
		if(strs == null || strs.length < 1) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder(); // 记录公共前缀
		char[][] chars = new char[strs.length][];
		for(int i=0; i<strs.length; i++) {
			chars[i] = strs[i].toCharArray();
		}
		Set<Character> set = new HashSet<>();
		int p = 0; // 字符指正
		outer : while(true) {
			for(int i=0;i<strs.length;i++) {
				if(p < chars[i].length) {
					set.add(chars[i][p]);
				} else { // 说明有个字符串遍历完了
					break outer;
				}
			}
			if(set.size() > 1) { // 说明不相同
				break;
			}
			sb.append(chars[0][p]);
			set.clear();
			p++;
		}
		
		return sb.toString();
    }
}
