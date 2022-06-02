package com.eco.study.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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


    /**
     * 标准二叉树
     * @param now
     * @param last
     */
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
