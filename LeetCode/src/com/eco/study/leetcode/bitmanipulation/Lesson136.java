package com.eco.study.leetcode.bitmanipulation;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Lesson136 {
    /**
     *
     * 异或运算
     *
     * 变量交换
     * a = a ^ b;
     * b = b ^ a;
     * a = a ^ b;
     *
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        Solution136 solution = new Solution136();
        System.out.println(solution.singleNumber(nums));
    }
}


class Solution136 {
    public int singleNumber(int[] nums){
        int res = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}