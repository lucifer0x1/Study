package com.xybug.study.chainofresponsibility;

/**
 * ClassName ChainOfResponsibilityTest
 * Description
 * Date 2022/6/12
 * Author wangxiyue.xy@163.com
 * 责任连模式
 */
public class ChainOfResponsibilityTest {

    public static void main(String[] args) {
        chainOfResponsibilityTest01();
    }

    public static void  chainOfResponsibilityTest01 (){
        Request request = new Request.RequestBuilder().setFrequent(true).setLogin(false).build();
        FrequentHander frequentHander = new FrequentHander(new LoggingHandler(null));
        if (frequentHander.process(request)) {
            System.out.println("正常");
        } else {
            System.out.println("异常");
        }
    }

}

class Request {
    private boolean isLogin;
    private boolean isFrequent;//frequent频率
    private boolean isPermit;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean isLogin,boolean isFrequent,boolean isPermit,boolean containsSensitiveWords) {
        this.isLogin = isLogin;
        this.isFrequent = isFrequent;
        this.isPermit = isPermit;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder { //构造器，建造者模式
        private boolean isLogin;
        private boolean isFrequent;//frequent频率
        private boolean isPermit;
        private boolean containsSensitiveWords;

        public RequestBuilder setLogin(boolean login) {
            isLogin = login;
            return this;
        }

        public RequestBuilder setFrequent(boolean frequent) {
            isFrequent = frequent;
            return this;
        }

        public RequestBuilder setPermit(boolean permit) {
            isPermit = permit;
            return this;
        }

        public RequestBuilder setContainsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build(){
            return  new Request(isLogin,isFrequent,isPermit,containsSensitiveWords);
        }
    }

    // TODO getter
    public boolean isLogin() {
        return isLogin;
    }

    public boolean isFrequent() {
        return isFrequent;
    }

    public boolean isPermit() {
        return isPermit;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }

    public String getRequestBody() {
        return requestBody;
    }
}

/**
 * TODO 责任链传递，链表方式
 */
abstract class HandlerNode {
    HandlerNode next;

    public HandlerNode(HandlerNode next) {
        this.next = next;
    }

    public HandlerNode getNext(){
        return next;
    }

    public void setNext(HandlerNode next) {
        this.next = next;
    }

    /**
     * 执行责任链 处理 ，
     * 返回true 执行下一个，
     * 返回true 则全部返回
     */
    abstract boolean process(Request request);
}

class FrequentHander extends  HandlerNode {

    public FrequentHander(HandlerNode next) {
        super(next);
    }

    @Override
    boolean process(Request request) {


        System.out.println("访问频率 验证");
        // ...

        if(request.isFrequent()){
            HandlerNode next = getNext();
            if(null == next){//没有下一个节点，责任链结束
                return true;
            }
            if(!next.process(request)){ //下一个环节处理失败，返回false
                return false;
            }else {
                //TODO 下一个环节处理成功（此处应该递归判断）
                return true;
            }
        }

        //当前处理 为满足则返回false
        return false;

    }
}

class  LoggingHandler extends  HandlerNode {

    public LoggingHandler(HandlerNode next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println(" 登录验证 ");
        // ...

        if(request.isLogin()){
            HandlerNode next = getNext();
            if(null == next){//没有下一个节点，责任链结束
                return true;
            }
            if(!next.process(request)){ //下一个环节处理失败，返回false
                return false;
            }else {
                //TODO 下一个环节处理成功（此处应该递归判断）
                return true;
            }
        }

        return false;
    }
}