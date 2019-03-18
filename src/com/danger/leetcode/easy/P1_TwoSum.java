package com.danger.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:

	给定 nums = [2, 7, 11, 15], target = 9

	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]
 * 
 * 
 * 
 * @author Danger
 *
 */
public class P1_TwoSum {

	public static void main(String[] args) {
		int[] nums1 = new int[]{2,7,11,15};
		int target1 = 9;
		assert Arrays.equals(twoSum2(nums1, target1),new int[] {0,1}) : "期望[0,1]";
		
		int[] nums2 = new int[]{};
		int target2 = 9;		
		assert twoSum2(nums2, target2) == null;
		
		int[] nums3 = null;
		int target3 = 9;		
		assert twoSum2(nums3, target3) == null;
		
		int[] nums4 = new int[]{4,6,2,1};
		int target4 = 9;		
		assert twoSum2(nums4, target4) == null;
		
		
		int[] nums5 = new int[]{4,6,5,1};
		int target5 = 9;		
		assert Arrays.equals(twoSum2(nums5, target5),new int[] {0,2}) : "期望[0,2]";
		
		System.out.println("success");
	}

	/**
	 *  情况考虑：
	 *  1、nums为空
	 *  2、nums只有一个数
	 *  3、没有答案
	 *  4、有多个答案
	 *  5、正常情况
	 *  6、大数据情况
	 *   	注：由于可以假设每种输入只有一个对应答案，所以只需要考虑正常答案
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		// 暴力破解法 以下算法时间复杂度 O(n^2) 空间复杂度O(1)
		
		// 边界检查
		if(nums == null || nums.length <= 1) {
			return null;
		}
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target)
					return new int[] {i,j};
			}
		}
		
		return null;
	}
	
	
	public static int[] twoSum2(int[] nums, int target) {
		
		// 采用一个hash表 以下时间复杂度 O(n) 空间复杂度O(n)
		
		// 边界检查
		if(nums == null || nums.length <= 1) {
			return null;
		}
		
		Map<Integer, Integer> hash = new HashMap<>();
		int temp;
		Integer index;
		
		for(int i=0; i<nums.length; i++) {
			temp = target - nums[i];
			if( (index = hash.get(temp)) != null && index != i) {
				return new int[] {index,i};
			}
			hash.put(nums[i], i);
		}
		
		return null;
	}
}
