package com.eco.study.leetcode.link;

/**
 * ClassName Lesson141
 * Description
 * Date 2021/8/26
 * Author wangxiyue.xy@163.com
 *
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */
public class Lesson141 {

    public static void main(String[] args) {
        int[] head = {1,2};
        int pos = -1;
        ListNode headNode = buildListNode(head,pos);
        Solution141 solution = new Solution141();
        System.out.println(solution.hasCycle(headNode));
        if(pos<0){
            printListNode(headNode);
        }

    }


    public static void printListNode(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode buildListNode(int[] head,int pos){
        ListNode headNode = new ListNode(head[0]);
        ListNode last = headNode;
        ListNode posNode = null;
        if(pos == 0 ){
            posNode = headNode;
        }
        for (int i = 1; i < head.length; i++) {
                last.next = new ListNode(head[i]);
                last = last.next;
                if(pos == i){
                    posNode = last;
                }
        }
        last.next = posNode;
        return headNode;
    }
}

class Solution141 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        do{
            if(fast==null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}