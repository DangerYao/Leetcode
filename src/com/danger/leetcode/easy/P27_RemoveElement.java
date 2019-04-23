package com.danger.leetcode.easy;

/**
 * 移除元素

给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,1,2,2,3,0,4,2], val = 2,

函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

注意这五个元素可为任意顺序。

你不需要考虑数组中超出新长度后面的元素。
说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 * @author Danger
 *
 */
public class P27_RemoveElement {

	public static void main(String[] args) {
		// 测试
		// 1 . 为空时
		// 2 .  数据一样时，都需要移除时
		// 3 .  头尾需要移除时
		// 4 . 正常数据
		
		int[] nums1 = new int[] {3,2,2,3};
		int result1 = removeElement(nums1, 3);
		System.out.println("1 len:" + result1);
		for(int i=0; i<result1;i++) {
			System.out.print(nums1[i] + " ");
		}
		
		System.out.println();
		
		int[] nums2 = new int[] {0,1,2,2,3,0,4,2};
		int result2 = removeElement(nums2, 2);
		
		System.out.println("2 len:" + result2);
		for(int i=0; i<result2;i++) {
			System.out.print(nums2[i] + " ");
		}
		System.out.println();
		int[] nums3 = new int[] {3,3,3,3,3,3};
		int result3 = removeElement(nums3, 3);
		System.out.println("3 len:" + result3);
		for(int i=0; i<result3;i++) {
			System.out.print(nums3[i] + " ");
		}
	}

	/**
	 *  思路：采用双指针pre,next，从后向前扫描
	 *  1. 先移动next排除尾部与val相等的元素
	 *  2. 移动pre从后向前扫描，当扫描到val相等的时候，交换pre和next的值(也可以直接将后面的值赋给前面)，pre和next都向前一步
	 *  3.循环2，直到pre到头为止，返回next+1(因为返回的是长度，next是最后一个元素)
	 *  
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		
		// 边界检查
		if(nums == null || nums.length == 0) {
			return 0;
		}
        int pre,next=nums.length-1; // 定义前后指针
        
        // 排除后面等于val的数据
        while(next >= 0 && nums[next] == val) {
        	next--;
        }
        
        pre = next-1;
        
        // 将后面的值付给前指针
        while(pre >= 0) {
        	if(nums[pre] == val) {
        		nums[pre] = nums[next];
        		next--;
        	}
        	pre--;
        }
		
		return next+1;
    }
}
