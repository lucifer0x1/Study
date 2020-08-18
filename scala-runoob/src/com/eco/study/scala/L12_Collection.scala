package com.eco.study.scala

/**
 * Collection集合
 */
object L12_Collection {

  def main(args: Array[String]): Unit = {
    val x1 = List(1,2,3,4)
    x1.foreach(x => print(x + " " ))
    println()
    val x2 = Set(1,2,3,4)
    x2.foreach(x => print(x + " " ))
    println()
    val x3 = Map("one" -> 1,"two"->2,"three"->3)
    x3.foreach(x => printf("k=%s,v=%d ",x._1,x._2))
    println()
    val  x4 = (100,"虫子")
    printf("k = %d , v = %s \n",x4._1,x4._2)
    val x5 =Some(5);//val x5:Option[Int] = Some(5)
    x5.foreach( x => print(x + " "))
    println()
    val x6:Option[String] = Some("虫子");// Option 只能是None 或者 Some 是 Map的子项
    println(x6.get)

  }

}

/**
 * 列表
 */
object L12_List{

}

/**
 * 集合
 */
object L12_Set{

}
/**
 * 映射
 */
object L12_Map{

}
/**
 * 元组
 */
object L12_Tuple{

}
/**
 * Option 容器选项
 */
object L12_Option{

}


