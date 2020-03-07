class Rational(n: Int, d: Int) {
    require(d != 0, "denominator must be nonzero")
    def this(n: Int) = this(n, 1)
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    def numer = n
    def denom = d
    
    def less(that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom
    
    def max(that: Rational): Rational = if (this.less(that)) that else this
    
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
                
    override def toString = {
        val g = gcd(n, d)
        numer / g + "/" + denom / g
    }
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
val strange = new Rational(3, 0)
x.sub(y).sub(z)