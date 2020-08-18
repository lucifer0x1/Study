package com.eco.study.scala

/**
 * 运算符
 */
object L5_Operator {
  def main(args: Array[String]): Unit = {
    //t1();
    //t2();
    //t3();
    t4()

  }

  def t4(): Unit ={
    val a = 60   /* 60 = 0011 1100 */
    val b = 13   /* 13 = 0000 1101 */
    var c = 0

    c = a & b    /* 12 = 0000 1100 */
    println("a & b = " + c)

    c = a | b    /* 61 = 0011 1101 */
    println("a | b = " + c)

    c = a ^ b     /* 49 = 0011 0001 */
    println("a ^ b = " + c)

    c = ~a        /* -61 = 1100 0011 */
    println("~a = " + c)

    c = a << 2     /* 240 = 1111 0000 */
    println("a << 2 = " + c)

    c = a >> 2     /* 15 = 1111 */
    println("a >> 2  = " + c)

    c = a >>> 2     /* 15 = 0000 1111 */
    println("a >>> 2 = " + c)
  }

  /**
   * 逻辑运算
   */
  def t3(): Unit ={
    var a = true;
    var b = false;

    println("a && b = " + (a && b))
    println("a || b = " + (a || b))
    println("!(a && b) = " + !(a && b))
  }

  /**
   * 关系运算
   */
  def t2(): Unit ={
    var a = 10;
    var b = 20;
    println("a == b = " + (a == b) );
    println("a != b = " + (a != b) );
    println("a > b = " + (a > b) );
    println("a < b = " + (a < b) );
    println("b >= a = " + (b >= a) );
    println("b <= a = " + (b <= a) );
  }

  /**
   * 加减乘除
   */
  def t1(): Unit ={
    var a = 10;
    var b = 20;
    var c = 25;
    var d = 25;

    println("a + b = " + (a + b) );
    println("a - b = " + (a - b) );
    println("a * b = " + (a * b) );
    println("b / a = " + (b / a) );
    println("b % a = " + (b % a) );
    println("c % a = " + (c % a) );
  }
}
