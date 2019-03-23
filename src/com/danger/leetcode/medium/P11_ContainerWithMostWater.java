package com.danger.leetcode.medium;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49
 * @author Danger
 *
 */
public class P11_ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height1 = new int[]{1,8,6,2,5,4,8,3,7};
		
		int[] height2 = new int[]{1,1,1,1,1,1};
		
		System.out.println(maxArea(height1));
		System.out.println(maxArea(height2));
	}

	/**
	 * 思路：
	 * 1、采用两个指针分别指向数组的左和右
	 * 2、取两个height小值和距离求取面积,缓存最大面积
	 * 3、移动值小的指针,重复2，直到两个指针指向相同位置时
	 * 4、返回缓存的最大面积
	 * 
	 * 解释：参考https://leetcode.com/problems/container-with-most-water/discuss/6099/yet-another-way-to-see-what-happens-in-the-on-algorithm
	 * 比如我们有一个长度为6的数组,由于我们左指针从下标最小开始，比如竖排1~6从上到下,右指针从下标最大大开始，比如横排6~1从右到左
	 * 做个假设比如a[1] < a[6], 那么我们计算a[1]*(6-1)是a[1]*(i-1) 1<i<6 中值最大的,所以就不用计算这些值，用-表示,我们就可以吧左指针移动一位到2
	 * 如果a[2] > a[6], 同理a[2]*(6-2)是(i-2)*a[6] 2<i<6 中最大的,所以就不用计算这些值,用|表示,我们就可以吧右指针移动一位到5
	 * 后面同理
	 *   1 2 3 4 5 6
	 * 1 X - - - - o
	 * 2 X X       o
	 * 3 X X X     |
	 * 4 X X X X   |
	 * 5 X X X X X |
	 * 6 X X X X X X
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		
		// 时间复杂度O(n) 空间复杂度O(1)
		
		if(height == null || height.length < 2) {
			return 0;
		}
		
		int maxArea = 0;
		int area;
		int minNum;
		int i=0,j=height.length-1;
		while(i<j) {
			minNum = Math.min(height[i], height[j]);
			area = minNum * (j-i);
			if(maxArea < area) {
				maxArea = area;
			}
			if(height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}		
		return maxArea;
	}
	
	/**
	 * 暴力破解法
	 * 直接遍历,去两个中的最小值*两个数之间的距离算出面积
	 * 缓存最大面积
	 * @param height
	 * @return
	 */
	public static int maxArea2(int[] height) {
		
		// 暴力破解法 直接遍历 一下时间复杂度O(n^2) 空间复杂度O(1)
		
		if(height == null || height.length < 2) {
			return 0;
		}
		
		int maxArea = 0;
		int area;
		int minNum;
		for(int i=1;i<height.length;i++) {
			for(int j=0; j<i; j++) {
				minNum = Math.min(height[j], height[i]);
				area = minNum * (i-j);
				if(maxArea < area) {
					maxArea = area;
				}
			}
		}
		
		return maxArea;
	}
}
