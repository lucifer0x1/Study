package com.eco.study.scala

import java.util.Date


/***
 * 方法与函数　有区别
 * Scala 方法是类的一部分，
 * 而函数是一个对象可以赋值给一个变量。　类中定义的函数就是方法
 *
 * Scala中的方法跟Java的类似，方法是组成类的一部分
 * Scala中的函数则是一个完整的对象,Scala 中的函数其实就是集成了　Trait 的类的对象
 * Scala中使用的　Val 语句可以定义函数，def 语句定义方法
 *
 */
object L8_Function {

  def apply(): Unit ={
    println("boot L8_function : apply()")
  }

  def main(args: Array[String]): Unit = {
    /*
    println( "Return Value : " + addInt(5,7))
    printMe();
     */
    /*
    var l8 =new L8_CallByName
    var l8 = new L8_Param
    var l8 = new L8_MultyParam
    var l8 = new L8_Recursive
    var l8 = new L8_DefaultParam
    var l8 = new L8_HigherOrderFunction
    L8_Function();//构造方法必须和文件名相同，否无法调用
    var l8 = new L8_NestedFunction
    var l8 = new L8_NonNameFunction
    var l8 = new L8_ApplicationFunction
     */
    var l8 = new L8_CurryingFunction

    l8.main(args)

  }


  def printMe(): Unit ={
    println("Hello,Scala")
  }

  def addInt(a:Int,b:Int) :Int = {
    var sum:Int = 0;
    sum = a + b ;
    return sum;
  }

  def test: Unit = {
    def m (x : Int) =x+3;
    var f = (x :Int) => x + 3;
  }

}

/**
 * 函数柯理化值的是讲原来接受两个参数的函数变成新的接受一个函数的过程，新的函数返回一个 以原有第二个参数位参数的函数
 *
 */
class L8_CurryingFunction{
  def main(args: Array[String]): Unit = {
    /*
    val result = add3(1);
    println(result)
    println(result(2))

     */

    val str1:String = "Hello"
    val str2:String = "Scala"
    println("str1 + str2 = " + strcat(str1)(str2))

  }

  def add1(x:Int,y:Int) = x+y
  def add2(x:Int)(y:Int) = x+ y
  def add3(x:Int) = (y:Int) => x + y;

  def strcat(s1 :String)(s2:String) = {
    s1+s2;
  }

}

/**
 * 偏应用函数
 *  偏应用函数是一种表达式，不需要提供函数需要的所有参数，提前绑定参数
 */
class L8_ApplicationFunction{
  def main(args: Array[String]): Unit = {
    val date = new Date
    log(date,"message1")
    Thread.sleep(1000)
    log(date,"message2")
    Thread.sleep(1000)
    log(date,"message3")
    /**
     * 偏应用函数，绑定 date参数 ， 第二个参数用 下划线 _ 替换缺失参数，并把这个新的函数索引赋值给变量（val 是常量）
     */
    val logWithDateBound = log(date,_:String)
    println("# 偏函数输出")
    Thread.sleep(1000)
    logWithDateBound("msg1")
    Thread.sleep(1000)
    logWithDateBound("msg2")
    Thread.sleep(1000)
    logWithDateBound("msg3")

  }

  def log(date : Date,message :String): Unit ={
    println(date + "----" + message)
  }

}

class L8_NonNameFunction{
  def main(args: Array[String]): Unit = {
    var inc = (x:Int) => x+1
    var x = inc(7) -1
    var mul = (x:Int,y:Int)=>x+y
    var userDir = ()=>{System.getProperty("user.dir")}
    println(userDir())
    println("x = " +x)
    println("mul = " + mul(3,4))
    println("匿名函数 变量 x=3 : " + inc(3)  )
    println("add2 变量 x=3 : " + add2(3))
    println("addDemo: x=3,y=4 : " + addDeme(3,4))

  }

