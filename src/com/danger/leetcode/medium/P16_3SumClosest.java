package com.danger.leetcode.medium;

import java.util.Arrays;

/**
 * 最接近的三数之和

给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author Danger
 *
 */
public class P16_3SumClosest {

	public static void main(String[] args) {
		int[] nums1 = {-1,2,1,-4};
		int target1 = 1;
		
		int[] nums2 = {-1,0,0,0,1};
		int target2 = 1;
		
		int[] nums3 = {-1,0,3,0,1};
		int target3 = 2;
		
		System.out.println(threeSumClosest(nums1, target1));
		System.out.println(threeSumClosest(nums2, target2));
		System.out.println(threeSumClosest(nums3, target3));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
        
		Arrays.sort(nums);
		int result = 0,sum;
		int minDistance = Integer.MAX_VALUE;	// 记录最小距离
		int desitance;	// 三数和与target的距离
		int l,r; // 左右指针
		
		for (int i = 0 ; i<nums.length-2; i++) {
			if(i==0 || nums[i] > nums[i-1]) { // 相同的不用进行计算
				l = i+1;
				r = nums.length - 1;
				while(l<r) {
					sum = nums[i] + nums[l] + nums[r];
					desitance = Math.abs(target-sum);
					if(desitance < minDistance) {
						minDistance = desitance;
						result = sum;
					}
					
					if(target < sum) { // target比sum小，继续缩小sum
						r--;
						while(l<r && nums[r] == nums[r+1]) r--;
					} else if(target > sum) { // target比sum大，继续增大sum
						l++;
						while(l<r && nums[l] == nums[l-1]) l++;
					} else { 
						return result;
					}
				}
			}
		}
		
		return result;
    }

}
