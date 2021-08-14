package com.eco.study.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 虫子
 * @date 2021-08-15 00:24:00
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 提示:
 *
 *     1 <= numRows <= 30
 */
public class Lesson118 {

    public static void main(String[] args) {
        int numRows = 5;
        Solution118 solution = new Solution118();
        List<List<Integer>> res = solution.generate(numRows);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }
}

class Solution118 {

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> last = new ArrayList<Integer>();
        last.add(1);
        res.add(last);
        for (int i = 2; i <= numRows; i++) {
            last = reRow(last);
            res.add(last);
        }
        return res;
    }

    /**
     *  每次计算当前所在行的数值
     * @param last
     * @return
     */
    private List<Integer> reRow(List<Integer> last){
        List nowList = new ArrayList<Integer>();
        nowList.add(last.get(0));
        for (int i = 0; i < last.size()-1; i++) {
            nowList.add(last.get(i) + last.get(i+1));
        }
        nowList.add(last.get(last.size()-1));
        return nowList;
    }
}