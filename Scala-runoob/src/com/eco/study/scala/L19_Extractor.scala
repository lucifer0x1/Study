package com.eco.study.scala

/**
 * 提取器
 *      1 提取器是从 传递给他的对象中提取出构造该对象的参数
 *      2 Scala标准库包含了一些预定义的提取器
 *      3 TODO Scala提取器是一个带有unapply方法的对象（object）
 *      4 unapply方法是apply方法的反向操作：unapply接受一个对象，然后从对象中提取值，提取的值通常是用来构造该对象的值
 */
object L19_Extractor {

  def main(args: Array[String]): Unit = {
    println("Apply 方法 : " + apply("Jerry","163.com"))
    println("Unapply 方法 : " + unapply("Jerry@163.com"))
    println("Unapply 方法 : " + unapply("Jerry"))

    L19Test.main(args)


  }

  def apply(user:String ,domain:String):String ={
    user + "@" + domain
  }

  def unapply(str:String):Option[(String,String)] = {
    val pts = str.split("@")
    if(pts.length == 2){
      Some(pts(0),pts(1))
    }else{
      None
    }

  }
}

/**
 * TODO 当我们在提取器对象中使用 match 语句时： unapply讲自动执行
 */
object L19Test {
  def main(args: Array[String]): Unit = {
    val x = L19Test(5)
    println(x)
    x match {
      case L19Test(num) => println( x + " 是 " + num + "的两倍")
      case _ => println("无法计算 : x * 2")

    }

  }

  def apply( x: Int) =x * 2

  def unapply(z:Int): Option[Int] ={
    val t = z % 2 ;
    if(t == 0 )
      Some(t)
    else
      None
  }

}