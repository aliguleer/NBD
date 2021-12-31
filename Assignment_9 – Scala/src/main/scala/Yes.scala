class Yes[A](var value: A) extends Maybe[A]  {
  def applyFunction[R] (f: A => R) = f(value)
  def getOrElse(param: A) = value
}