import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main{

  /// Assigment 6 - Scala All answers


    def main(args: Array[String]) = {

      //1a 7 element list with names of days of the week
      val daysOfaWeek:List[String] = List("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

      // days which is started s of a week
      val daysOfaWeekStartWithS=daysOfaWeek.filter(_.startsWith("S"))

      //1a comma-separated list elements using:	for loop
      println("1a for loop : "+ (commaSep(daysOfaWeek)))

      //1b comma-separated list elements using:	for loop
      println("1b for loop started S elements : "+commaSep(daysOfaWeekStartWithS))

      //1c comma-separated list elements using:	while loop
      println("1c while loop : "+commaSepWL(daysOfaWeek))

      //1c comma-separated list started S elements  using:	while loop
      println("1c while loop started S elements : "+commaSepWL(daysOfaWeekStartWithS))

      //2a recursive
      println("2a recursive : "+commaSepRec(daysOfaWeek))

      //2b recursive
      println("2b recursive last to first : "+commaSepRecLastToFirst(daysOfaWeek))

      //3 tail recursive
      println("3 tail recursive : "+commaSepTailRec(daysOfaWeek))


      //4a foldLeft
      println("4a foldLeft : "+commaSepFoldL(daysOfaWeek))

      //4b foldLeft
      println("4b foldRight : "+commaSepFoldR(daysOfaWeek))

      //4c foldLeft days started with S
      println("4c foldLeft days started with S : "+commaSepFoldLDaysWithS(daysOfaWeek))

      //5. map

      val products=Map("Bread"->5,"Milk"->6,"Egg"->2,"Tomatoes"->4,"Potatoes"->1)

      val productsDiscounted=products.map { case (key, value) => (key, value / 1.1)}

      println("5 products and price after discount :" + productsDiscounted )


      //6

      val listOfInt=List(5,6,8,10,-7,-6,15,13,12,2,-1,-3,0)

      println("6 increase by 1 "+increaseByOne(listOfInt))

      //7

      println("7 abs <-5,12> "+task7(listOfInt))

      //8
      task8((8,"Ali",(5,"Güler")))


      //9

      println("7 abs <-5,12> "+ task9(listOfInt))


      //10 option

      var cMessage:Option[String] = None

      // If null
      println(cMessage.getOrElse("Happy new year"))

      cMessage= Some("Happy New Year Ali")

      // If not null
      println(cMessage.getOrElse("Happy new year"))

      ///
      val employee = Employee(2, "Jane Doe", None, 3)
      println(employee.gender.getOrElse("Not specified"))

      val resOpt = EmployeeDB.findEmployeeById(1)
      if (resOpt.isDefined)
        println(resOpt.get.name) //Prints John Deer

      val employeex = Employee(2, "Jane Doe", None, 3)
      employee.gender match {
        case Some(gender) => println(gender)
        case None => println("Not specified")
      }


    }


    def commaSep(days:List[String]):String={
      // return comma-separated list elements using:for loop
      var daysCommaSep:String="";

      for(day:String<-days){
        if(daysCommaSep=="")
        daysCommaSep=day
        else
          daysCommaSep+=","+day
      }
      daysCommaSep;
    }


  def commaSepWL(days:List[String]):String={
    // return comma-separated list elements using:while loop
    var daysCommaSep:String="";

    val iterator = days.listIterator()

    while(iterator.hasNext) {
      if (daysCommaSep == "")
        daysCommaSep = iterator.next()
      else
        daysCommaSep += "," + iterator.next()
    }
    daysCommaSep;
  }

  def commaSepRec(days:List[String]):String= {
    // return comma-separated list elements using:recursive

    def addDay(i: Int ): String = {

      if(i< days.length-1)
        days.get(i) + "," + addDay(i + 1)
      else
        days.get(i)
    }
     addDay(0)

  }

  def commaSepRecLastToFirst(days:List[String]):String= {
    // return comma-separated list elements using:recursive last to first

    def addDay(i: Int ): String = {

      if(i>0)
        days.get(i) + "," + addDay(i -1)
      else
        days.get(i)
    }

    addDay(days.length-1)

  }

  def commaSepTailRec(days:List[String]):String={
    /// tail recursive
    var daysCommaSep=""
    @tailrec
    def addDay(i:Int,result:String):String={
      var  day:String=""

      if(i==days.length) return  result

      if(i< days.length-1)
        day= days.get(i)+","
       else
        day =  days.get(i)

      addDay(i+1,result+day)
    }

    addDay(0,"")

  }


  def commaSepFoldL(days:List[String]):String= {
    // return comma-separated list elements using:Foldleft

    val daysCommaSep= days.foldLeft(""){(acc:String,currDay:String)=>

      var sum:String=""

      if(acc=="")
        sum = currDay
      else
        sum=acc+","+currDay
      sum;

    }
    daysCommaSep;
  }

  def commaSepFoldR(days:List[String]):String= {
    // return comma-separated list elements using:FoldRight

    val daysCommaSep= days.foldRight(""){(acc:String,currDay:String)=>

      var sum:String=""

      if(currDay=="")
        sum = acc
      else
        sum=acc+","+currDay
      sum;

    }
    daysCommaSep;

  }


  def commaSepFoldLDaysWithS(days:List[String]):String= {
    // return comma-separated list elements using:FoldL days Started with S
    // task

    val daysCommaSep= days.filter(_.startsWith("S")).fold(""){(acc:String,currDay:String)=>

      var sum:String=""

      if(acc=="")
        sum = currDay
      else
        sum=acc+","+currDay
      sum;

    }
    daysCommaSep;

  }

  def increaseByOne(list: List[Int]):List[Int]={
  /// task 6
    val newList=list.map(x=>x+1)

    return newList;

  }

  def task7(list: List[Int]):List[Int]={
    // task7
    val newList=list.filter(_ >= -5).filter(_ < 12).map(_.abs)

    return newList;

  }

  def task8(tuple:(Any,Any,Any))={

    println("8 tuple first element "+tuple._1)
    println("8 tuple second element "+tuple._2)
    println("8 tuple third element "+tuple._3)

  }

  def task9(list:List[Any]):List[Any]={

    def iter(index: Int, currentList: List[Any]): List[Any] = {

      if (index >= currentList.length) return currentList;

      val (part1, part2) = currentList.splitAt(index)

      if (currentList.get(index) == 0)
        iter(index + 1, part1 ++ part2.tail)
      else
        iter(index + 1, currentList)
    }

    iter(0, list)

  }


  case class Employee (
                        id: Int,
                        name: String,
                        gender: Option[String],
                        tenure: Int
                      )
  object EmployeeDB {
    private val employees = Map(
      1 -> Employee(1, "John Deer", Some("Male"), 5),
      2 -> Employee(2, "Jane Doe", None, 3)
    )

    def findEmployeeById(id: Int) : Option[Employee] = {
      employees.get(id)
    }
  }

}

