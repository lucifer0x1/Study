package com.eco.study.scala

object L6_IfElse {

  def main(args: Array[String]): Unit = {
    //t3;
    t4
  }

  def t4: Unit = {
    var x = 30;
    var y = 10;

    if(x == 30){
      if( y==10){
        println(" x = 30 , y = 10")
      }
    }
  }

  def t3(): Unit ={
    var x =30 ;
    if(x ==10){
      println("x 的值为　10")
    }else if (x == 20){
      println("x 的值为　20")
    }else if (x == 30 ){
      println("x 的值为 30")
    }else {
      println("无法判断　Ｘ 的值")
    }
  }

  def t2(): Unit ={
    var x =30;
    if(x < 20){
      println("x 小于 20")
    } else {
      println("x 大于　20")
    }
  }

  def t1(): Unit ={
    var x =10;
    if(x< 20){
      println("x<20")
    }
  }
}
