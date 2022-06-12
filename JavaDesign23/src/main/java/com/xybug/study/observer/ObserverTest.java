package com.xybug.study.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName ObserverTest
 * Description
 * Date 2022/6/12
 * Author wangxiyue.xy@163.com
 * 观察者模式
 */
public class ObserverTest {

    public static void main(String[] args) {
        observerTest01();
    }

    public static void observerTest01(){
        TopicSubject subject = new TopicSubject();
        Test1Observer t1 = new Test1Observer();
        subject.addObserver(t1);
        Test2Observer t2 = new Test2Observer();
        subject.addObserver(t2);
        subject.notifyObserver(" event 1");
        System.out.println("-----------------");
        subject.removeObserver(t1);
        subject.notifyObserver("event 2");
    }

}

class TopicSubject {
    // container all obs
    List<Observer> container = new ArrayList<>();
    // add
    public void addObserver(Observer observer){
        container.add(observer);
    }
    // remove
    public void removeObserver(Observer observer){
        container.remove(observer);
    }

    // notify Observer
    public void notifyObserver(Object obj){
        for (Observer obs : container) {
            obs.update(obj);
        }
    }
}

interface Observer {
    void update(Object obj); // notify
}

class Test1Observer implements Observer {
    @Override
    public void update(Object obj) {
        System.out.println( this + ": recv --> " + obj);
    }
}

class Test2Observer implements Observer {
    @Override
    public void update(Object obj) {
        System.out.println( this + ": recv --> " + obj);
    }
}