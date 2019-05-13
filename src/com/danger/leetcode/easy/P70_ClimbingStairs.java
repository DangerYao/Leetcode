package com.danger.leetcode.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 * @author Danger
 *
 */
public class P70_ClimbingStairs {

	public static void main(String[] args) {
		// 测试用例
		// 1. < 0
		// 2. = 0 
		// 3. = 1
		// 4. = 2
		// 5. = 10
		// 7. = 49876542
		// 8. = intMax
		
		System.out.println(climbStairs(-1));
		System.out.println(climbStairs(0));
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(10));
		// 下面的返回值超过了Integer Max,无法返回正确值
//		System.out.println(climbStairs(49876542));
//		System.out.println(climbStairs(Integer.MAX_VALUE));
	}

	/**
	 * 思路：采用动态规划
	 * f(1) = 1
	 * f(2) = 2
	 * ...
	 * f(n) = f(n-1) + f(n-2)
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
        
		// 边界检查
		if(n <= 2) {
			return n;
		}
		
		int[] dp = new int[n+1]; // 定义动态规划数组
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		
		return dp[n];
    }
	
	/**
	 * 这一种是上一种的变形，目的是减少空间复杂度
	 * @param n
	 * @return
	 */
	public static int climbStairs2(int n) {
        
		// 边界检查
		if(n <= 2) {
			return n;
		}
		
		int result = 0, temp1 = 1, temp2 = 2;
		
		
		for(int i=3; i<=n; i++) {
			result = temp1 + temp2;
			temp1 = temp2;
			temp2 = result;
		}
		
		
		return result;
    }
}
