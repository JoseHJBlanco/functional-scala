def removeAt[T](xs: List[T], n: Int): List[T] = (xs take n) ++ (xs drop n + 1)

def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => Nil
    case head :: tail => head match {
        case l: List[Any] => flatten(l) ::: flatten(tail)
        case x => x :: flatten(tail)
    }

}

val xs = List(0, 1, 2, 3)
removeAt(xs, 2)

flatten(List(List(1, 1), 2, List(3, List(5, 8))))