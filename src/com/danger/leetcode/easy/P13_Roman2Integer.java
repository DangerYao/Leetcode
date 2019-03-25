package com.danger.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

示例 1:

输入: "III"
输出: 3
示例 2:

输入: "IV"
输出: 4
示例 3:

输入: "IX"
输出: 9
示例 4:

输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
示例 5:

输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @author Danger
 *
 */
public class P13_Roman2Integer {

	public static void main(String[] args) {
		String s1 = "III";
		String s2 = "IV";
		String s3 = "IX";
		String s4 = "LVIII";
		String s5 = "MCMXCIV";
		
		System.out.println(romanToInt(s1));
		System.out.println(romanToInt(s2));
		System.out.println(romanToInt(s3));
		System.out.println(romanToInt(s4));
		System.out.println(romanToInt(s5));
	}

	static Map<Character,Integer> map = new HashMap<>();
	
	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
	
	/**
	 * 采用map的方式缓存
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		
		int num = 0;
		char[] chars = s.toCharArray();
		int cur=0,next=0; 
		
		for (int i=0; i<chars.length; i++) {
			cur = map.get(chars[i]);
			if(i+1 < chars.length) {
				next = map.get(chars[i+1]);
			}
			if(next > cur) {
				num += next-cur;
				next = 0;
				i++; 
			} else {
				num += cur;
			}
		}
		
		return num;
    }
	/**
	 * 穷举法
	 * @param s
	 * @return
	 */
	public static int romanToInt2(String s) {
		String[] K = new String[] {"","M","MM","MMM"};
		String[] H = new String[] {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] D = new String[] {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] U = new String[] {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		
		int i;
		int num = 0;
		for(i=K.length-1; i >=1; i--) {
			if(s.startsWith(K[i])) {
				num += i*1000;
				s = s.substring(K[i].length());
			}
		}
		
		for(i=H.length-1; i >=1; i--) {
			if(s.startsWith(H[i])) {
				num += i*100;
				s = s.substring(H[i].length());
			}
		}
		
		for(i=D.length-1; i >=1; i--) {
			if(s.startsWith(D[i])) {
				num += i*10;
				s = s.substring(D[i].length());
			}
		}
		
		for(i=U.length-1; i >=1; i--) {
			if(s.startsWith(U[i])) {
				num += i;
				s = s.substring(U[i].length());
			}
		}
		
		return num;
    }
}