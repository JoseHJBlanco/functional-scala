object List {
    def List[T](): List[T] = List()
    def List[T](a: T): List[T] = List(a)
    def List[T](a: T, b: T): List[T] = List(a, b)

    List()
}