package com.eco.study.scala

import scala.util.matching.Regex


/**
 * 正则表达式
 *  通过 scala.util.matching包中的 Regex类来支持正则表达式
 */
object L17_MatchingRegex {


  def main(args: Array[String]): Unit = {
    // 实力中使用String类的 r() 方法构造了一个Regex对象
    val pattern = "Scala".r;// val pattern:Regex
    val str1 = "Scala is scalable and cool"
    val str2 = "Hello scala"
    println(pattern findFirstIn str1)
    println(pattern.findFirstIn(str1).getOrElse("没有"))
    println(pattern.findFirstIn(str2).getOrElse("没有"))
    println(pattern findAllIn str1 mkString ",")

    val p = new Regex("(S|s)cala") ; // | 或运算
    println(p findAllIn str1 mkString ",")
    println(p replaceFirstIn (str1,"Hello"))
  }

}
