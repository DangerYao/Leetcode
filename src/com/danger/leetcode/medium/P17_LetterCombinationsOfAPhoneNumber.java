package com.danger.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码的字母组合

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

2:abc 3:def 4:ghi 5:jkl 6:mno 7:pqrs 8:tuv 9:wxyz

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author Dange
 *
 */
public class P17_LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		
		String s1 = "23";
		String s2 = "2";
		String s3 = "27";
		String s4 = "79";
		String s5 = "232";
		System.out.println(letterCombinations(s1));
		System.out.println(letterCombinations(s2));
		System.out.println(letterCombinations(s3));
		System.out.println(letterCombinations(s4));
		System.out.println(letterCombinations(s5));
		
	}
	
	private static char[][] letters = new char[][] {
		{},					// 0
		{},					// 1
		{'a','b','c'},		// 2
		{'d','e','f'},		// 3
		{'g','h','i'},		// 4
		{'j','k','l'},		// 5
		{'m','n','o'},		// 6
		{'p','q','r','s'},	// 7
		{'t','u','v'},		// 8
		{'w','x','y','z'}	// 9
	};

	public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        //边界检查 由于题目说明仅包含数字2-9的字符串，所以只需检查空
        if(digits == null || digits.isEmpty()) {
        	return result; // 返回空列表
        }
		
        char[] oneResult = new char[digits.length()];
        int count=0;
        
        int[] pos = new int[digits.length()]; // 定义指针
        int pp;	// pos的指针
		char[] chars = digits.toCharArray();
		char[][] temp = new char[digits.length()][];

		int pt = 0 ;
		
		for (int i=0;i<chars.length; i++) {
			temp[i] = letters[chars[i]-'0'];
		}
		
		while (true) {
			pt = 0;
			count = 0;
			for (int j=0;j<pos.length;j++) {
				oneResult[count++] = temp[pt++][pos[j]];
			}
			result.add(new String(oneResult, 0, count));
			pp = pos.length - 1;
			// 定位指针
			while(pt > 0 && pos[pp] == temp[--pt].length-1) {
				pos[pp--] = 0;
			}
			
			if(pp == -1) { // 说明第一位都已经遍历完毕，直接break
				break;
			}
			
			pos[pp]++;
		}
		
        
		return result;
    }
}
