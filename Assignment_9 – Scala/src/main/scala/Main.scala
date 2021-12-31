object Main {

  ///Assigment 9

  def main(args: Array[String]) = {

    val con = new Container[String]("containervalue")

    println(con.getContent())
    println(con.applyFunction[String](length))

    val yes = new Yes[String]("somevalue")
    val no = new No


    println(yes.isInstanceOf[Maybe[_]])
    println(no.isInstanceOf[Maybe[_]])

    println(yes.getOrElse("empty"))
    println(no.getOrElse("empty"))

  }

  def length(s: String): String = {
    "length of string "+s.length.toString
  }


}