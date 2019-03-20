package com.danger.leetcode.medium;
/**
在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−231) 。
 * @author Danger
 *
 */
public class P8_String2Integer_Atoi {

	public static void main(String[] args) {
		String string = "words and 987";
		System.out.println(myAtoi(string));
	}
	
	public static int myAtoi(String str) {
		int radix = 10;	// 进制
		int index = 0;	// 位置索引
		boolean negative = false;	// 是否是负数
		int result = 0;	//结果值
		StringBuffer numSb = new StringBuffer();	// 将数字字符串缓存
		
		if(str == null || "".equals(str) || (str = str.trim()).length() < 1) {
			return 0;
		}
		// 判断正负号
		char first = str.charAt(0);
		if(first == '-') {
			negative = true;
			index ++;
		} else if (first == '+') {
			index ++;
		}
		
		// radix == 10 有可能中间有非数字字符
		while (index < str.length()) {
			char ch = str.charAt(index);
			if(ch < '0' || ch > '9') {
				break;
			}
			numSb.append(ch);
			index ++;
		}
			
		if(numSb.length() < 1) {
			return 0;
		}
		
		try {
			result = Integer.parseInt(numSb.toString(), radix);
		} catch (NumberFormatException e) {
			// 超过了数字范围
			return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		
		return negative ? -result : result;
	}
}
