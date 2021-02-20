package com.eco.study.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @auther lucifer
 * @mail wangxiyue.xy@163.com
 * @date 2021-02-20 13:54
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 */
public class LessonBiNode {

    public static void main(String[] args) {
        Integer[] input= new Integer[]{4,2,5,1,3,null,6,0};
        TreeNode root = buildTree(input);
//        printTree(root);
        SolutionBiNode solution = new SolutionBiNode();
        TreeNode node = solution.convertBiNode(root);
        printTree(node);

    }

    public static void printTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            System.out.println(tmp.val);
            if(tmp.left!=null){
                queue.offer(tmp.left);
            }

            if(tmp.right!=null){
                queue.offer(tmp.right);
            }
        }

    }

    public static TreeNode buildTree(Integer[] input){
        TreeNode root = new TreeNode(input[0]);
        for (int i = 1; i < input.length; i++) {
            if(input[i]==null){
                continue;
            }
            TreeNode tmp = new TreeNode(input[i]);
            createNode(tmp,root);
        }
        return root;
    }
    public static void createNode(TreeNode now,TreeNode last){
        if(now==null){
            return ;
        }
        if(now.val<last.val){
            if(last.left == null){
                last.left = now;
            }else {
                createNode(now,last.left);
            }
        }else {
            if(last.right == null){
                last.right = now;
            }else {
                createNode(now,last.right);
            }
        }
    }
}

class SolutionBiNode{

        public TreeNode convertBiNode(TreeNode root) {
            Stack<TreeNode> queue = new Stack<>();
            TreeNode head = new TreeNode(0);
            TreeNode pre = head;
            TreeNode node= root;
            while (node!=null || !queue.isEmpty()) {
               if (node != null) {
                   queue.push(node);
                   node = node.left;
               } else {
                   node = queue.pop();
                   node.left = null;
                   pre.right = node;
                   pre = node;
                   node = node.right;
               }
            }
            return head.right;
        }

}