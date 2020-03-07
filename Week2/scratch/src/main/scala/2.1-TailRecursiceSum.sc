def product(f: Int => Int)(a: Int, b: Int): Int  = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, acc * f(a))
  }
  loop(a, 1)
}

def factorial(n: Int) = product(a => a)(1, n)

def accumulate(accFn: (Int, Int) => Int, init: Int)(fn: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = 
    if (a > b) acc
    else loop(a + 1, accFn(fn(a), acc))

  loop(a, init)
}

product(a => a)(1, 5)
factorial(5)
accumulate((a, b) => a * b, 1)(a => a, 1, 5)