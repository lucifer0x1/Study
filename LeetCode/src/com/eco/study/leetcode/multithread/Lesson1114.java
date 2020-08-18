package com.eco.study.leetcode.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 */
public class Lesson1114 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Foo foo = new Foo();
        executorService.execute(new Thread(()-> {
            try {
                foo.first(()-> System.out.println("one"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executorService.execute(new Thread(()-> {
            try {
                foo.first(()-> System.out.println("two"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executorService.execute(new Thread(()-> {
            try {
                foo.first(()-> System.out.println("three"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        executorService.shutdown();

    }

}

class Foo {

    private AtomicBoolean firstJob = new AtomicBoolean(false);
    private AtomicBoolean secondJob = new AtomicBoolean(false);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJob.set(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(true){
            if(firstJob.get()){
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondJob.set(true);
                break;
            }
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        while(true){
            if(secondJob.get()){
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                break;
            }

        }
    }
}
