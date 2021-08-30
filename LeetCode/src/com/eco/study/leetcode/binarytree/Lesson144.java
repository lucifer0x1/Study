package com.eco.study.leetcode.binarytree;


import com.eco.study.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.eco.study.leetcode.TreeNode.buildBinaryTree;
import static com.eco.study.leetcode.TreeNode.printTree;

/**
 * ClassName Lesson144
 * Description
 * Date 2021/8/28
 * Author wangxiyue.xy@163.com
 *
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Lesson144 {

    public static void main(String[] args) {
        Integer[] root = {3,1,2};
        Solution144 solution = new Solution144();


        List<Integer> res = solution.preorderTraversal(buildBinaryTree(root));
        for (Integer n : res) {
            System.out.print(n + " , ");
        }
        System.out.println();

    }


}

class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> next = new LinkedList<TreeNode>();
        next.add(root);
        TreeNode left = null;
        TreeNode right = null;
        TreeNode mid = null;
        if(root == null) {
            return list;
        }
        while (next.size()>0){
            mid = next.get(next.size()-1);
            left = mid.left;
            right = mid.right;
            list.add(mid.val);
            next.remove(next.size()-1);
            if(right!=null){
                next.add(right);
            }
            if(left!=null){
                next.add(left);
            }




        }
        return list;
    }

}

