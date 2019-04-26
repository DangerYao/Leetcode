package com.danger.leetcode.easy;

/**
 * 最后一个单词的长度
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:

输入: "Hello World"
输出: 5
 * @author Danger
 *
 */
public class P58_LengthofLastWord {

	public static void main(String[] args) {
		/**
		 * 测试用例：
		 * 1. 空串
		 * 2. 最后有空格
		 * 3. 正常字符串
		 * 4. 有其他字符的字符串
		 */
		String s1 = "";
		String s2 = "a ";
		String s3 = "hello world";
		String s4 = "hello w2ord";
		
		System.out.println("s1 expect 0: " + lengthOfLastWord(s1));
		System.out.println("s2 expect 1: " + lengthOfLastWord(s2));
		System.out.println("s3 expect 5: " + lengthOfLastWord(s3));
		System.out.println("s4 expect 3: " + lengthOfLastWord(s4));
	}

	/**
	 * 思路：去掉后面的空格后，从后向前进行判定，字符在A-Z a-z的count进行+1
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLastWord(String s) {
        
		// 边界检查
		if(s == null || s.trim().isEmpty()) {
			return 0;
		}
		// 如果想要更严格的做算法题，可以自己处理后面得空格，不使用字符串的trim方法
		char[] chs = s.trim().toCharArray();
		int count = 0;
		int p = chs.length-1;
		
		while(p>=0 && ((chs[p] >= 'A' && chs[p] <= 'Z') || (chs[p] >= 'a' && chs[p] <= 'z'))) {
			count++;
			p--;
		}
		
		return count;
    }
}
