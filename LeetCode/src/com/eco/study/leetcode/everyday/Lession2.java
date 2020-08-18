package com.eco.study.leetcode.everyday;


/***
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class Lession2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution2 solution = new Solution2();
        ListNode res = solution.addTwoNumbers(l1,l2);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nextflag = 0;
        int val = 0;
        ListNode root = new ListNode(0);
        ListNode point = root;

        while ((l1 !=null) ||( l2 !=null)){
            val = nextflag;
            if(l1!=null){
                val += l1.val;
                l1= l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            if(val > 9){
                nextflag = 1;
                val= val -10;
            }else{
                nextflag = 0;
            }
            point.next= new ListNode(val);
            point = point.next;
        }
        if(nextflag==1){
            point.next = new ListNode(1);
        }
        return root.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }

    ListNode(int val , ListNode next){
        this.val = val;
        this.next = next;
    }
}
