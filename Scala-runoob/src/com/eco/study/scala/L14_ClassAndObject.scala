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
    var p1 = new Point(10,20)
    // move a new Position
    p1.move(10,10)

    var p2 = new Location(10,20,15)
    p2.move(10,10,5)
    println("###override 重写")
    val jerry = new Employee
    jerry.name = "Jerry"
    jerry.salary = 10000.23
    println(jerry)
    println("### 单例对象")
    println("### 伴生对象和伴生类")
    // TODO 没有static 默认用object 修饰的对象都是单例， object 对象不带参数
    // TODO 如果 object 和 class 同名 则被认为是这个类的伴生对象: companion object ;
    // TODO 定义伴生对象必须在同一个源文件里,类被称为伴生类: companion class ; 伴生类和伴生对象可以相互访问 私有成员
    println(Marker("red"));// 调用的apply方法
    println(Marker getMarker("blue"));//省略 .(点) 符号

  }

}

class Person {
  var name = ""
  override def toString: String = getClass.getSimpleName + "[name=" + name + "]"
}

class Employee extends Person {
  var salary = 0.0
  override def toString: String = super.toString + "[salary=" +salary + "]"
}

/**
 * object Marker的伴生类
 * 私有构造方法
 * @param color
 */
class Marker private (val color:String){
  println("创建" + this)
  override def toString: String = "颜色标记:" + color
}
/**
 * class Marker 的伴生对象
 * 与类名相同，可以相互访问私有成员
 */
object Marker {
  private val markers:Map[String,Marker] = Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "yellow" -> new Marker("yellow")
  )

  def apply(color: String) ={
    if(markers.contains(color))
      markers(color)
    else
      null
  }

  def getMarker(color:String) = {
    if(markers.contains(color))
      markers(color)
    else
      null
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

  def move( dx:Int,dy:Int,dz:Int): Unit ={
    x = x + dx
    y = y + dy
    z = y + dz
    println("move...")
    println("x 的坐标点 : " + x)
    println("y 的坐标点 : " + y)
    println("z 的坐标点 : " + z)
  }
}

