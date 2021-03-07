package com.eco.study.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @mail wangxiyue.xy@163.com
 * @date 2021-02-08 15:51
 *
 * TODO 累加树 Greater Sum Tree  节点值 = 节点值+ 大于节点的所有值
 * TODO 从 右节点累加
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 * 示例 1：
 *                           4
 *              1                       6
 *      0            2              5       7
 *                        3                     8
 *
 *
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 *
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * 示例 3：
 *
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * 示例 4：
 *
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 *
 *
 * 提示：
 *
 * 树中的节点数介于 0和 10^4之间。
 * 每个节点的值介于 -10^4和10^4之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树。
 * 通过次数74,065提交次数113,158
 */
public class Lesson538 {

    public static void main(String[] args) {
        Integer input[]  = new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode node = buildBinaryTree(input);
        Solution538 solution =  new Solution538();
//        printTree(node);
        TreeNode root = solution.convertBST(node);
        printTree(root);

    }

    //4,1,6,0,2,5,7,null,null,null,3,null,null,null,8
    public static TreeNode buildBinaryTree(Integer input[]){
        TreeNode root = new TreeNode(input[0]);
        TreeNode last = root;
        TreeNode tmp = null;
        for (int i = 1; i < input.length; i++) {
            if (input[i]==null) {
                continue;
            }
            tmp = new TreeNode(input[i]);
            createTreeNode(tmp,last);
//            last= tmp;
        }

        return root;
    }

    public static void createTreeNode(TreeNode now,TreeNode last){
        if(now.val < last.val ){
            if (last.left==null) {
                last.left = now;
            }else{
                createTreeNode(now,last.left);
            }
        }else{
            if (last.right==null) {
                last.right = now;
            }else{
                createTreeNode(now,last.right);
            }
        }
    }

    public static void printTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if (tmp !=null){
                System.out.println(tmp.val);
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                }
            }
        }
    }

}

class Solution538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root ==null){
            return  null;
        }
        convertBST(root.right);
        sum = sum+ root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}