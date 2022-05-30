package com.xybug.study.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName InnerClassSingle
 * Description
 * Date 2022/5/29
 * Author wangxiyue.xy@163.com
 * 单例模式 - 静态内部类
 */
public class InnerClassSingletonTest {

    public static void main(String[] args) {
        innerClassSingleton01Test();

        innerClassSingleton02Test();
    }

    public static void innerClassSingleton02Test(){

        try {
            InnerClassSingleton01 instance = InnerClassSingleton01.getInstance();
            Constructor<InnerClassSingleton01> constructor = InnerClassSingleton01.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            InnerClassSingleton01 instanceConstructor = constructor.newInstance();
            System.out.println(instance==instanceConstructor);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void innerClassSingleton01Test(){
        Thread[] list = new Thread[100];
        for (int i = 0; i < 100; i++) {
            list[i] = new Thread(()->{
                InnerClassSingleton01 instance = InnerClassSingleton01.getInstance();
                System.out.println(instance);
            });
        }
        for (Thread t : list) {
            t.start();
        }
    }

}

/**
 * 静态内部类 -  懒加载
 */
class InnerClassSingleton01 {

    private static class InnerClassHolder {
        private static InnerClassSingleton01 instance = new InnerClassSingleton01();
    }

    private InnerClassSingleton01(){
        //TODO
        if(InnerClassHolder.instance!=null){
            throw new RuntimeException("单例模式，不能创建多个对象");
        }
    }

    public static  InnerClassSingleton01 getInstance(){
        return  InnerClassHolder.instance;
    }
}