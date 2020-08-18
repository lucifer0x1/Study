package com.eco.study.scala

/**
 * 数组
 */
object L11_Array {

  def main(args: Array[String]): Unit = {
    var z:Array[String] = new Array[String](4)
    var z1  = new Array[String](3)

    z(0) ="虫子"; z(1) = "说" ; z(2) = "Hello"; z(6/2) = "Scala"
    z.foreach(s => println(s))

    var z3 = Array(1.9,2.9,3.4,3.5)
    var total = 0.0
    for( x <- z3 ){
      total += x;
      println(x)
    }

    var max = z3(0);
    for ( i <- 1 to z3.length -1){
      if(max < z3(i)) max = z3(i)
    }
    println("总和为 total = " + total)
    println("最大值 max = " + max)

    // 多维数组
    var myMatrix = Array.ofDim[Int](3,3,3)
    for( i <- 0  to 2){
      for( j <- 0 to 2){
        for( k <- 0  to 2){
          myMatrix(i)(j)(k)= i * j * k
        }
      }
    }

    myMatrix.foreach(
      x1 => {
        println("###################")
        x1.foreach(
          x2=>{
            x2.foreach(
              x3 =>print(x3 + " "))
            println()
          })
      })

    println("###合并数组")
    var myList1 = Array(1.9,2.9,3.4,3.5)
    var myList2 = Array(8.9,7.9,0.4,1.5)
    var myList3 = Array.concat(myList1,myList2)
    for(x <- myList3){
      println(x)
    }
    // TODO Array.range 区间数组， 左闭右开 ， 右边取不到
    println("###区间数组")
    var myList11  = Array.range(10,20,2)
    var myList12 = Array.range(10,20)
    println("list range 10 to 20 step 2 :")
    myList11.foreach(x => print(x + " "))
    println()
    println("list range 10 to 20 default step :")
    myList12.foreach(x => print(x + " "))

    println("tabulate :")
    Array.tabulate(3)(a=>a+1).foreach(x=>print(x +" "))
    println()
    println("tabulate 2: ")
    Array.tabulate(3,2)((a,b) => a * b).foreach( x => { x.foreach( a => print(a + " ")) ; println() })

  }
}
