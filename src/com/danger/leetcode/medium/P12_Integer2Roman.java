package com.danger.leetcode.medium;

/**
 * 整数转为罗马数字
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

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
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例 1:

输入: 3
输出: "III"
示例 2:

输入: 4
输出: "IV"
示例 3:

输入: 9
输出: "IX"
示例 4:

输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:

输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @author Dange
 *
 */
public class P12_Integer2Roman {

	public static void main(String[] args) {
		int num1 = 3;
		int num2 = 4;
		int num3 = 9;
		int num4 = 58;
		int num5 = 1994;
		int num6 = 999;
		int num7 = 3999;
		
		System.out.println(intToRoman(num1));
		System.out.println(intToRoman(num2));
		System.out.println(intToRoman(num3));
		System.out.println(intToRoman(num4));
		System.out.println(intToRoman(num5));
		System.out.println(intToRoman(num6));
		System.out.println(intToRoman(num7));
	}
	
	/**
	 * 穷举法
	 * K : M(1000) MM(2000) MMM(3000)
	 * H : C(100) CC(200) CCC(300) CD(400) D(500) DC(600) DCC(700) DCCC(800) CM(900)
	 * D : X(10) XX(20) XXX(30) XL(40) L(50) LX(60) LXX(70) LXXX(80) XC(90)
	 * U : I(1) II(2) III(3) IV(4) V(5) VI(6) VII(7) VIII(8) IX(9)
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num) {
        
		// 不用做边界处理，题目表示确保数据 0 < num < 4000
		
		String[] K = new String[] {"","M","MM","MMM"};
		String[] H = new String[] {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] D = new String[] {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] U = new String[] {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		
		return K[num/1000] + H[(num%1000)/100] + D[(num%100)/10] + U[(num%10)];
    }

	/**
	 * 思路
	 * 将数据分成  
	 *  num<4 
	 *  num=4 
	 *  4<num<9
	 *  num=9
	 *  10<num<40
	 *  num=40
	 *  40<num<90
	 *  num=90
	 *  90<num<400
	 *  num=400
	 *  400<num<900
	 *  num=900
	 *  num>900
	 *  进行处理，从大到小处理，处理了就减去替换的值，替换的罗马字符用StringBuilder进行拼接
	 * @param num
	 * @return
	 */
	public static String intToRoman2(int num) {
        
		// 不用做边界处理，题目表示确保数据 0 < num < 4000
		String[] roman = new String[] {"I","V","X","L","C","D","M"};
		StringBuilder sb = new StringBuilder();
		
		while(num>=1000) {
			sb.append(roman[6]);
			num -= 1000;
		}
		
		if(num>=900) {
			sb.append(roman[4]).append(roman[6]);
			num -= 900;
		}
		
		if(num >= 500) {
			sb.append(roman[5]);
			num -= 500;
		}
		
		if(num >= 400) {
			sb.append(roman[4]).append(roman[5]);
			num -= 400;
		}
		
		while(num>=100) {
			sb.append(roman[4]);
			num -= 100;
		}
		
		if(num>=90) {
			sb.append(roman[2]).append(roman[4]);
			num -= 90;
		}
		
		if(num >= 50) {
			sb.append(roman[3]);
			num -= 50;
		}
		
		if(num >= 40) {
			sb.append(roman[2]).append(roman[3]);
			num -= 40;
		}
		
		while(num>=10) {
			sb.append(roman[2]);
			num -= 10;
		}
		
		if(num>=9) {
			sb.append(roman[0]).append(roman[2]);
			num -= 9;
		}
		
		if(num >= 5) {
			sb.append(roman[1]);
			num -= 5;
		}
		
		if(num >= 4) {
			sb.append(roman[0]).append(roman[1]);
			num -= 4;
		}
		
		while(num>=1) {
			sb.append(roman[0]);
			num -= 1;
		}
		
		return sb.toString();
    }
	
}
