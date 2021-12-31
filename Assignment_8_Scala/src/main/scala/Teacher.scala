trait Teacher extends Employee {
  private[this] var _taxToPay: Double = 10

  override def taxToPay: Double = _taxToPay

  private def taxToPay_=(value: Int): Unit = {
    _taxToPay = value*0.1
  }

  var _salary: Double = 0

  override def salary: Double = _salary

  override def salary_=(value: Double): Unit = {
    _salary = value
  }


}
  