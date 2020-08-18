package com.eco.study.leetcode.everyday;


/***
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class Lesson100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(1));
        TreeNode q = new TreeNode(1,new TreeNode(2),new TreeNode(1));
        Solution100 solution =new Solution100();
        System.out.println(solution.isSameTree(p,q));
    }
}

class Solution100 {
    public boolean isSameTree(TreeNode p , TreeNode q){

        if(p!=null && q != null){
            if(p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
            return false;
        }else if (p==q){
            return true;
        } else {
            return false;
        }
//        if((p == q )||(p.val == q.val)){
//            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
//        }
//        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }

    TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}