package com.danger.leetcode.easy;

/**

 给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

 * @author Danger
 *
 */
public class P67_AddBinary {

	public static void main(String[] args) {
		/**
		 * 	测试用例
		 */
		
		System.out.println(addBinary("11", "1")); // 100
		System.out.println(addBinary("1010", "1011")); // 10101
		System.out.println(addBinary("1111", "1111"));
		System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
		"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
	}
	
	/**
	 * 	思路： 将a、b转换成char数组，倒序进行相加，并进行进位处理
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary(String a, String b) {
        
		// 边界检查
		if(a == null || a.isEmpty()) {
			return b;
		}
		
		if(b == null || b.isEmpty()) {
			return a;
		}
		
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		
		int pa = aChars.length-1, pb = bChars.length-1;	// 定义指针
		char aChar, bChar;
		int carry = 0;
		char[] sum = new char[Math.max(aChars.length, bChars.length) + 1];
		int ps = sum.length -1;
		int tempSum;
		
		while(pa >= 0 && pb >= 0) {
			aChar = aChars[pa--];
			bChar = bChars[pb--];
			
			tempSum = (aChar - '0') + (bChar - '0') + carry;
			
			sum[ps--] = (char) (tempSum % 2 + '0');
			
			carry = tempSum / 2;
		}
		
		while(pa >= 0 ) {
			tempSum = (aChars[pa--] - '0') +  carry;
			sum[ps--] = (char) (tempSum % 2 + '0');
			carry = tempSum / 2;
		}
		
		while(pb >= 0 ) {
			tempSum = (bChars[pb--] - '0') +  carry;
			sum[ps--] = (char) (tempSum % 2 + '0');
			carry = tempSum / 2;
		}
		
		if(carry > 0) {
			sum[ps--] = '1';
		} else {
			return String.copyValueOf(sum, 1, sum.length-1);
		}
		
		return String.valueOf(sum);
    }
	
	
	/**
	 * 思路：采用Integer类现成的转换二进制数方法，然后把二进制数相加求和转换为String
	 * 注： 此方法无法处理大数据，Integer具有数据范围
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary2(String a, String b) {
        
		// 边界检查
		if(a == null || a.isEmpty()) {
			return b;
		}
		
		if(b == null || b.isEmpty()) {
			return a;
		}
		
		Integer a2 = Integer.valueOf(a, 2);
		Integer b2 = Integer.valueOf(b, 2);
		
		Integer result2 = a2 + b2;
		
		String result = Integer.toString(result2, 2);
		
		return result;
    }

}
