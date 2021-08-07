package com.eco.study.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Lesson15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution15 solution = new Solution15();
        List<List<Integer>> res = solution.threeSum(nums);
        res.forEach(l -> System.out.println(l.get(0) + "|" + l.get(1) + "|" + l.get(2)));
    }
}

class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = null;
        for(int first= 0 ;first < nums.length  ; ++first){
            if(first> 0 && nums[first] == nums[first-1] ) {
                continue;
            }
            int third = nums.length-1;
            int target = -nums[first];
            for(int second = first+1 ;second < nums.length ; ++second){
                // 需要和上次美剧的数子不相同
                if(second>first && nums[second] == nums[second-1] ) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while ((second < third) && ((nums[second] + nums[third]) > target)) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if(second == third) {
                    break;
                }
                if(nums[second] + nums[third] == target){
                    tmp = new ArrayList<Integer>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    res.add(tmp);
                }
            }
        }

        return res;
    }
}
