package com.eco.study.scala

import java.io.{FileNotFoundException, FileReader, IOException}

/**
 * 异常处理
 *    抛出异常和JAVA一样 Throw Exception
 */
object L18_Exception {

  def main(args: Array[String]): Unit = {
      try{
        val f = new FileReader("input.txt")
      }catch {
        case ex:FileNotFoundException=>{
          println("Missing file exception")
          println(ex)
        }
        case ex:IOException =>{
          println(ex)
        }
      }finally {
        println("finally...");//每次都会执行finally
      }

  }

}
