class Person(val firstName:String,val lastName:String) {
  private[this] var _taxToPay: Double = 0

  def taxToPay: Double = _taxToPay

  private def taxToPay_=(value: Int): Unit = {
    _taxToPay = value*0
  }

}




