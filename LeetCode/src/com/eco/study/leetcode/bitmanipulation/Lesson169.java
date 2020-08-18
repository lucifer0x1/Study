package com.eco.study.leetcode.bitmanipulation;


import java.util.HashMap;
import java.util.Map;

/**
 *给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */
public class Lesson169 {

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,3};
        Solution169 solution = new Solution169();
        System.out.println(solution.majorityElement(nums));
    }
}

class Solution169 {

    public int majorityElement(int[] nums){
        int res = 0;
        int n = nums.length/2;
        Map<Integer,Integer> result = new HashMap<>();
        for (int num : nums) {
            result.put(num,result.getOrDefault(num,0) + 1);
            if(result.getOrDefault(num,0) > n) {
                res = num;
                return  res;
            }
        }
        return res;
    }
}
