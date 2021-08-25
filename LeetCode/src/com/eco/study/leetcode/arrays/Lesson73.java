package com.eco.study.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName Lesson73
 * Description
 * Date 2021/8/25
 * Author wangxiyue.xy@163.com
 *
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * 通过次数125,061提交次数208,125
 */
public class Lesson73 {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Solution73 solution = new Solution73();

        printMatrix(matrix);
        solution.setZeroes(matrix);
        System.out.println();
        printMatrix(matrix);


    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t ,");
            }
            System.out.println();
        }
    }
}

class Solution73 {

    public void setZeroes(int[][] matrix){
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> row = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    col.add(j);
                    row.add(i);
                }
            }
        }

        for (Integer c : col) {
            colZero(matrix,c);
        }
        for (Integer r : row){
            rowZero(matrix,r);
        }

    }

    private void colZero(int[][] m , int col){
        for (int i = 0; i < m.length; i++) {
            m[i][col] = 0;
        }
    }

    private void rowZero(int[][] m, int row){
        for (int i = 0; i < m[row].length; i++) {
            m[row][i] = 0;
        }
    }
}
