package com.eco.study.leetcode.bitmanipulation;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 *
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 *
 * 示例 3:
 *
 * 输入: 218
 * 输出: false

 */
public class Lesson231 {
    public static void main(String[] args) {
        int n = -15;
        Solution231 solution = new Solution231();
        System.out.println(solution.isPowerOfTwo(n));
    }
}

class Solution231 {
    public boolean isPowerOfTwo(int n){
        boolean flag = false;
        if(n<0){
            return flag;
        }
        do{
            if((n & 1) == 1){
                flag = true;
            }
            n = n >>1;
            if(flag){
                break;
            }
        }while  (n>0);
        return flag && (n<=0);
    }
}