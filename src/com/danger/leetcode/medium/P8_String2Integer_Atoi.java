package com.danger.leetcode.medium;
/**
	Implement atoi to convert a string to an integer.
	
	Hint: Carefully consider all possible input cases. 
	If you want a challenge, please do not see below and ask yourself 
	what are the possible input cases.
	
	Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
	You are responsible to gather all the input requirements up front.
	
	Update (2015-02-10):
	The signature of the C++ function had been updated. 
	If you still see your function signature accepts a const char * argument, 
	please click the reload button to reset your code definition.
	
	Requirements for atoi:
	
	The function first discards as many whitespace characters as necessary 
	until the first non-whitespace character is found. Then, starting from this character, 
	takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
	and interprets them as a numerical value.
	
	The string can contain additional characters after those that form the integral number, 
	which are ignored and have no effect on the behavior of this function.
	
	If the first sequence of non-whitespace characters in str is not a valid integral number, 
	or if no such sequence exists because either str is empty
	 or it contains only whitespace characters, no conversion is performed.
	
	If no valid conversion could be performed, a zero value is returned. 
	If the correct value is out of the range of representable values, 
	INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 * @author DangerYao
 *
 */
public class P8_String2Integer_Atoi {

	public static void main(String[] args) {
		String string = "010";
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
		// 题目要求并没有要求是否含有多种进制，因为测试报错，所以先注释
		// 进制数
//		if (str.startsWith("0x", index) || str.startsWith("0X", index)) {
//            index += 2;
//            radix = 16;
//        }
//        else if (str.startsWith("#", index)) {
//            index ++;
//            radix = 16;
//        }
//        else if (str.startsWith("0", index) && str.length() > 1 + index) {
//            index ++;
//            radix = 8;
//        }
		
		
		if(radix == 8) {
			while (index < str.length()) {
				char ch = str.charAt(index);
				if(ch < '0' || ch > '7') {
					break;
				}
				numSb.append(ch);
				index ++;
			}
		} else if (radix == 16) {
			while (index < str.length()) {
				char ch = str.charAt(index);
				if(ch < '0' || (ch > '7' && ch < 'A') || (ch > 'F' && ch < 'a') || ch > 'f') {
					break;
				}
				numSb.append(ch);
				index ++;
			}
		} else  { // radix == 10
			while (index < str.length()) {
				char ch = str.charAt(index);
				if(ch < '0' || ch > '9') {
					break;
				}
				numSb.append(ch);
				index ++;
			}
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
