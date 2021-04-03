package com.eco.study.leetcode.sort;


/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 */
public class Lesson179 {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};

        Solution179 solution = new Solution179();
        String res = solution.largestNumber(nums);
        System.out.println(res);
    }
}

class  Solution179{

    public String largestNumber(int[] nums){
        int tmp = 0;
        for (int i1 = 0; i1 <nums.length-1; i1++) {
            for (int i2 = 0; i2 <nums.length-1-i1; i2++) {
                if(cmp(nums[i2],nums[i2+1])){
                    tmp = nums[i2];
                    nums[i2] = nums[i2+1];
                    nums[i2+1] = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        if(nums[0]==0){
            return "0";
        }
        return sb.toString();
    }

    private boolean cmp(int a , int b){
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        if(Long.valueOf(strA + strB) <Long.valueOf(strB+strA)){
            return true;
        }
        return false;
    }
}
