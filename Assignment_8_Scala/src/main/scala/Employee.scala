trait Employee extends Person {
  private[this] var _taxToPay: Double = 20

  override def taxToPay: Double = _taxToPay

  private def taxToPay_=(): Unit = {
    _taxToPay = _salary*0.2
  }

  private[this] var _salary: Double = 0


  def salary: Double = _salary

  def salary_=(value: Double): Unit = {
    _salary = value
  }



}
  