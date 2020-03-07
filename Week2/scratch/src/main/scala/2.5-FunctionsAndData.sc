class Rational(n: Int, d: Int) {
    def numer = n
    def denom = d

    def neg = new Rational(-numer, denom)

    def add(that: Rational): Rational = {
        new Rational(
            numer * that.denom + that.numer * denom,
            denom * that.denom
        )
    }

    def sub(that: Rational): Rational = {
        add(that.neg)
    }

    override def toString = numer + "/" + denom
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.sub(y).sub(z)