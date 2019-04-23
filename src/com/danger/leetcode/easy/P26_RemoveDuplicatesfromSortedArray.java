package com.danger.leetcode.easy;

/**

给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2], 

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。
说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 * @author Danger
 *
 */
public class P26_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// 测试
		// 1 . 为空时
		// 2 .  数据一样时
		// 3 . 有多个重复数据时
		// 4 . 正常数据
		
		int[] nums1 = new int[] {2,2,3,3};
		int result1 = removeDuplicates(nums1);
		System.out.println("1 len:" + result1);
		for(int i=0; i<result1;i++) {
			System.out.print(nums1[i] + " ");
		}
		
		System.out.println();
		
		int[] nums2 = new int[] {0,0,1,2,2,3,3,4};
		int result2 = removeDuplicates(nums2);
		
		System.out.println("2 len:" + result2);
		for(int i=0; i<result2;i++) {
			System.out.print(nums2[i] + " ");
		}
		System.out.println();
		int[] nums3 = new int[] {3,3,3,3,3,3};
		int result3 = removeDuplicates(nums3);
		System.out.println("3 len:" + result3);
		for(int i=0; i<result3;i++) {
			System.out.print(nums3[i] + " ");
		}
	}

	/**
	 * 思路：采用双指针，从前向后扫描
	 * 1.初始化pre,next=0;
	 * 2.移动后指针next向后扫描，判断next值和pre值是否相等，相等直接移动next,否则pre+1，将值赋给pre,移动next
	 * 3.重复2，直到next>len,返回pre+1
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
        
		// 边界检查
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int pre=0, next=0; // 定义双指针
		
		while(next < nums.length) {
			if(nums[pre] == nums[next]) {
				next++;
				continue;
			}
			pre++;
			nums[pre] = nums[next];
			next++;
		}
		
		return pre+1;
    }
	
}
