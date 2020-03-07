package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def isEdge(c: Int, r: Int): Boolean = {
      c == 0 || c == r
    }

    def computeElement(c: Int, r: Int): Int = {
      if (isEdge(c, r)) 1
      else computeElement(c - 1, r - 1) + computeElement(c, r - 1)
    }

    computeElement(c, r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def stop(chars: List[Char], open: Int): Boolean = {
      chars.isEmpty || open < 0
    }

    def adjustBalance(char: Char): Int = {
      if (char == '(') 1
      else if (char == ')') -1
      else 0
    }

    def computeBalance(chars: List[Char], open: Int = 0): Int = {
      if (stop(chars, open)) open
      else computeBalance(chars.tail, open + adjustBalance(chars.head))
    }

    computeBalance(chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeIter(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money < 0 || coins.isEmpty) 0
      else countChangeIter(money - coins.head, coins) + countChangeIter(money, coins.tail)
    }
    countChangeIter(money, coins)
  }
}
