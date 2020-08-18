package com.eco.study.scala

/**
 * 类和对象
 * 类是对象的抽象 ， 对象是类的实例，
 *
 *  1 类是抽象的因此不占用内存
 *  2 对象是具体的占用存储空间
 *
 */
object L14_ClassAndObject {

  def main(args: Array[String]): Unit = {
    var pt = new Point(10,20)

    // move a new Position
    pt.move(10,10)
  }

}

class Point(xc : Int , yc:Int){
  var x:Int  = xc;
  var y:Int = yc

  def move(dx : Int,dy:Int): Unit ={
    x = x+dy
    y = y+dy
    println("move...")
    println("x 的坐标点 : " + x)
    println("y 的坐标点 : " + y)
  }
}

class Location( val xc :Int ,  yc:Int,val zc:Int) extends Point(xc,yc){
  var z:Int = zc;

}

