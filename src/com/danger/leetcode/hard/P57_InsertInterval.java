/**
 * 
 */
package com.danger.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]
示例 2:

输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * @author Danger
 * @Date 2019年3月29日
 *
 */
public class P57_InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		List<Interval> intervals1 = new ArrayList<>();
		intervals1.add(new Interval(1, 3));		
		intervals1.add(new Interval(6, 9));
		List<Interval> result1 = insert(intervals1,new Interval(2, 5));
		
		List<Interval> intervals2 = new ArrayList<>();
		intervals2.add(new Interval(1, 2));
		intervals2.add(new Interval(3, 5));
		intervals2.add(new Interval(6, 7));
		intervals2.add(new Interval(8, 10));
		intervals2.add(new Interval(12,16));
		List<Interval> result2 = insert(intervals2,new Interval(4, 8));
		
		List<Interval> intervals3 = new ArrayList<>();
		intervals3.add(new Interval(1, 3));		
		intervals3.add(new Interval(6, 9));
		List<Interval> result3 = insert(intervals3,new Interval(0, 0));
		
		List<Interval> intervals4 = new ArrayList<>();
		intervals4.add(new Interval(0, 3));		
		intervals4.add(new Interval(6, 9));
		List<Interval> result4 = insert(intervals4,new Interval(-1, 0));
		
		List<Interval> intervals5 = new ArrayList<>();
		intervals5.add(new Interval(0, 5));		
		intervals5.add(new Interval(9, 12));
		List<Interval> result5 = insert(intervals5,new Interval(7, 16));
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
		// 边界处理
		if(newInterval == null) {
			return intervals;
		}
		if(intervals == null || intervals.isEmpty()) {
			return Arrays.asList(newInterval);
		}
		
		List<Interval> result = new LinkedList<>();
		
		boolean isInsert = false;
		
		for (Interval interval : intervals) {
			
			if(interval.end < newInterval.start) { //整个区间都比newInterval小,直接添加
				result.add(interval);
			} else if(interval.start <= newInterval.end) {
				// 有重叠部分，进行处理
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
			} else { //整个区间都比newInterval大,直接添加
				if(!isInsert) {
					result.add(newInterval);
					isInsert = true;
				}
				result.add(interval);
			}
        }
		
		// 最后有可能都没有加上
		if(!isInsert) {
			result.add(newInterval);
		}
		
        return result;
    }
	
	public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        
		// 边界处理
		if(newInterval == null) {
			return intervals;
		}
		if(intervals == null || intervals.isEmpty()) {
			return Arrays.asList(newInterval);
		}
		
		Interval temp = null;
				 
		// 二分查找 定位newInterval应该插入的位置
		// 先不区分列表底层使用的是数组还是链表
		int l=0, r=intervals.size()-1; // 左右两个指针
		int mid = 0;
		while(l<=r) {
			mid = l + ((r-l) >> 2);
			temp = intervals.get(mid);
			if(temp.start < newInterval.start) {
				if(mid + 1 != intervals.size() && intervals.get(mid+1).start > newInterval.start) {
					break;
				}
				l = mid + 1;
			} else if (temp.start > newInterval.start) {
				r = mid - 1;
			} else {
				break;
			}
		}
		
		// 插入
		if(r < 0) { // 说明新插入的值应该在第一个位置
			intervals.add(0, newInterval);
			temp = newInterval;
		} else {
			intervals.add(mid+1, newInterval);			
		}
		Interval interval;
		// 处理重叠的部分
		int p = mid + 1; // 定义一个指针
		while(p < intervals.size()) {
			// 一下为什么没有对p进行处理,是因为移除了一个, p就是指向的下一个
			interval = intervals.get(p);
			if(temp.end > interval.end) {
				intervals.remove(p);
			} else if (temp.end >= interval.start) {
				temp.end = Math.max(temp.end, interval.end);
				intervals.remove(p);
			} else {
				if(temp != newInterval) {
					temp = newInterval;	
					p = mid + 2;
				} else {
					break;
				}
			}
		}
		
		
		return intervals;
    }
	
	@SuppressWarnings("unused")
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
