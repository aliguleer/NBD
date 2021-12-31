trait Student extends Person {
  private[this] var _taxToPay: Double = 0

  override def taxToPay: Double = _taxToPay


}
  