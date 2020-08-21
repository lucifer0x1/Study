package com.eco.study.scala

/**
 * 模式匹配
 *    一个模式匹配包含了一系列备选项，
 *    1 每个都开始于关键字 case
 *    2 每个备选项都包含了一个模式 和 多个表达式
 *    3 用箭头符号 => 隔开模式和表达式
 */
object L16_CaseMatch {

  def main(args: Array[String]): Unit = {
    println(matchTest(1))
    println(matchTest(10))

    println("### match case")
    println(matchTest2(1))
    println(matchTest2("test"))
    println(matchTest2("two"))
    println(matchTest2(10))

    println("### case class")
    val jerry = new L16Person("Jerry")
    val tom = new L16Person("Tom")
    val jerry100 = new L16Person("Jerry",100)
    val tom100 = new L16Person("Tom",100)
    val other1 = new L16Person("虫子","100")
    val other2 = new L16Person("螃蟹",100)
    for(person <- List(jerry,tom,jerry100,tom100,other1,other2)){
      person match {
          case L16Person("Jerry") => println("Hi Jerry")
          case L16Person("Jerry",100) => println("Hi jerry 100")
          case L16Person("Tom") => println("Hi Tom")
          case L16Person("Tom",100) => println("Hi Tom 100")
          // TODO case class 构造方法中的参数如果已经定义类，则必须使用定义的类型，不能通过其他类型判断
          // TODO 如： 此处不能使用 L16Person(name:String,age:Int)
          case L16Person(name:String,age:Any) => println("Name = " + name + " age = " + age)
      }
    }

  }

  /**
   * 有点类似 Java 的 Switch
   * match 对应 Java的switch 但是 选择器表达式之后， 选择器 match { 备选项 }
   * match 表达式通过以代码编写的先后次序每个模式来完成计算，纪要发现有一个case 匹配立即跳出，剩下的case不会被匹配
   */
  def matchTest(x:Int): String = x match {
      case 1=> "one"
      case 2=> "two"
      case 3=> "three"
      case _=> "other" ;// case default
  }

  // TODO 相比使用  isInstanceOf 来判断类型， 用 case 模式匹配更好
  def matchTest2(x:Any) :Any = x match {
      case 1 => "one"
      case "two" => 2
      case y:Int => "Scala.Int";//类型判断 == isInstanceOF
      case _ => "many"
  }

}

/**
 * 使用样例类
 *    使用case关键字定义的类就是 样例类 （ case classes）
 *    TODO 样例类是特殊类，经过优化用于匹配模式
 *
 *    TODO scala 类的构造方法分为主构造方法，通过 This(args:Any* ) 可以定义多个构造方法
 *
 *    声明样例类case class自动发生如下情况：
 *    1 构造器的每个参数都成为 val 除非显示声明位 var ，不推荐用var
 *    2 在伴生对象中提供了apply方法，所以可以不使用new关键字就可以构建对象
 *    3 提供unapply 方法使用模式匹配可以工作   TODO unapply方法？
 *    4 生成toString，equals ， hashCode 和 copy 方法，除非显示给出这些方法的定义
 *
 */
case class L16Person(name:String,args:Any*){

  var age:Int = 0

  def this(name:String,age : Int){
    this(name =name,args =age)
    this.age = age
  }
  // TODO ???????????????
  /*
  def this(args:Any*){
    this(name)
  }
   */

}