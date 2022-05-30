package com.xybug.study.singleton;

/**
 * ClassName HungrySingleton
 * Description
 * Date 2022/5/29
 * Author wangxiyue.xy@163.com
 * 单例模式 - 饿汉模式
 */
public class HungrySingletonTest {

    public static void main(String[] args) {
        hungrySingleton01Test();
    }

    public static void hungrySingleton01Test(){
        Thread[] list = new Thread[100];
        for (int i = 0; i < 100; i++) {
            list[i] = new Thread(()->{
                HungrySingleton01 instance = HungrySingleton01.getInstance();
                System.out.println(instance);
            });
        }
        for (Thread t : list) {
            t.start();
        }
    }

}

class HungrySingleton01 {
    private static  HungrySingleton01 instance = new HungrySingleton01();

    private HungrySingleton01(){
        // TODO init
    }

    public static HungrySingleton01 getInstance() {
        return instance;
    }
}
