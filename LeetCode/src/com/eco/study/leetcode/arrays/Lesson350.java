package com.eco.study.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.IntFunction;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Lesson350 {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
        Solution350 solution = new Solution350();
        for (int n : solution.intersect(nums1, nums2)) {
            System.out.print(n + ",");
        }
        System.out.println();

    }
}

class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> r = new HashMap<>();
        for (int i1 = 0; i1 < nums1.length; i1++) {
            for (int i2 = 0; i2 < nums2.length; i2++) {
                if(nums1[i1] == nums2[i2]){
                    if (r.containsKey(i2)) {
                        continue;
                    }
                    r.put(i2,nums2[i2]);
                    break;
                }
            }
        }
        int[] res =  new int[r.keySet().size()];
        int index=  0;
        for (Integer key : r.keySet()) {
            res[index] = r.get(key);
            index++;
        }
        return res;
    }
}