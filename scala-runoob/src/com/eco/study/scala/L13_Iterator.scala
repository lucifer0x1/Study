package com.eco.study.scala

/**
 * 迭代器
 *  Iterator不是结合, 是访问集合的方法
 *  主要利用 next 和 hasNext
 *
 *  每次调用 it.next() 会返回下一个元素，同时更新迭代器状态到下一个位置
 *  it.hasNext 不会更新状态。
 *
 */
object L13_Iterator {

  def main(args: Array[String]): Unit = {
    val it = Iterator("hello","scala","java","虫子")
    while (it.hasNext){
      println(it.next())
    }

    val it1 = Iterator(20,40,23,40,68,23)
    val it2 = Iterator("23","43","32","343")

    println("### 调用min 和 max 方法 会被动的更新迭代器状态 [慎用]")
    println(it1.min)
    if(it1.hasNext == false){
      println("#迭代器已经用尽！")
      println("#调用 it1.size 或 it1.length 都会讲迭代器耗尽 ")
    }
    println(it2.max)
  }
}
