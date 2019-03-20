package com.danger.leetcode.medium;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);

示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
 * @author Danger
 *
 */
public class P6_ZigZagConversion {

	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		System.out.println(convert(s, 3));
		System.out.println(convert(s, 4));
	}

	/**
	 * 分析：
	 * 将字符换成数组下标，可以看出
	 * 第一排距离：2*(n-2) + 2 
	 * 第二排距离：偶数：2*(n-3) + 2 ; 奇数：2*2-2
	 * 第三排距离：偶数：2*(n-4) + 2 ; 奇数：2*3-2
	 * ...
	 * 第x排距离：偶数：2*(n-x-1) + 2 ; 奇数：2*x-2
	 * ...
	 * 第n排距离：2*(n-2)+2 
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
	    
		// 以下算法时间复杂度O(n) 空间复杂度O(n) 
		
		// 边界检查
		if(s == null || s.length() < numRows || numRows <= 1) {
			return s;
		}
		
		// 转换成char数组
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i;
		boolean isOdd = true;  // 是否是这排的第几个数
		int p;	// 当前下标
		
		for(i=1; i<=numRows; i++) {
			p = i - 1;
			while (p < chars.length) {
				sb.append(chars[p]);
				isOdd = !isOdd;
				
				// 第一排和最后一排
				if(i == 1 || i == numRows) {
					p += 2*(numRows-2) + 2;
					continue;
				}
				
				if(isOdd) {
					p += 2*i - 2;
				} else {
					p += 2*(numRows-i-1) + 2;
				}
			}
			isOdd = true;
		}
		
		return sb.toString();
	}
}
