package com.eco.study.scala

object L7_WhileFor {



  def main(args: Array[String]): Unit = {
    t9
  }

  def t9: Unit = {
    var  a = 0;
    val numList = List( 1,2,3,4,5,6,7,8,9,10);

    // for
    var retVal = for {
       a <- numList if a!=3; if a < 8
    } yield a

    for( a<- retVal ) println("Value Of a:" +a)


  }

  def t8: Unit ={
    var a =0;
    val numList = List(1,2,3,4,5,6,7,8,9,10)
    for( a <- numList if a!= 5 ; if a > 3 ; if a < 8){
      println( "a != 5 and a >3 and a < 8 , a="+a)
    }
  }

  def t7: Unit = {
    var a  = 0;
    val numList = List(1,2,3,4,5,6,7,8)

    for(a <- numList){
      println("List of "+a)
    }
  }

  // 双循环，　循环嵌套
  def t6: Unit = {
    var a  = 0
    var b = 0
    for (a <- 1 to 3 ; b <-1 to 10){
      println("Value of a = "+a)
      println("Value of b = "+b);
    }
  }

  // until 不能取到　10
  //  i until j 语法(不包含 j)
  def t5: Unit = {
    var a = 0;
    for ( a <- 1 until  10 ){
      println( a)
    }
  }


  def t4: Unit = {
    var a = 0;
    // for　循环 <- 变量赋值
    for (a <-1 to 10){
      println( "Value of a : " + a);
    }
  }

  def t3: Unit = {
    var a = 10;
    do {
      println( "Value Of a :" + a)
      a = a+1
    }while (a < 20)
  }

  def t2: Unit = {
    var a = 10
    while ( a < 20){
      println( "Value of a :" + a);
      a = a + 1;
    }
  }

  def t1: Unit ={
    var a = 10;
    while(true){
      println("a 的值为　:" + a)
    }
  }

}
