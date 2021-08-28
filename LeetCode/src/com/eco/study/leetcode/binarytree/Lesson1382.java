package com.eco.study.leetcode.binarytree;

import com.eco.study.leetcode.TreeNode;

/**
 * @mail wangxiyue.xy@163.com
 * @date 2021-02-20 18:08
 * 给你一棵二叉搜索树，请你返回一棵 [平衡后] 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是[平衡的]。
 * 如果有多种构造方法，请你返回任意一种。
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 *
 * 提示：
 *
 * 树节点的数目在1到10^4之间。
 * 树节点的值互不相同，且在1到10^5之间。
 */
public class Lesson1382 {
    public static void main(String[] args) {
        Integer[] input  = new Integer[]{1,null,2,null,3,null,4,null,null};
        Solution1382 solution = new Solution1382();

    }

    public static TreeNode buildTree(Integer[] input){
        if(input.length < 0){
            return null;
        }
        TreeNode root = new TreeNode(input[0]);
        for (int i = 1; i < input.length; i++) {
            if(input[i]==null){
                continue;
            }
            createNode(new TreeNode(input[i]),root);
        }

        return root;
    }

    public static void createNode(TreeNode now,TreeNode last){
            if(now.val < last.val){
                if(last.left == null){
                    last.left = now;
                }else{
                    createNode(now,last.left);
                }
            }else{
                if(last.right == null){
                    last.right = now;
                }else{
                    createNode(now,last.right);
                }
            }
    }

}

class Solution1382{

    public TreeNode balanceBST(TreeNode root) {
        TreeNode tmp  =null;
        if(root!=null){
            if (root.left == null) {
                root.left = root;
                root = root.right;
            }
            if(root.right ==null){
                root.right = root;
                root = root.left;
            }
        }


        return null;
    }
}
