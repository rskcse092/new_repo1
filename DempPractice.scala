object DempPractice {
  def main(args: Array[String]): Unit = {
    print("hello scala")
    print("--if else nested --")
    val a = 2
    val b = 6
    val c= 7
    if(a>b && a>c ){
      println("a is greater")
    }
    else if(b>c && b>a){
      println("b is greater")
    }
    else{
      println("c is greater")
    }
    println("-- pattern matching---")
    var d = 1
    d match {
      case 1 => println("one")
      case 2 => println("two")
      case _ => println("default")

    }
    print("--looping while --")
    var i =1
    while(i < 10 ){
      println(i)
      i += 1
    }
    print("--looping for  --")
    for( i <- 1 to 10 ){print(i)}
    for (i <- 1 until 10 ){println(i)}
    for(i <- 1 to 15 by 1 ) {print(i)}
    for(i <- 1 to 20 by -1){println(i)}
    var l = List(1,2,3,4)
    for (i <- l){println(l)}
    var l1 = List(4,5,6)
    l1.foreach(print)


  }
}
