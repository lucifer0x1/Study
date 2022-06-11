package com.xybug.study.templatemethod;

/**
 * ClassName TemplateMethodTest
 * Description
 * Date 2022/6/11
 * Author wangxiyue.xy@163.com
 * 模版方法模式
 */
public class TemplateMethodTest {

    public static void main(String[] args) {
        templateMethodTest01();
    }

    public static void templateMethodTest01(){
        AbstractClass subClass = new SubClass();
        subClass.operation();

        AbstractClass subClass02 = new SubClass02();
        subClass02.operation();

    }
}

abstract class AbstractClass{

    public void operation(){
        // open
        System.out.println("pre ...");
        // sql
        System.out.println("step 1");
        // close
        System.out.println("step 2");

        templateMethod();
    }

    abstract protected void  templateMethod();
}

class SubClass extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("sub class method");
    }
}

class SubClass02 extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("sub class 02 method");
    }
}