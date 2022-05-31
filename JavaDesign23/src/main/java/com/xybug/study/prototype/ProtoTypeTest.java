package com.xybug.study.prototype;

import java.io.*;

/**
 * ClassName ProtoTypeTest
 * Description
 * Date 2022/5/30
 * Author wangxiyue.xy@163.com
 * 原型模式
 */
public class ProtoTypeTest {

    public static void main(String[] args) {
//        protyTypeTest01();
        protyTypeTest02();
    }

    public static void protyTypeTest02(){
        try {
            BaseInfo baseInfo = new BaseInfo("baseInfo");
            Product product = new Product("1","2",3,4,baseInfo);

            Product clone = product.clone();
            System.out.println("orginal 1: " +product);
            System.out.println("clone 1: " + clone);
            product.getBaseInfo().setCompanyName("orgin change");
            System.out.println("orginal 2: " +product);
            System.out.println("clone 2: " + clone);




        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void protyTypeTest01(){
        BaseInfo baseInfo = new BaseInfo("baseInfo");
        Product product = new Product("1","2",3,4,baseInfo);
        System.out.println(product);

        try {
            System.out.println(product.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class BaseInfo implements Cloneable,Serializable{

    static final long serialVersionUID = 42L;

    private String companyName;

    public BaseInfo(String companyName) {
        this.companyName = companyName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }

    @Override
    public String toString() {
        return "["+this.hashCode()+"]BaseInfo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

/**
 * 重写实现 Cloneable 实现clone 接口
 */
class  Product implements Cloneable,Serializable {

    static final long serialVersionUID = 42L;

    private String part1;
    private String part2;
    private Integer part3;
    private Integer part4;

    private BaseInfo baseInfo;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public Product() {
    }

    public Product(String part1, String part2, Integer part3, Integer part4 , BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.baseInfo = baseInfo;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        // TODO version 1
//        Product clone =  (Product) super.clone();
//        BaseInfo clone1 = this.baseInfo.clone();
//        clone.setBaseInfo(clone1);
//        return clone;
        // TODO version 2
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)){
            Product product = (Product) objectInputStream.readObject();
            return product;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;


    }

    @Override
    public String toString() {
        return "["+this.hashCode()+"]Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3=" + part3 +
                ", part4=" + part4 +
                ", baseInfo=" + baseInfo +
                '}';
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public Integer getPart3() {
        return part3;
    }

    public void setPart3(Integer part3) {
        this.part3 = part3;
    }

    public Integer getPart4() {
        return part4;
    }

    public void setPart4(Integer part4) {
        this.part4 = part4;
    }
}