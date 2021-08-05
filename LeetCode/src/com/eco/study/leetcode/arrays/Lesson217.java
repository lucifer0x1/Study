package com.eco.study.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lesson217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution217 solution = new Solution217();
        System.out.println(solution.containsDuplicate2(nums));
    }
}

class Solution217{

    /**
     * 利用HashSet 不重复
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        if(set.size() != nums.length){
            return true;
        }
        return false;
    }

    /***
     * 数据遍历方式
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}