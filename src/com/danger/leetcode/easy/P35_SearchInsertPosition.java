package com.danger.leetcode.easy;

/**
 * 搜索插入位置

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
 * @author Danger
 *
 */
public class P35_SearchInsertPosition {

	public static void main(String[] args) {
		/**
		 * 测试用例：
		 * 1. nums 为空时；
		 * 2. target 最小或者最大时
		 * 3. nums 里面有target
		 * 4. nums 里面没有target
		 */
		
		int[] nums1 = new int[] {};
		int target1 = 2;
		
		int[] nums = new int[] {1,3,5,6};
		int target2 = 7;
		int target3 = 5;
		int target4 = 2;
		int target5 = 0;
		
		System.out.println(searchInsert(nums1, target1) == 0);
		System.out.println(searchInsert(nums, target2) == 4);
		System.out.println(searchInsert(nums, target3) == 2);
		System.out.println(searchInsert(nums, target4) == 1);
		System.out.println(searchInsert(nums, target5) == 0);
		
	}
	
	/**
	 *  采用二分查找：如果能查到结果，直接返回，否则返回比target大的第一个数的位置
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
        
		// 边界检查
		if(nums == null || nums.length == 0) {
			return 0; // 直接返回插入第0个位置
		}
		
		int l=0,r=nums.length-1; // 定义二分查找的两个指针
		int mid;	// 定义二分位置
		
		// 两种特殊情况判定, target 最小或者最大时
		if(nums[l] > target) {
			return 0;
		} else if (nums[r] < target) {
			return nums.length;
		}
		
		// 二分查找
		while(l<=r) {
			mid = l + ((r-l) >> 1);
			
			if(nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return l;
    }

}