  /**
   * Function1 表示 一个参数 最后一个表示返回值，同理：Function3 表示两个输入参数，一个返回值
   * 匿名函数的简写 可以省略 new Function 部分 值接写 表达式即可 即  : (x:Int) => x+1
   */
  def add2 = new Function1[Int,Int]{
    def apply(x:Int ):Int = x+1;
  }

  def addDeme = new Function2[Int,Int,Int] {
    def apply(x : Int,y:Int) :Int = x+y;
  }


}

/**
 * 函数嵌套
 *  定义在函数内部的函数称之为局部函数。
 */
class L8_NestedFunction{

  def main(args: Array[String]): Unit = {
    println(factorial(0))
    println(factorial(1))
    println(factorial(2))
    println(factorial(3))
  }

  def factorial(i:Int) : Int = {
    def fact(i:Int,accumulator:Int):Int = {
      if(i<= 1)
        accumulator;
      else
        fact(i-1, i * accumulator)
    }
    fact(i,1);
  }
}

/**
 * 高阶函数
 *  操作其他函数， 高阶函数可以使用其他函数作为参数，或者使用函数作为输出结果。
 *  （=>） 传名调用
 */
class L8_HigherOrderFunction{
  def main(args: Array[String]): Unit = {
    println(apply(layout,10))
  }

  /**
   *  TODO apply 方法默认构造方法， 当对象初始化时会被调用；
   */
  def apply(f : Int =>String ,v : Int ) = {
    println("boot apply function")
    f(v)
  }

  def layout[A] (x:A) = "[" + x.toString + "]"
}

/**
 * 默认参数
 */
class L8_DefaultParam{
  def main(args: Array[String]): Unit = {
    println("默认返回值 " +addInt())
    println("给a = 10 " + addInt(a = 10))
    println("给b = 10 " + addInt(b = 10))
    println("给 a= 10 , b= 10 " + addInt(a= 10,b=10))
  }

  def addInt(a:Int = 5 , b:Int = 7):Int = {
    a+b
  }
}

/**
 * 递归调用
 */
class L8_Recursive{
  def main(args: Array[String]): Unit = {
    for (i <-1 to 10){
      println( factorial(i))
    }
  }

  def factorial(n:BigInt):BigInt ={
    if(n<=1){
      1
    } else{
      n * factorial(n-1)
    }
  }


}

/**
 * 可变参数
 */
class L8_MultyParam{
  def main(args: Array[String]): Unit = {
    printStrings("a","b","c","d")
  }

  /**
   *
   * @param args 变量类型用 星号 表示 可变参数
   */
  def printStrings(args:String*): Unit ={
    //args.foreach(s=>println(s))
    for(ar <- args){
      println(ar)
    }
  }
}

/**
 * 指定参数名
 */
class L8_Param{
  def main(args: Array[String]): Unit = {
    printInt(b = 1,a = 3)
  }

  def printInt(a:Int , b:Int): Unit ={
    println("Value of a = " +a)
    println("Value of b = " +b)
  }

}

/**
 * 传值调用：　call-by-value 先计算参数表达式的值，再应用到函数内部
 * 传名调用：　call-by-name 将未计算的参数表达式直接应用到函数内部
 *          传名 调用当在函数内部使用时 执行一次，调用防范（应用时需要慎重使用）
 *
 *          //TODO 输出先后
 *
 * 如果定义的函数没有 声明返回值， 也没有用Unit 修饰,则 返回值是推导类型，以函数体最后一句为准
 *
 *
 *
 */
class L8_CallByName{

  def main(args: Array[String]): Unit = {
    delayed( time())
    delayed2(time())
  }

  def time() :Long={
    println("获取时间，单位为纳秒")
    System.nanoTime()
  }

  // 参数=> 符号  传名调用
  def delayed( t: => Long) : Unit={
    println("在delayed 方法内")
    println("参数　: " + t)
  }
  def delayed2( t:Long) : Unit={
    println("在delayed2 方法内")
    println("参数　: " + t)
  }
}
