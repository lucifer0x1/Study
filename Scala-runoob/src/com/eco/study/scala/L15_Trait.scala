package com.eco.study.scala

/**
 * Trait 特征
 *    相当于Java的接口，且功能强于接口，可以定义属性和方法
 *    默认 类只能继承单一父类，但是Trait 可以继承多个，
 */
object L15_Trait {

  def main(args: Array[String]): Unit = {
    val p1 = new PointTest(2, 3)
    val p2 = new PointTest(2, 4)
    val p3 = new PointTest(3, 3)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
  }
}

/**
 * 特征构造顺序：
 *    1 特征也有构造器，由字段的初始化和其他特征体中的语句构成，
 *    2 构造器执行顺序
 *        1 调用超类的构造器
 *        2 特征构造器
 *        3 特征由左 -> 右
 *        4 福特征仙贝构造
 *        5 多个特征同一个父特征 不会重复构造
 *        6 所有特征构造完毕后 子类被构造
 */
trait Equal{
  def isEqual(x:Any):Boolean
  def isNotEqual(x:Any):Boolean = !isEqual(x)
}

class PointTest(xc:Int,yc:Int) extends Equal{
  var x:Int = xc;
  var y:Int = yc;
  override def isEqual(obj: Any): Boolean = {
    (obj.isInstanceOf[PointTest]) && (obj.asInstanceOf[PointTest].x == x)
  }
}