package com.eco.study.leetcode.everyday;

/***
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *  
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class Lesson718 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,2,1};
        int[] b = new int[]{3,2,1,4,7};
        Solution solution  =new Solution();
        System.out.println(solution.findLength(a,b));
    }
}

class Solution {

    public int findLength(int[] A, int[] B) {
        int maxOffset  = 0 ;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int offset = 0;
                while(A[i+offset] == B[j+offset]){
                    offset++;
                    if((i+offset) >= A.length || (j+offset) >= B.length){
                        break;
                    }
                }
                maxOffset = Math.max(maxOffset,offset);
                if( B.length -j <= maxOffset){
                    break;
                }
            }
            //剩余剩余不够长 不用判断
            if( A.length -i <= maxOffset) {
                break;
            }
        }
        return  maxOffset;
    }
}