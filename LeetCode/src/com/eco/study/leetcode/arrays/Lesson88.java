package com.eco.study.leetcode.arrays;

import java.util.Arrays;

/**
 * ClassName Lesson88
 * Description
 * Date 2021/8/7
 * Author wangxiyue.xy@163.com
 *
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class Lesson88 {

    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
        int m = 1, n = 5;
        Solution88 solution = new Solution88();
//        solution.merge(nums1,m,nums2,n);
//        print(nums1,m+n);
//        System.out.println();
        solution.merge2(nums1,m,nums2,n);
        print(nums1,m+n);
    }

    public  static  void print(int[] nums1,int len){
        for (int i = 0; i < len; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
    }


}

class Solution88 {

    /**
     * 简单方法 ，先合并 再排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1 , int m , int[] nums2 , int n ){
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1,0,m+n);

    }

    /**
     * 插入排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1 , int m,int[] nums2, int n){
        for (int i = 0; i < n; i++) {//nums2
            if(m == 0 ){
                nums1[i] = nums2[i];
                continue;
            }

            for (int j = 0; j < m; j++) {//nums1
                if(nums2[i] < nums1[j]){
                    int last = nums1[j];//获取当前 num1 值
                    nums1[j] = nums2[i];//插入小值
                    int curr = 0;
                    for (int i1 = j+1; i1< (m + n -1); i1++) {// num1 中 当前位置后续的重排序
                        curr = nums1[i1];
                        nums1[i1] =  last;
                        last = curr;

                    }
                    break;
                }
                int last = nums1[j+i];
                nums1[j+i] = nums2[i];
                int curr = 0;
                for (int i1 = j; i1< (m + n); i1++) {// num1 中 当前位置后续的重排序
                    curr = nums1[i1];
                    nums1[i1] =  last;
                    last = curr;

                }
                Lesson88.print(nums1,m+n);
            }

        }

    }

    private void sort(int[] nums1, int target){

    }
}
