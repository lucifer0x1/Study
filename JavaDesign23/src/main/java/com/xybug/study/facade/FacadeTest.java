package com.xybug.study.facade;

/**
 * ClassName FacadeTest
 * Description
 * Date 2022/6/1
 * Author wangxiyue.xy@163.com
 * 门面模式 ， 外观模式
 */
public class FacadeTest {

    public static void main(String[] args) {
        facadeTest01();
    }

    public static void facadeTest01(){

    }
}

class Client01{
    SubSystem01 subSystem01 = new SubSystem01();
    SubSystem02 subSystem02 = new SubSystem02();
    SubSystem03 subSystem03 = new SubSystem03();

    public void doSomething01(){
        subSystem01.method01();
        subSystem02.method02();
        subSystem03.method03();
    }
}

class Client02{
    SubSystem01 subSystem01 = new SubSystem01();
    SubSystem02 subSystem02 = new SubSystem02();
    SubSystem03 subSystem03 = new SubSystem03();

    public void doSomething02(){
        subSystem01.method01();
        subSystem02.method02();
        subSystem03.method03();
    }
}

class Client03{

    ClientFacade facade = new ClientFacade();

    public void doSomething03(){
        facade.facadeDoSomething();
    }
}

class ClientFacade {

    SubSystem01 subSystem01 = new SubSystem01();
    SubSystem02 subSystem02 = new SubSystem02();
    SubSystem03 subSystem03 = new SubSystem03();

    public void facadeDoSomething(){
        subSystem01.method01();
        subSystem02.method02();
        subSystem03.method03();
    }
}

class SubSystem01 {
    public void method01() {
        System.out.println("SubSystem01.method01 execute...");
    }

}

class SubSystem02{
    public void method02(){
        System.out.println("SubSystem02.method02 execute...");
    }
}

class SubSystem03{
    public void method03(){
        System.out.println("SubSystem03.method03 execute...");
    }
}