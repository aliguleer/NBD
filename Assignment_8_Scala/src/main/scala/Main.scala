
object Main {
  ///Assigment 8

  def main(args: Array[String]) = {

    // Task1
    println("====>  task 1")
    var day:String="Monday"
    println(workOrWeekend(day))
    day="Saturday"
    println(workOrWeekend(day))
    day="Blabla"
    println(workOrWeekend(day))


    /// task 2 test
    println("====>  task 2")
    val bankAccount = new BankAccount()
    bankAccount.deposit(100)
    bankAccount.withdraw(50)
    bankAccount.withdraw(110)
    println(bankAccount.toString)

    // task 3
    println("====>  task 3")
    val person1 = new Personx("Ali","Guler")
    val person2 = new Personx("Jason","Friday")
    val person3 = new Personx("Brad","Bread")
    val person4 = new Personx("Joe","Soe")
    val person5 = new Personx("John","Doe")

    println(greeting(person1))
    println(greeting(person2))
    println(greeting(person3))
    println(greeting(person4))
    println(greeting(person5))

    println("====>  task 4")
    /// task4
    println(task4(5,double))


    ///task5


    println("====>  task 5")

       val personN1 = new Person("Ali", "Güler") with Student

       println(s"The student tax is: ${personN1.taxToPay}%")

       val personN2 = new Person("John", "Doe") with Employee

       println(s"The employee tax is  ${personN2.taxToPay}%")

       val personN3 = new Person("Joe", "Blansky") with Teacher
       println(s"The teacher tax is ${personN3.taxToPay}%")

       val personN4 = new Person("Melany", "alliyah") with Student with Employee
       println(s"The student,employee tax is ${personN4.taxToPay}%")

       val personN5 = new Person("Aliska", "Gulersky") with Employee with Student
       println(s"Employee, student tax is ${personN5.taxToPay}%")


  }

  def workOrWeekend(day:String):String={
    /// task1
    val workDays:List[String] = List("Monday","Tuesday","Wednesday","Thursday","Friday")
    val weekendDays:List[String]=List("Saturday","Sunday")


   var valWorW:String= day match {
     case day:String if( workDays.contains(day)) =>  "work"
     case day:String if( weekendDays.contains(day)) => "weekend"
     case _ => "no such day"

   }

    return valWorW;

  }



  class BankAccount{
    /// task2
    private var balance = 0

    def deposit(amount: Int): Unit = {
      if (amount > 0) balance = balance + amount
    }

    def withdraw(amount: Int): Int = {
      if (0 < amount && amount <= balance) {
        balance = balance - amount
        balance
      } else

        println("insufficient funds")

      balance
    }

    override def toString = {
      "Your balance is $"+balance
    }

  }

  /// task 3
  case class Personx(val firstName:String,val lastName:String){}

  def greeting(person:Personx):String  = {

    val gr= person.lastName match {
      case lastname if(lastname.contains("Guler"))=>"Whats up "+person.firstName
      case lastname if(lastname.contains("B"))=>"hi "+person.firstName
      case _ => "Hello "+person.lastName

    }
    gr;
  }

  /// task4
  def task4(a:Int,f: (Int) => Int):Int={
    var x=a

    for (i <- 1 to 3) {
      x=f(x)
    }
    return x;
  }

  def double(num:Int):Int={
    num*2;
  }




}
