package com.xybug.study.decorator;

/**
 * ClassName DecoratorTest
 * Description
 * Date 2022/6/3
 * Author wangxiyue.xy@163.com
 * 装饰模式
 */
public class DecoratorTest {

    public static void main(String[] args) {
        decoratorTest01();
        System.out.println("#################");
        decoratorTest02();
    }

    public static void decoratorTest01(){
        Compoment compoment = new ConcreteDecoratorV1(new ConcreteComponent());
        compoment.operation();

    }

    public static void decoratorTest02(){
        Compoment compoment =new ConcreteDecoratorV2( new ConcreteDecoratorV1(new ConcreteComponent()));
        compoment.operation();
    }

}

interface Compoment {
    void operation();
}

class ConcreteComponent implements Compoment {

    @Override
    public void operation() {
        System.out.println("操作 。 拍照");
    }
}

abstract  class  Decorator implements Compoment {
    Compoment compoment;

    public Decorator(Compoment compoment) {
        this.compoment = compoment;
    }

}

class ConcreteDecoratorV1 extends Decorator {


    public ConcreteDecoratorV1(Compoment compoment) {
        super(compoment);
    }

    @Override
    public void operation() {
        /**
         * TODO 附加附加 动作和效果
         */
        compoment.operation();
        System.out.println("concrete decorator 操作 ，拍照 ， 自定义效果  - 滤镜");
    }
}

class ConcreteDecoratorV2 extends Decorator {


    public ConcreteDecoratorV2(Compoment compoment) {
        super(compoment);
    }

    @Override
    public void operation() {
        compoment.operation();
        System.out.println("concrete decorator 操作 ，拍照 ， 自定义效果  - 美颜");
    }
}
