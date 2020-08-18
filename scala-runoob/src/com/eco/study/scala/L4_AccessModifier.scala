package com.eco.study.scala

/**
 * 访问修饰
 */
object L4_AccessModifier {
  var s = new Super;

  def main(args: Array[String]): Unit = {
    s.main(args)
  }
}

class Super {
  protected def f(){ println("f")}
  def f2(){println("f2")}

  class Inner {
    private def f(){ println("f")}
    class InnerMost {
      f();
      f2();
    }
  }
  // (new Inner).f() // 错误

  class Sub extends Super {
    f();
  }
  class Other {
    (new Super).f();// new 实例化的新对象　因此可以访问。
  }

  def main(args: Array[String]): Unit = {
    new Sub;
    new Other
    new Inner
  }

}


