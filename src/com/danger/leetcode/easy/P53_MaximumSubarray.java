package com.danger.leetcode.easy;

/**
 * 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author Danger
 * @Date 2019年3月30日
 *
 */
public class P53_MaximumSubarray {

	public static void main(String[] args) {
		int[] nums1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums2 = new int[] {-2,-1,-3,-4,-1,-2,-1,-5,-4};
		int[] nums4 = new int[] {1,2,3,4,5,6,7};
		int[] nums5 = new int[] {1,2,3,4,-5,-6,-7};
		int[] nums6 = new int[] {1,2,-3,4,5,6,7};
		
		System.out.println(maxSubArray(nums1));
		System.out.println(maxSubArray(nums2));
		System.out.println(maxSubArray(nums4));
		System.out.println(maxSubArray(nums5));
		System.out.println(maxSubArray(nums6));
	}

	/**
	 * 动态规划，转移方程为 dp[i] = max(dp[i-1]+nums[i],nums[i]);
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
        
		// 有题目可以看出, 不需要边界检查
		
		int[] dp = new int[nums.length]; 	// 保存到i位置的最大值 
		int maxSum = nums[0];		// 最大和
		dp[0] = nums[0];	// 初始化第1个数
		// 需要考虑全是负数的情况
		for(int i=1;i<nums.length;i++) {
			dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
			if(dp[i] > maxSum) {
				maxSum = dp[i];
			}
		}
		
		return maxSum;
    }

	/**
	 * 扫描法，遇到正数会使和增大，遇到负数会使和减少
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums) {
        
		// 有题目可以看出, 不需要边界检查
		
		int curSum = nums[0]; 	// 当前和
		int maxSum = nums[0];	// 最大和

		// 需要考虑全是负数的情况
		for(int i=1;i<nums.length;i++) {
			if(curSum >= 0) {
				curSum += nums[i];
			} else {				// 如果当前和小于0,会影响后续和,舍去
				curSum = nums[i];
			}
			
			if(curSum > maxSum) {
				maxSum = curSum;
			}
		}
		
		return maxSum;
    }
}
