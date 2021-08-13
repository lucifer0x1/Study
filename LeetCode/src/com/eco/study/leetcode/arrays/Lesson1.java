package com.eco.study.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName Lesson1
 * Description
 * Date 2021/8/7
 * Author wangxiyue.xy@163.com
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 */
public class Lesson1 {

    public static void main(String[] args) {
        int[] nums = {3,3} ;
        int target = 6;
        Solution1 solution = new Solution1();
        for (int i : solution.towSum(nums, target)) {
            System.out.println(i);
        }
    }

}

class Solution1 {

    public int[] towSum(int[] nums , int target){
        int a , b;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        /***
         *  放到判断循环中 迭代加入， 循环从数组开始，
         *  每次判断数组前的数据是否满足target条件。
         */
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && (i !=map.get(target-nums[i]))){
                a = i;
                b = map.get(target - nums[i]);
                return new int[]{a, b};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}