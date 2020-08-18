package com.eco.study.scala

/**
 * Scala 基础语法
 *
 *  Scala 结尾　分号可选
 *  Scala 程序是对象集合,　通过彼此的方法实现消息传递
 *
 *  对象：　对象是一个类的实力
 *  类　：　类　是　对象的抽象　，而对象是类的具体实例
 *  方法：　方法描述的基本行为，一个类可以包含多个方法
 *  字段：每个对象都有他唯一的实例变量结合，即字段。对象的属性通过给字段赋值来创建。
 *
 *
 *  区分大小写
 *  类名　 :所有的类名　第一个字母要大写
 *  方法名 :所有方法名　第一个字母要小写
 *  程序文件名：　程序文件名应与对象名完全匹配（新版不需要）
 *
 *  def main(args: Array[String]) 程序入口
 *  避免使用下划线结尾的标识符避免冲突
 *
 *  转义字符
 *    ->  用　$colon$minus$greater 表示
 *
 *
 *
 */
object L1_HelloWorld {

  /**
   * #编译
   * scalac L1_HelloWorld.scala
   * #执行
   * scala L1_HelloWorld
   *
    * @param args
   */
  def main(args: Array[String]): Unit = {
    println("Hello, world!"); // 输出Hello World
    var s = "runoob scala　教程"; println(s);

  }

}

/***
 * Scala  默认总会引入:
 *  java.lang._
 *  scala._
 *  Predef._
 *
 */
class HelloWorld {
  import java.util.{HashMap => JavaHashMap } ; // 引入HashMap 重命名为 JavaHashMap
  import java.util.{HashMap => _,_} ;// 引入　util包所有成员，但是HashMap 被隐藏
  import java.util.{ArrayList , List} ;// 引入　ArrayList 和　List 包
  import java.util._ ; //　引入util 所有成员　 下划线　代表　星号



}
