package com.eco.study.scala

/**
 * 闭包
 *  闭包是一个函数，返回值依赖于生命在函数外部的一个或多个变量
 *    也就可以简单的认为是 可以访问你一个函数里面局部变量的另一个函数
 */
object L9_Closure {

  def main(args: Array[String]): Unit = {
    val multiplier = (i:Int ) => i * 10

    var factor = 3
    var multiplier2 = (i:Int) => i * factor

    println(" mutiplier(1) Value = " + multiplier(1))
    println(" mutiplier(2) Value = " + multiplier(2))
    println("# factor = 3 ")
    println(" mutiplier2(1) Value = " + multiplier2(1))
    println(" mutiplier2(2) Value = " + multiplier2(2))

  }
}
