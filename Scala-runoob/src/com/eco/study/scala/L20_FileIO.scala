package com.eco.study.scala

import java.io.{BufferedReader, File, FileInputStream, FileReader, PrintWriter}

import scala.io.{Source, StdIn}

/**
 * Scala 文件IO
 * Scala的文件写操作直接调用的是Java中的I/O类 （java.io.File）
 */
object L20_FileIO {

  def main(args: Array[String]): Unit = {
    val writer  = new PrintWriter(new File("test.txt"))
    writer.write("虫子")
    writer.close()
    val br = new BufferedReader(new FileReader("test.txt"))
    var line:String  = br.readLine();
    while(line!=null){
      print(line)
      line = br.readLine()
    }


    println("接收命令行输入的参数")
    line = StdIn.readLine();
    print("您输入的信息是 : " + line)

    // TODO Scala 2.11 后的版本 Console.readLine 已废弃，使用　scala.io.StdIn.readLine() 方法代替

    println("文件读取，使用　Scala的　[Source类及伴生对象] 来读取文件")
    println("test.txt 文件内容为:")
    val file  = Source.fromFile("test.txt")
    file .foreach(l => println(l)); //非按行读取
    file.close();


  }
}
