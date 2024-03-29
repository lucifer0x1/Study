package com.eco.study.leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName Lesson232
 * Description
 * Date 2021/8/28
 * Author wangxiyue.xy@163.com
 *
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * 进阶：
 *
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 *
 * 示例：
 *
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 * 提示：
 *
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * 通过次数150,402提交次数217,645
 */
public class Lesson232 {

    public static void main(String[] args) {
        Solution232.MyQueue myQueue = new Solution232.MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}

class Solution232 {

    /**
     ** 栈：只有一边 进出，所有是先进后出入
     ** 对列：一边进，一边出，所以是先进，先出
     */
    static class MyQueue {

        List<Integer> list = new LinkedList<Integer>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            list.add(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int c = 0;
            if(list.size()>0){
                c = list.remove(0);
            }
            return c;
        }

        /** Get the front element. */
        public int peek() {
            if(list.size() > 0){
                return list.get(0);
            }
            return 0;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(list.size() > 0){
                return false;
            }
            return true;
        }
    }
}
