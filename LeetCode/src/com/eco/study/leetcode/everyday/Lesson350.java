package com.eco.study.leetcode.everyday;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */
public class Lesson350 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{-2147483648,1,2,3};
        int[] nums2 = new int[]{1,-2147483648,-2147483648};
//        int[] nums1 = new int[]{1,2,2,1};
//        int[] nums2 = new int[]{2,2};
//        [-2147483648,1,2,3]
//        [1,-2147483648,-2147483648]

        int[] re = new Solution350().intersect(nums1,nums2);
        for (int i : re) {
            System.out.println(i);
        }

        Map<Integer,Integer> t = new HashMap<>();
        t.getOrDefault(1,1);
    }
}

class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        return instersect_2(nums1,nums2);
    }

    /**
     * 用hashMap 判断更快 , hash计数策略
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] instersect_2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> base = new HashMap<>();
        for (int i : nums1) {
            base.put(i,base.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[nums2.length];
        int index = 0;
        for (int i : nums2) {
            if(base.getOrDefault(i,0)>0){
                res[index++] = i;
                base.put(i,base.getOrDefault(i, 0) - 1);
                if(base.getOrDefault(i,0) == 0){
                    base.remove(i);
                }
            }
        }
        return  Arrays.copyOf(res,index);
    }

    /**
     * 双重循环,简单暴力,但是时间和性能都不好
     *
     */
    private static int[] instersect_1(int[] nums1, int[] nums2){
        List<Integer> res = new ArrayList();
        List<Integer> l1 =  Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> l2 =  Arrays.stream(nums2).boxed().collect(Collectors.toList());
        for (int i = 0; i < l1.size(); i++) {
            for (int i1 = 0; i1 < l2.size(); i1++) {
                if(l1.get(i).intValue()== l2.get(i1).intValue()){
                    res.add(l1.get(i));
                    l1.remove(i);
                    l2.remove(i1);
                    i1--;
                    i--;
                    break;
                }
            }
        }
        int[] re = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            re[i] = res.get(i);
        }
        return re;
    }
}
