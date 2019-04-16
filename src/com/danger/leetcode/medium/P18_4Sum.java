package com.danger.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danger
 *
 */
public class P18_4Sum {

	public static void main(String[] args) {

		// 测试用例
		// 1. null
		// 2.  长度小于4的数组
		// 3.  正常数组
		// 4.  同一数据数组
		int[] nums1 = new int[]{1, 0, -1, 0, -2, 2};
		int target1 = 0;
		List<List<Integer>> fourSum1 = fourSum(nums1, target1);
		for (List<Integer> list : fourSum1) {
			System.out.println(list);
		}
		
	}
	
	/**
	 *  解决思路
	 *  1 对数组进行排序
	 *  2
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        
		// 边界处理
		if(nums == null & nums.length < 4) {
			return new ArrayList<>();
		}
		
		List<List<Integer>> result = new ArrayList<>();
		
		
		return result;
    }

}
