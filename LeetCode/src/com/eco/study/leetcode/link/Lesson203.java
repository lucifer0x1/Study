package com.eco.study.leetcode.link;

/**
 * ClassName Lesson203
 * Description
 * Date 2021/8/27
 * Author wangxiyue.xy@163.com
 *
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 */
public class Lesson203 {

    public static void main(String[] args) {
        int[] head  = {7,7,7,7};
        int val = 7;
        Solution203 solution = new Solution203();
        Solution203.ListNode headNode = buildListNode(head);
        headNode = solution.removeElements(headNode,val);
        printListNode(headNode);
    }

    public static void printListNode(Solution203.ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Solution203.ListNode buildListNode(int[] head){
        if (head.length==0) {
            return null;
        }
        Solution203.ListNode headNode = new Solution203.ListNode(head[0]);
        Solution203.ListNode last = headNode;
        for (int i = 1; i < head.length; i++) {
            last.next = new Solution203.ListNode(head[i]);
            last = last.next;
        }
        return headNode;
    }
}

class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode next = head;
        ListNode last = null;
        while (next !=null && head !=null){
            if (next.val == val) {
                if(last==null){
                    head = head.next;
                    next = head;
                }else {
                    last.next = next.next;
                    next = next.next;
                }
            }else {
                last = next;
                next = next.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        Solution203.ListNode next;

        public ListNode() { }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, Solution203.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
