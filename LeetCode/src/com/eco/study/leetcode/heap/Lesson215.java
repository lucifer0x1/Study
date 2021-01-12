package com.eco.study.leetcode.heap;

import com.sun.scenario.animation.shared.ClipEnvelope;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Lesson215 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        Solution215 solution = new Solution215();
        System.out.println(solution.findKthLargest(nums,k));
    }

}

class  Solution215 {

    //大顶堆
public int findKthLargest(int[] nums , int k){

        for (int i = 0; i <k; i++) {
            for (int j = 0; j < (nums.length -2 )/2; j++) {
                builMaxHeap(nums,j, nums.length);
            }

            for (int num : nums) {
                System.out.print(num);
            }
            System.out.println();
        }



        return nums[k-1];
    }


    /**
     * build heap :
     *      左 :2*i+1
     *      右：2*i+2
     *
     * 堆顶最大，遍历是，保存每次保存对顶　ｍａｘ　如果　左右　有大于堆顶　则重排序子节点．
     *
     * @param root 保存堆的数组
     * @param level　当前堆的层级：默认开始是０，数据起始点
     * @param length 堆大小：保存堆数组大小
     *
     */
    private void builMaxHeap(int[] root, int level,int length){
        int tmpEx = 0;

        for (int i = level; i < length; i++) {
            //堆顶位置
            int max = i ;

            if((2*i+1) < length && root[2*i+1]>root[max]){
                max =2*i+1;
            }
            if((2*i+2) < length && root[2*i+2]>root[max]){
                max =2*i+2;
            }
//            if(((2*i+2) < root.length) && (root[2*i+1] < root[2*i+2])){
//                swap(root,2*i+1,2*i+2);
//            }
            if(max >i){
                swap(root,i,max);
            } else {
                break;
            }
        }
    }

    private  void swap(int[] root ,int i, int j){
        int tmpEx = root[i];
        root[i]=root[j];
        root [j]  = tmpEx;
    }
}
