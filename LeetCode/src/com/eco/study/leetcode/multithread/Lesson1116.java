package com.eco.study.leetcode.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出："0102030405"
 */
public class Lesson1116 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

        executorService.execute(new Thread(()->{
            try {
                zeroEvenOdd.zero(f-> System.out.println("zero : "+f));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executorService.execute(new Thread(()->{
            try {
                zeroEvenOdd.even(f-> System.out.println("even : " +f));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executorService.execute(new Thread(()->{
            try {
                zeroEvenOdd.odd(f-> System.out.println("odd : " + f));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executorService.shutdown();
    }
}

class ZeroEvenOdd {
    private int n;
    private int step = 0;
    private boolean end =false;
    private Semaphore zero = new Semaphore(0);
    private Semaphore a = new Semaphore(0);
    private Semaphore b = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        // synchronized(this){
        while(step < n){
            step++;
            printNumber.accept(0);
            if((step &1) != 1){
                a.release();
            }else{
                b.release();
            }
            zero.acquire();
        }
        end=true;
        a.release();
        b.release();

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true){
            a.acquire();
            if(end){
                break;
            }
            printNumber.accept(step);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true){
            b.acquire();
            if(end){
                break;
            }
            printNumber.accept(step);
            zero.release();
        }
    }
}