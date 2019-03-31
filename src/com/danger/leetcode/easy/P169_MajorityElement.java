package com.danger.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
 * @author Danger
 * @Date 2019年3月30日
 *
 */
public class P169_MajorityElement {

	public static void main(String[] args) {
		int[] nums1 = new int[] {3,2,3};
		int[] nums2 = new int[] {2,2,1,1,1,2,2};
		int[] nums3 = new int[] {5};
		int[] nums4 = new int[] {3,2,4,5,6,4,2,4,4,1,2,4,4,1,4,4,4,1,4,3,4};
		
		System.out.println(majorityElement(nums1));
		System.out.println(majorityElement(nums2));
		System.out.println(majorityElement(nums3));
		System.out.println(majorityElement(nums4));
	}
	
	public static int majorityElement(int[] nums) {
        
		// 时间复杂度O(n), 空间复杂度 O(1)
		
		// 你可以假设数组是非空的，并且给定的数组总是存在众数
		int result = nums[0];
		int count = 0;
		
		for(int i=0;i<nums.length;i++) {
			if(count == 0) {
				result = nums[i];
				count++;
				continue;
			}
			// 因为众数肯定是里面数据最多的,相同count+1,不同-1,最后能count>0的只有众数
			if(result == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		
		return result;
    }
	
	public static int majorityElement2(int[] nums) {
        
		// 时间复杂度O(n), 空间复杂度 O(n)
		
		// 你可以假设数组是非空的，并且给定的数组总是存在众数
		int result = nums[0];
		Integer count;
		int temp = nums.length / 2;
		Map<Integer, Integer> counter = new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			count = counter.get(nums[i]);
			if(count == null) {
				counter.put(nums[i], 1);
			} else {
				count++;
				if(count > temp) {
					result = nums[i];
					break;
				}
				counter.put(nums[i], count); // Integer是不可变的 所以需要重新设值
			}
			
		}
		
		return result;
    }
}
