package com.eco.study.leetcode.everyday;

import java.util.List;

/**
 * @author 虫子
 * @date 2020-10-30 19:00:00
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Lession15 {
    public static void main(String[] args) {
        int[] nums = new int []{-1, 0, 1, 2, -1, -4};
        Solution15 solution15 = new Solution15();
        List<List<Integer>> res = solution15.threeSum(nums);
        res.forEach(l->{
            l.forEach(f-> System.out.print(f + ","));
            System.out.println();
        });
    }
}

class Solution15{
    public List<List<Integer>> threeSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

        }
        return null;
    }
}