package com.eco.study.scala

/**
 * 字符串
 */
object L10_String {

  val greeting : String = "Hello,World"

  def main(args: Array[String]): Unit = {
    println(greeting)

    val buf = new StringBuilder
    buf+='a'
    // TODO ++= 和 += 不是运算符， 是 StringBuild 的方法， 参见 @StringBuild源码
    buf ++= "bcdef"
    println("buf is : " + buf.toString())
    var len = buf.length()
    println("String  Length is : " + len)

    var str :String = "Hello"

    str.concat("Scala")
    println(str)
    println(str.concat("Scala"))

    var floatVar = 12.345
    var intVar = 67890
    var stringVar = "虫子"
    // TODO printf 如和去掉结尾打印的 括号 （）
    var fs = printf("%s 说 %f 是单精度浮点， %d 是整形\n",stringVar,floatVar,intVar)
    println(fs)

  }

}
