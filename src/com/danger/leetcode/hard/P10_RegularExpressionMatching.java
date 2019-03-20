package com.danger.leetcode.hard;

/**
 * 
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。
匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 * 
 * @author Danger
 *
 */
public class P10_RegularExpressionMatching {

	public static void main(String[] args) {
		
	}

	/**
	 * 思路：
	 * 1、将s、p转换成数组sArray,pArray
	 * 2、判定p的字符是否是'.'或者'*'
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
        
		// 边界检查
		if(s == null || p == null) {
			return false;
		}
		
		if(s.isEmpty() && p.isEmpty()) {
			return true;
		}
		
		// 将s 和 p 转换为char数组
		char[] sArray = s.toCharArray();
		char[] pArray = p.toCharArray();
		
		int ps=0,pp=0;	// sArray 和 pArray的下标指针
		
		while(ps < sArray.length && pp < pArray.length) {
			
		}
		
		
		return false;
    }
}
