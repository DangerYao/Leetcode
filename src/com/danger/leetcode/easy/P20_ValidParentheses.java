package com.danger.leetcode.easy;

import java.util.Stack;

/**
 * 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 * @author Danger
 * @Date 2019年4月3日
 *
 */
public class P20_ValidParentheses {

	public static void main(String[] args) {
		String s1 = "()";
		String s2 = "()[]{}";
		String s3 = "(]";
		String s4 = "([)]";
		String s5 = "{[]}";
		String s6 = "";
		String s7 = null;
		
		assert isValid(s1) == true : "s1 expect true";
		assert isValid(s2) == true : "s2 expect true";
		assert isValid(s3) == false : "s3 expect false";
		assert isValid(s4) == false : "s4 expect false";
		assert isValid(s5) == true : "s5 expect true";
		assert isValid(s6) == true : "s6 expect true";
		assert isValid(s7) == true : "s7 expect true";
		
	}
	
	public static boolean isValid(String s) {
        
		// 边界检查
		if(s == null || s.isEmpty()) {
			return true;
		}
		// 使用栈
		Stack<Character> stack = new Stack<>(); 
		
		char[] chars = s.toCharArray();
		
		for (char c : chars) {
			
			switch (c) {
			case '(':
			case '[':
			case '{':
				stack.push(c);
				break;
			case ')':
				if(stack.empty() || stack.peek() != '(') {
					return false;
				};
				stack.pop();
				break;
				
			case ']':
				if(stack.empty() || stack.peek() != '[') {
					return false;
				};
				stack.pop();
				break;
			case '}':
				if(stack.empty() || stack.peek() != '{') {
					return false;
				};
				stack.pop();
				break;
			default:
				return false;
			}
		}
		
		if(stack.empty()) {
			return true;
		}
		
		return false;
    }

}
