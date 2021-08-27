package com.eco.study.leetcode.link;

/**
 * ClassName Lesson21
 * Description
 * Date 2021/8/26
 * Author wangxiyue.xy@163.com
 *
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class Lesson21 {

    public static void main(String[] args) {
        int[] l1 = {5};
        int[] l2 = {1,2,4};
        Solution21.ListNode h1 = buildListNode(l1);
        Solution21.ListNode h2 = buildListNode(l2);
        Solution21 solution = new Solution21();
        Solution21.ListNode head = solution.mergeTwoLists(h1,h2);
        printListNode(head);

    }

    public static void printListNode(Solution21.ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Solution21.ListNode buildListNode(int[] head){
        if (head.length==0) {
            return null;
        }
        Solution21.ListNode headNode = new Solution21.ListNode(head[0]);
        Solution21.ListNode last = headNode;
        for (int i = 1; i < head.length; i++) {
            last.next = new Solution21.ListNode(head[i]);
            last = last.next;

        }
        return headNode;
    }
}

class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode next = new ListNode();
        boolean isHead = true;
        while ((l1!=null) || (l2!=null)){
            if(l1==null) {
                next.next = l2;
                next = next.next;
                l2 = l2.next;
                if(isHead){
                    head = next;
                    isHead = false;
                }
            } else if(l2 == null){
                next.next = l1;
                next = next.next;
                l1 = l1.next;
                if(isHead){
                    head = next;
                    isHead = false;
                }
            } else {//l1 !=null l2!=null
                if(l1.val < l2.val){
                    next.next = l1;
                    next = next.next;
                    l1 = l1.next;
                    if(isHead){
                        head = next;
                        isHead = false;
                    }
                }else {
                    next.next = l2;
                    next = next.next;
                    l2 = l2.next;
                    if(isHead){
                        head = next;
                        isHead = false;
                    }
                }

            }

        }
        return head;
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


