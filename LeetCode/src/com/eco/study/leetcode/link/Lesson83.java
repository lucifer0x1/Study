package com.eco.study.leetcode.link;

/**
 * ClassName Lesson83
 * Description
 * Date 2021/8/27
 * Author wangxiyue.xy@163.com
 *
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class Lesson83 {

    public static void main(String[] args) {
        int[] head = {1,1,2,3,3};
        Solution83.ListNode headNode = buildListNode(head);
        Solution83 solution =  new Solution83();
        headNode = solution.deleteDuplicates(headNode);
        printListNode(headNode);
    }

    public static void printListNode(Solution83.ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Solution83.ListNode buildListNode(int[] head){
        if (head.length==0) {
            return null;
        }
        Solution83.ListNode headNode = new Solution83.ListNode(head[0]);
        Solution83.ListNode last = headNode;
        for (int i = 1; i < head.length; i++) {
            last.next = new Solution83.ListNode(head[i]);
            last = last.next;
        }
        return headNode;
    }
}

class Solution83 {

    //判断 当前 位置 和 下一个位置的值比较 如果相同就跳过
    public ListNode deleteDuplicates(ListNode head) {
        ListNode next = head;
        while (next!=null){
            if(next.next!=null && (next.next.val == next.val)){
                next.next = next.next.next;
                //TODO 此处 不能移动指针（next=next.next），需要当前指针判断 跳过后的下一个位置
            }else{//如果不相同，就比较下一个
                next = next.next;
            }
        }
        return  head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}