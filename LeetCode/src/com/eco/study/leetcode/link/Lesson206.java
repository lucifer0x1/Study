package com.eco.study.leetcode.link;

import org.w3c.dom.NodeList;

/**
 * ClassName Lesson206
 * Description
 * Date 2021/8/27
 * Author wangxiyue.xy@163.com
 *
 *206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class Lesson206 {

    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        Solution206.ListNode headNode = buildListNode(head);
        Solution206 solution = new Solution206();
        headNode = solution.reverseList(headNode);
        printListNode(headNode);

    }

    public static void printListNode(Solution206.ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Solution206.ListNode buildListNode(int[] head){
        if (head.length==0) {
            return null;
        }
        Solution206.ListNode headNode = new Solution206.ListNode(head[0]);
        Solution206.ListNode last = headNode;
        for (int i = 1; i < head.length; i++) {
            last.next = new Solution206.ListNode(head[i]);
            last = last.next;
        }
        return headNode;
    }
}

class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode curr = head;
        ListNode next = null;
        while ( curr!=null){
            next = curr.next;// 获取下一个值保存
            curr.next = last;// 将下一个值反转为上一个值
            last = curr; // 充值上一个指针指向
            curr = next;//当前值跳过到下个node节点
        }
        return last;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() { }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}