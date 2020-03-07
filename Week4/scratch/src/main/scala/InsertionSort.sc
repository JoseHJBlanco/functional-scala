object sortedLists {
    def isort(xs: List[Int]): List[Int] = xs match {
        case List() => List()
        case y :: ys => insert(y, isort(ys))
    }

    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
        case List() => List(x)
        case y :: ys => 
            if (x <= y) x :: xs
            else y :: insert(x, ys)
        
    }
}

sortedLists.isort(List(2, 3, 7, 6, 5, 9))

1 :: List(1, 2) :: Nil