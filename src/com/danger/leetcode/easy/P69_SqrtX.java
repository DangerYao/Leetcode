package com.danger.leetcode.easy;

/**
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
 * @author Danger
 *
 */
public class P69_SqrtX {

	public static void main(String[] args) {
		/**
		 * 测试用例
		 * 1. 0;
		 * 2. <0的数
		 * 3. 平方根是整数的数
		 * 4. 平方根是非整数的数
		 * 5. 最大数
		 */
		
		System.out.println(mySqrt(0));
		// System.out.println(mySqrt(-12));
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(11));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(198921832));
		System.out.println(mySqrt(2147483647));
	}

	/**
	 * 思路：采用二分法
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
        
		// 边界检查
		if( x < 2) { // 负数也直接返回原数
			return x;
		}
		
		// 因为整数最大值的平方为46340，所以可以在超过46340时取46340
		int l = 0, r = x > 46340 ? 46340 : x;
		int mid,temp;
		
		while( l <= r) {
			mid = l + (r-l) / 2;
			temp = x / mid;
			if(temp == mid) {
				return temp;
			} else if (temp < mid) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return r;
    }
}
