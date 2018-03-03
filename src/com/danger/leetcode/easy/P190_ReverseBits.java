package com.danger.leetcode.easy;

/**
 * Leetcode Problem 190
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it? 
 * @author DangerYao
 *
 */
public class P190_ReverseBits {

	public static void main(String[] args) {
		
		System.out.println(reverseBits(-2147483648));
	}

//	public static int reverseBits(int n) {
//		int result = 0; // 存储结果
//        int[] temp = new int[32]; //存储bit
//        // 初始化0
//        for (int i=0; i< temp.length; i++) {
//			temp[i] = 0; 
//		}
//        // 对2取余 存入数组
//        for (int i=0; n>0;i++) {
//        	temp[i] = n%2;
//        	n = n/2;
//        }
//        // 将数组
//        for (int i=0;i< temp.length; i++) {
//        	result += temp[i] * Math.pow(2, (temp.length - i -1));
//        }
//		return result ;
//    }
	
	public static int reverseBits(int n) {
		int result = 0; // 存储结果
        for (int i=0; i < 31;i++) {
        	result += n & 1; // 获取最后一位BIT
        	n >>>= 1;		 // n 左移一位
        	result <<= 1;	 // result 右移一位
        }
        result += n & 1;
		return result ;
    }
}
