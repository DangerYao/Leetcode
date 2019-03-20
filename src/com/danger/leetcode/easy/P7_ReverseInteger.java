package com.danger.leetcode.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author Danger
 *
 */
public class P7_ReverseInteger {

	public static void main(String[] args) {
		int x1 = 123;
		int x2 = -123;
		int x3 = 120;
		int x4 = Integer.MAX_VALUE; // 2147483647
		int x5 = Integer.MIN_VALUE; // -2147483648
		int x6 = 0;
		int x7 = 746384742;
		int x8 = 1534236469;
		
		System.out.println(reverse(x1));
		System.out.println(reverse(x2));
		System.out.println(reverse(x3));
		System.out.println(reverse(x4));
		System.out.println(reverse(x5));
		System.out.println(reverse(x6));
		System.out.println(reverse(x7));
		System.out.println(reverse(x8));
		
		System.out.println(reverse2(x1));
		System.out.println(reverse2(x2));
		System.out.println(reverse2(x3));
		System.out.println(reverse2(x4));
		System.out.println(reverse2(x5));
		System.out.println(reverse2(x6));
		System.out.println(reverse2(x7));
		System.out.println(reverse2(x8));
		
	}
	
	/**
	 * 思路：
	 * 1、区分数据正负数以及0；
	 * 2、定义result = 0 
	 * 3、将result+x%10，然后乘10,判定是否溢出;
	 * 4、x=x/10
	 * 5、如果x>=10时，循环3,4步，否则result=result+x,判定是否溢出;
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		
		int result = 0;
		int temp = Integer.MAX_VALUE/10;
		boolean sign = true;	// 保存正负号
		
		if(x == 0) {
			return 0;
		} else if (x < 0 ) {
			sign = false;
			if(x == Integer.MIN_VALUE) {
				return 0;
			}
			x = -x; // 将负数转换为正数
		}
		
		while (x >= 10) {
			result += x % 10;
			// 表示溢出
			if(result > temp ) {
				return 0;
			}
			result = result*10;
			x /= 10;
		}
		
		result += x;
		
		return sign ? result : -result;
    }
	
	/**
	 * 借助Java的String相关类
	 * 思路：
	 * 1、区分数据正负数以及0；
	 * 2、将数字转换成字符串；
	 * 3、利用字符串反转
	 * 4、将字符串parseInt,抛错时代表溢出，否则返回结果
	 * @param x
	 * @return
	 */
	public static int reverse2(int x) {
		int result = 0;
		boolean sign = true;	// 保存正负号
		
		if(x == 0) {
			return 0;
		} else if (x < 0 ) {
			sign = false;
			if(x == Integer.MIN_VALUE) {
				return 0;
			}
			x = -x; // 将负数转换为正数
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		sb.reverse();
		
		try {
			result = Integer.valueOf(sb.toString());
		} catch (Exception e) {
			return 0;
		}
		return sign ? result : -result;
    }

}
