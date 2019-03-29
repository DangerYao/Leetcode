package com.danger.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并两个区间
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @author Danger
 * @Date 2019年3月29日
 *
 */
public class P56_MergeIntervals {

	public static void main(String[] args) {
		// 测试用例
		// 1. [[1,3],[2,6],[8,10],[15,18]]
		// 2. [[1,4],[4,5]]
		// 3. [[-3,2],[3,5]]
		// 4. []
		// 5. [[-3,2],[-5,6]]
		// 6. [[4,7]]
		// 7. [[1,2],[2,3],[3,4],[4,5]]
		// 8. [[0,0],[0,3],[3,4],[4,5]]
		
		List<Interval> intervals1 = Arrays.asList(
				new Interval(1, 3),
				new Interval(2, 6),
				new Interval(8, 10),
				new Interval(15,18)
				);
		List<Interval> result1 = merge(intervals1);
		
		
		List<Interval> intervals2 = Arrays.asList(
				new Interval(1, 4),
				new Interval(4, 5)
				);
		List<Interval> result2 = merge(intervals2);
		
		
		List<Interval> intervals3 = Arrays.asList(
				new Interval(-3, 2),
				new Interval(3, 5)
				);
		List<Interval> result3 = merge(intervals3);
		
		List<Interval> intervals4 = Arrays.asList();
		List<Interval> result4 = merge(intervals4);
		
		List<Interval> intervals5 = Arrays.asList(
				new Interval(-3, 2),
				new Interval(-5, 6)
				);
		List<Interval> result5 = merge(intervals5);
		
		List<Interval> intervals6 = Arrays.asList(
				new Interval(4, 7)
				);
		List<Interval> result6 = merge(intervals6);
		
		List<Interval> intervals7 = Arrays.asList(
				new Interval(1, 2),
				new Interval(2, 3),
				new Interval(3, 4),
				new Interval(4, 5)
				);
		List<Interval> result7 = merge(intervals7);
		
		List<Interval> intervals8 = Arrays.asList(
				new Interval(),
				new Interval(0, 3),
				new Interval(3, 4),
				new Interval(4, 5)
				);
		List<Interval> result8 = merge(intervals8);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		System.out.println(result7);
		System.out.println(result8);
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		// 算法时间复杂度 O(nlogn) 主要是因为排序
		// 空间复杂度O(n)
		
        List<Interval> result = new LinkedList<>();
        
        if(intervals == null || intervals.isEmpty()) {
        	return result; // 直接返回为空
        }
        
        // 区间进行排序
        // 先暂时认为集合重不会有null值
        Collections.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
        	
        });
        
        Interval temp = null;
        
        for (Interval interval : intervals) {
			// 如果前一个区间的end比后一个区间的start大或者相等，说明有重叠的地方
			if(temp != null && temp.end >= interval.start) {
				// 因为java中对象时引用关系，所以可以直接修改temp
				temp.end = Math.max(temp.end, interval.end);
			} else { // 否则说明没有重叠,直接加入，更新temp
				temp = interval;
				result.add(interval);
			}
		}
		
		return result;
    }

	private static class Interval {
		int start;
		int end;
		
		public Interval() {
			this.start = 0;
			this.end = 0;
		}

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
		
		
	}
}
