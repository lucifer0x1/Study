package com.eco.study.leetcode.everyday;


/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 *
 */
public class Lesson378 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1,  2},
                {1, 3},
        };
         matrix = new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        Solution378 solution  = new Solution378();
        System.out.println(solution.kthSmallest(matrix,2));
    }

}

class Solution378 {

    public int kthSmallest(int[][] matrix, int k) {
        if(k == matrix.length * matrix.length){
            return matrix[k-1][k-1];
        }
        if(k == 1){
            return matrix[0][0];
        }
        int st =(int) Math.sqrt(k);
        int ed = st+1;
        int step = ed*ed - k;

        int left = 0;
        int right = 0;

        int max = matrix[st][st];
        for (int i = 0; i < step; i++) {
            left = matrix[st][st - i ];
            right = matrix[st - i][st ];
            if(left > right){
                max = Math.min(left,max);
            }else{
                max = Math.min(right,max);
            }
        }
        return max;
    }
}
