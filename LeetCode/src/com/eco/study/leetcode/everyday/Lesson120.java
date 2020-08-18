package com.eco.study.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
// TODO 这道题不会做
public class Lesson120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> t = new ArrayList();
        t.add(2);
        triangle.add(t);
        t = new ArrayList();
        t.add(3);t.add(4);
        triangle.add(t);
        t = new ArrayList();
        t.add(6); t.add(5); t.add(7);
        triangle.add(t);
        t = new ArrayList();
        t.add(4);   t.add(1);   t.add(8);   t.add(3);
        triangle.add(t);
        System.out.println(new Solution120().minimumTotal(triangle));
    }
}

class Solution120 {

    /**
     1* [2]
     2* [3,4]
     3* [6,5,7]
     4* [4,1,8,3]
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        return 0;
    }

}
