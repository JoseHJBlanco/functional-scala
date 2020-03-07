trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
    def nth(n: Int): T
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: Boolean = false
    def nth(n: Int): T =
        if (n == 0) this.head
        else if(n < 0) throw new IndexOutOfBoundsException("Out of bounds.")
        else tail.nth(n - 1)

    override def toString: String = "[" + this.head + ", " + this.tail + "]"
}

class Nil[T] extends List[T] {
    def isEmpty: Boolean = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
    def nth(n: Int) = throw new IndexOutOfBoundsException("Out of bounds.")
    override def toString: String = "Nil"
}

val a = new Cons(1, new Cons(2, new Cons(3, new Nil)))
a.nth(2)