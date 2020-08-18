package com.eco.study.scala

object L3_variable {


  def main(args: Array[String]): Unit = {
    var myVar1 : String = "Foo";
    var myVar2 : String = "Too"
    println(myVar1)
    println(myVar2)

    // 常数不能修改
    val myVal : String = "Foo"
    println(myVal)

    var pa  = (40,"Foo")
    println(pa)
    val pb = (40,"Foo")
    println(pb)

  }
}
