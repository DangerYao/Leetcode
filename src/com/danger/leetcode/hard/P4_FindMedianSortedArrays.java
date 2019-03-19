package com.danger.leetcode.hard;

/**
 * 	寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 * @author Danger
 *
 */
public class P4_FindMedianSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = new int[] {1,3};
		int[] nums2 = new int[] {2};
		
		assert findMedianSortedArrays(nums1, nums2) == 2.0 : "expect 2.0";
		
		int[] nums3 = new int[] {1,2};
		int[] nums4 = new int[] {3,4};
		
		assert findMedianSortedArrays(nums3, nums4) == 2.5 : "expect 2.5";
		
		int[] nums5 = new int[] {1,2};
		int[] nums6 = new int[] {};
		
		assert findMedianSortedArrays(nums5, nums6) == 1.5 : "expect 1.5";
		
		int[] nums7 = new int[] {};
		int[] nums8 = new int[] {3,5,6};
		
		assert findMedianSortedArrays(nums7, nums8) == 5.0 : "expect 5.0";
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		// 时间复杂度 O(log(n+m)) 空间复杂度 O(1)
		
		int length1 = nums1 == null ? 0 : nums1.length;
		int length2 = nums2 == null ? 0 : nums2.length;
		
		if(length1 > length2) {
			// 保证前面的数组长度比后面数组长度小
			return findMedianSortedArrays(nums2, nums1);
		}
		
		int l1=0,r1=0,l2=0,r2=0;	// 定义分割的数组1、2的左右位置的值
		int c1,c2,p = 0;		// 定义分割数组1、2的位置
		int iLength = length1 * 2;	// 模拟扩大一倍, 让数组恒为奇数
		
		while (p <= iLength) {
			
			c1 = (p + iLength) / 2;	// 二分
			c2 = length1 + length2 - c1;
			
			l1 = c1 == 0 ? Integer.MIN_VALUE : nums1[(c1-1)/2];
			r1 = c1 == length1*2 ? Integer.MAX_VALUE : nums1[c1/2];
			l2 = c2 == 0 ? Integer.MIN_VALUE : nums2[(c2-1)/2];
			r2 = c2 == length2*2 ? Integer.MAX_VALUE : nums2[c2/2];
			
			if( l1 > r2) {
				iLength = c1 - 1;	// 向左二分
			} else if (l2 > r1){
				p = c1 + 1;			// 向右二分
			} else {
				break;				// 结束循环
			}
		}
		
		return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
    }

}
