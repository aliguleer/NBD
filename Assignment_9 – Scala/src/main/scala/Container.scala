class Container[A](private val value: A) {

  def getContent() : A = {
    value
  }

  def applyFunction[R](f: A => R): R = {
    f(getContent())
  }
}