import math.abs

def fixedPoint(f: Double => Double)(x: Double): Double = {
    val tolerance = 0.00001
    def loop(guess: Double): Double = {
        val next = f(guess)
        if (closeEnough(next, guess)) next
        else loop(next)
    }

    def closeEnough(x: Double, y: Double): Boolean = 
        abs((x - y) / x) < tolerance

    loop(x)
}

def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y))(x)

sqrt(2)
