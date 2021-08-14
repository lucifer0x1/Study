package com.eco.study.leetcode.arrays;

import java.util.Arrays;

/**
 * @author 虫子
 * @date 2021-08-14 23:44:00
 * 566. 重塑矩阵
 *
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 *
 * 示例 2：
 *
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 */
public class Lession566 {

    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        int r = 2;
        int c = 4;
        Solution566 solution = new Solution566();
        int[][] res = solution.matrixReshape(mat,r,c);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + ",");
            }
            System.out.println();
        }

    }
}

class Solution566 {

    public int[][] matrixReshape(int[][] mat , int r , int c){
        if((mat.length * mat[0].length) != (r * c)){
            return mat;
        }
        int[][] res = new int[r][c];
        int i = 0;
        int j = 0;
        for (int[] ints : mat) {
            for (int anInt : ints) {
                res[i][j] = anInt;
                j++;
                if(j==c){
                    j=0;
                    i++;
                    if(i==r){
                        return res;
                    }
                }
            }
        }
        return res;
    }
}