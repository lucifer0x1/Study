package com.eco.study.leetcode.sort;

/**
 *对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class Lesson147 {

    public static void main(String[] args) {
//        ListNode head  =new ListNode(-1);
//        head.next = new ListNode(5);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(0);
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);

        print(head);
        Solution147 solution = new Solution147();
        ListNode listNode  = solution.insertionSortList(head);
        System.out.println();
        print(listNode);
    }

    static void print(ListNode head){
        while (head!=null){
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }
}

class Solution147{

    private void insert(ListNode head,ListNode node,long n){
        ListNode next = head;
        ListNode last = next;

        if(head.next==null){
            head.next = node;
            node.next = null;
            return;
        }

        while (next!=null){
            n--;

            if(node.val > next.val){
                last  = next;
                next = next.next;
            }else{
                node.next = next;
                last.next=node;
                if(n <=0){
                    next.next = null;
                }

                return;
            }
        }
        if(n <=0){
            node.next = null;
        }
        last.next = node;
    }

    ListNode insertionSortList(ListNode head){
        ListNode pHead = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        long n = 0;
        while (head!=null){
            n++;
            p = head;
            head = head.next;
            insert(pHead,p,n);
        }
        return pHead.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
