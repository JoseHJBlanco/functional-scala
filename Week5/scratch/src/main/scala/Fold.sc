def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( f(_) :: _ )

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( (x, y) => y + 1 )

val listo = "abcde".toList
lengthFun(listo)
lengthFun("".toList)

val listor = List(1, 2, 3, 4)
mapFun(listor, ( _ * 2 ))