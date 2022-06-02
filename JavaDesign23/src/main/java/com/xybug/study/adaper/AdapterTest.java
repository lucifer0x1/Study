package com.xybug.study.adaper;

/**
 * ClassName AdapterTest
 * Description
 * Date 2022/6/2
 * Author wangxiyue.xy@163.com
 * 适配器模式
 */
public class AdapterTest {

    public static void main(String[] args) {
        adapterTest01();
        adapterTest02();
    }

    public static void adapterTest01(){
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        System.out.println(target.outPut5v());
    }

    public static void adapterTest02(){
        AdapterV2 target = new AdapterV2();
        System.out.println(target.outPut5v());
    }

}

class Adaptee {

    public int outPut220v(){
        return 220;
    }
}

interface Target {
    int outPut5v();
}

/**
 * TODO 组合方式实现适配器
 */
class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int outPut5v() {
        int i = this.adaptee.outPut220v();
        System.out.println("src =" + i + "v to 5 v");
        return 5;
    }
}

class AdapteeV2 {

    public int outPut220v(){
        return 220;
    }
}

/**
 * 适配器继承方式实现适配器
 * Class Adapter
 */
class AdapterV2 extends AdapteeV2 implements Target {


    @Override
    public int outPut5v() {
        int i = outPut220v();
        System.out.println("src =" + i + "v to 5 v");
        return 5;
    }
}
