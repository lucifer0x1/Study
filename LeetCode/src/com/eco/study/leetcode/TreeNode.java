package com.eco.study.leetcode;

/**
 * ClassName TreeNode
 * Description
 * Date 2021/8/28
 * Author wangxiyue.xy@163.com
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
