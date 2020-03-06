def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: _ => {
      val (x1, x2) = xs.span(y => y == x)
      x1 :: pack(x2)
    }
}

def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))



pack(List("a", "a", "a", "b", "c", "c", "a"))
encode(List("a", "a", "a", "b", "c", "c", "a"))
encode(Nil)