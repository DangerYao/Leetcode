package com.danger.leetcode.hard;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import jdk.internal.org.objectweb.asm.commons.LocalVariablesSorter;

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
		String s1 = "aa";
		String p1 = "a";
		
		String s2 = "aa";
		String p2 = "a*";
		
		String s3 = "ab";
		String p3 = ".*";
		
		String s4 = "aab";
		String p4 = "c*a*b";
		
		String s5 = "mississippi";
		String p5 = "mis*is*p*.";
		
		String s6 = "a";
		String p6 = ".";
		
		String s7 = "";
		String p7 = "ab";
		
		String s8 = "";
		String p8 = ".";

		String s9 = "";
		String p9 = ".*";
		
		String s10 = "dsda";
		String p10 = "*";
		
		String s11 = "abcdecdasdasfsdadfadsfsd";
		String p11 = "abcder.*";
		
		String s12 = "ab";
		String p12 = ".*c";
		
		String s13 = "aaa";
		String p13 = "a*a";
		
		String s14 = "abcdecdasdasfsdadfadsfsdabd";
		String p14 = "abcdec.*abd";
		
		assert isMatch(s1, p1) == false : "1 expect false";
		assert isMatch(s2, p2) == true : "2 expect true";
		assert isMatch(s3, p3) == true : "3 expect true";
		assert isMatch(s4, p4) == true : "4 expect true";
		assert isMatch(s5, p5) == false : "5 expect false";
		assert isMatch(s6, p6) == true : "6 expect true";
		assert isMatch(s7, p7) == false : "7 expect false";
		assert isMatch(s8, p8) == false : "8 expect false";
		assert isMatch(s9, p9) == true : "9 expect true";
		assert isMatch(s10, p10) == false : "10 expect false";
		assert isMatch(s11, p11) == false : "11 expect false";
		assert isMatch(s12, p12) == false : "12 expect false";
		assert isMatch(s13, p13) == true : "13 expect true";
		assert isMatch(s14, p14) == true : "14 expect true";
	}

	/**
	 *  暴力破解思路：
	 * 1、将s、p转换成数组sArray,pArray
	 * 2、判定p的字符是否是'.'或者'*'
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch2(String s, String p) {
        
		// 边界检查
		if(s == null || p == null) {
			return false;
		}
		
		// 处理特殊情况
		if(s.isEmpty() && p.isEmpty()) {
			return true;
		}
		
		if(s.isEmpty() && !p.equals(".*")) {
			return false;
		} else if (s.isEmpty()){
			return true;
		} 
		
		// 将s 和 p 转换为char数组
		char[] sArray = s.toCharArray();
		char[] pArray = p.toCharArray();
		
		int ps=0,pp=0;	// sArray 和 pArray的下标指针
		char temp;
		
		while(ps < sArray.length && pp < pArray.length) {

			if (pArray[pp] == '.' && pp+1 < pArray.length && pArray[pp+1] == '*') { // 后面直接是.*,需要看正则后面还有没有字符
				
				if(pp+1 == pArray.length-1) {
					return true;
				} else {
					pp++;
					temp = pArray[pp+1];
					while(ps < sArray.length && sArray[ps] != temp) {
						ps++;
					}
					if(ps == sArray.length) {
						return false;
					}
				}
			} else if(pArray[pp] == '.' ) { // 单独的'.'号
				ps++;
			} else if (pArray[pp] == '*'){
				if(pp == 0) { // 第一个符号就出现*号，输入错误，直接返回false
					return false;
				}
				temp = pArray[pp-1]; // 获取到前一个字符
				while(ps < sArray.length && sArray[ps] == temp) {
					ps++;
				}
			} else if ( pArray[pp] != sArray[ps] && pp+1 < pArray.length && pArray[pp+1] != '*') { // 普通的单独字符
				return false;
			} else if ( pArray[pp] == sArray[ps]) { // 普通的单独字符
				ps ++;
			}
			
			pp++;
		}
		
		// 说明正常匹配完毕
		if(ps == sArray.length) {
			return true;
		}
		
		return false;
    }
	
	/**
	 *  直接使用现有库
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch3(String s, String p) {
		// 边界检查
		if(s == null || p == null) {
			return false;
		}
		
		if(p.equals("*")) {
			return false;
		}
		
		return s.matches(p);
	}
	
	/**
	 *  采用动态规划
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		// 边界检查
		if(s == null || p == null) {
			return false;
		}
		
		if(p.equals("*")) {
			return false;
		}
		
		return s.matches(p);
	}
}
