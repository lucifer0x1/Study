package com.eco.study.leetcode.everyday;


import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Lesson1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        Solution1 solution = new Solution1();
        for (int i : solution.twoSum(nums, 6)) {
            System.out.println(i);
        }
    }
}

class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[nums.length+1];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if((nums[i] + nums[j])==target){
                    res[len] = i;
                    res[len+1] = j;
                    len = len+2;
                }
            }
        }
        return Arrays.copyOf(res,len);
    }
}
