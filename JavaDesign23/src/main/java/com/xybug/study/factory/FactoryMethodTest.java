package com.xybug.study.factory;

/**
 * ClassName FactoryMethod
 * Description
 * Date 2022/5/29
 * Author wangxiyue.xy@163.com
 * 工厂方法模式
 */
public class FactoryMethodTest {

    public static void main(String[] args) {

    }

    public static void productFacoryTest(){

    }

}

interface ProductFactory {

    public void method01();

}

class SimpleProductFactory {
    public static ProductFactory createProduct(Integer type){
        switch (type){
            case 1 :
                return new ProductA();
            case 2:
                return new ProductB();
            default:
                return null;
        }
    }
}

class ProductA implements ProductFactory {

    @Override
    public void method01() {
        System.out.println("A");
    }
}

class ProductB implements ProductFactory {

    @Override
    public void method01() {
        System.out.println("B");
    }
}

abstract class ApplicationProductFactory {

    abstract ProductFactory createProduct();

    ProductFactory getObject(){
        ProductFactory product = createProduct();
        System.out.println("build product obj");
        // ...
        // ...
        // ...
        return product;
    }
}