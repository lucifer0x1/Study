package com.eco.study.leetcode.bitmanipulation;


/***
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1:
 *
 * 输入: [5,7]
 * 输出: 4
 *
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 *
 */
public class Lesson201 {
    public static void main(String[] args) {
        Solution201 solution = new Solution201();
        int m = 2147481;
        int n=2147483;
        System.out.println("二进制:" + Integer.toBinaryString(solution.rangeBitwiseAnd(m,n)));
        System.out.println("十进制：" +solution.rangeBitwiseAnd(m,n));
    }
}

class Solution201 {
    public int rangeBitwiseAnd(int m,int n ){
        /***
         * 小范围可以直接循环
         */
//        for(int i = m;i<=n;i++){
//            m  = m & i ;
//        }
        /**
         * 注意　此题　是　0 ~ 2147483647 (整数最大)
         * 顺序循环　求　与　运算　其实就是求　两个数的公共　１　的部分
         */
        int count= 0;
        while(m<n){
            m=m>>>1;
            n=n>>>1;
            count++;
        }
        return m<<count;
    }
}
