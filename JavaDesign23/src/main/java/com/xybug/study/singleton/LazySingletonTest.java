package com.xybug.study.singleton;

/**
 * ClassName L01Singleton
 * Description
 * Date 2022/5/29
 * Author wangxiyue.xy@163.com
 * 单例模式 - 懒汉模式
 */
public class LazySingletonTest {

    public static void main(String[] args) {
        LazySingleton01Test();
        LazySingleton02Test();
        LazySingleton03Test();
    }

    public static void LazySingleton01Test (){
        Thread[] list = new Thread[100];
        for (int i = 0; i < 100; i++) {
            list[i] = new Thread(()->{
                LazySingleton01 instance = LazySingleton01.getInstance();
                System.out.println(instance);
            });
        }
        for (Thread t : list) {
            t.start();
        }
    }

    public static void LazySingleton02Test (){
        Thread[] list = new Thread[100];
        for (int i = 0; i < 100; i++) {
            list[i] = new Thread(()->{
                LazySingleton02 instance = LazySingleton02.getInstance();
                System.out.println(instance);
            });
        }
        for (Thread t : list) {
            t.start();
        }
    }

    public static void LazySingleton03Test (){
        Thread[] list = new Thread[100];
        for (int i = 0; i < 100; i++) {
            list[i] = new Thread(()->{
                LazySingleton03 instance = LazySingleton03.getInstance();
                System.out.println(instance);
            });
        }
        for (Thread t : list) {
            t.start();
        }
    }
}

/**
 * 线程不安全
 */
@Deprecated
class LazySingleton01 {

    private static LazySingleton01 instance;

    public static LazySingleton01 getInstance() {
        if(instance== null){
            try { Thread.sleep(10); }//实例化对象需要的时间
            catch (InterruptedException e) { e.printStackTrace(); }
            instance = new LazySingleton01();
        }
        return  instance;
    }
}

class LazySingleton02 {
    private static LazySingleton02 instance;

    public synchronized static LazySingleton02 getInstance() {
        if(instance == null){//TODO synchronized 加锁后需要再次判断其他并发线程是否已经初始化
            try { Thread.sleep(10); }//实例化对象需要的时间
            catch (InterruptedException e) { e.printStackTrace(); }
            instance = new LazySingleton02();
        }
        return instance;
    }
}

/**
 * double check 加锁
 * 防止指令重排序
 */
class LazySingleton03 {
    // TODO volatile 防止指令重排序
    private volatile static LazySingleton03 instance;
    public static LazySingleton03 getInstance() {
        if(instance== null){
            synchronized (LazySingleton02.class){
                if(instance == null){//TODO synchronized 加锁后需要再次判断其他并发线程是否已经初始化
                    try { Thread.sleep(10); }//实例化对象需要的时间
                    catch (InterruptedException e) { e.printStackTrace(); }
                    instance = new LazySingleton03();
                }
            }
        }
        return instance;
    }
}

