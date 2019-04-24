package com.danger.leetcode.easy;

/**
 * 实现strStr()
 * 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @author Danger
 *
 */
public class P28_ImplementstrStr {

	public static void main(String[] args) {
		/**
		 * 测试用例
		 * 1. 正常串如：hello ll  -> expect 2
		 * 2. needle为空  -> expect 0
		 * 3. haystack为空 -> expect -1
		 * 4. 具有两个子串，如：hellollo ll -> expect 2
		 * 5. 没有相等的串: hello abc -> expect -1
		 * 6. 完全相等串： hello hello -> expect 0
		 * 7. hello lo -> expect 3
		 * 8. hello loo -> expect -1
		 * 9. aaa aaaa -> expect -1
		 */
		String haysyack1 = "hello";
		String needle1 = "ll";
		
		System.out.println(strStr(haysyack1, needle1));
		
		String haysyack2 = "hello";
		String needle2 = "";
		
		System.out.println(strStr(haysyack2, needle2));
		
		
		String haysyack3 = "";
		String needle3 = "ll";
		
		System.out.println(strStr(haysyack3, needle3));
		
		
		String haysyack4 = "hellollo";
		String needle4 = "ll";
		
		System.out.println(strStr(haysyack4, needle4));
		
		String haysyack5 = "hello";
		String needle5 = "abc";
		
		System.out.println(strStr(haysyack5, needle5));	
		
		String haysyack6 = "hello";
		String needle6 = "hello";
		
		System.out.println(strStr(haysyack6, needle6));	
		
		String haysyack7 = "hello";
		String needle7 = "lo";
		
		System.out.println(strStr(haysyack7, needle7));
		
		String haysyack8 = "hello";
		String needle8 = "loo";
		
		System.out.println(strStr(haysyack8, needle8));
		
		String haysyack9 = "aaa";
		String needle9 = "aaaa";
		
		System.out.println(strStr(haysyack9, needle9));
		
	}
	
	/**
	 * 思路：暴力匹配算法，采用双指针，第一个指针寻找首字母相等的位置，第二个指针匹配字符串
	 * 还有一种快速匹配算法KMP，后续补充
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
        
		// 边界检查
		if(needle == null || needle.isEmpty()) {
			return 0;
		}
		
		if(haystack == null || haystack.isEmpty()) {
			return -1;
		}
		
		int p1=0, p2=0; // 定义双指针
		
		char[] haystackArr = haystack.toCharArray();
		char[] needleArr = needle.toCharArray();
		
		while(p1 < haystackArr.length) {
			if(haystackArr[p1] == needleArr[0]) {
				do {
					p2++;
				} while (p2 < needleArr.length && p1+p2 < haystackArr.length && haystackArr[p1+p2] == needleArr[p2]);
				// 如果扫描完了needleArr 说明是该子串
				if(p2 == needleArr.length) {
					return p1;
				} else { // 否则重新归0
					p2 = 0;
				}
			}
			p1++;
		}
		
		return -1;
    }

}
