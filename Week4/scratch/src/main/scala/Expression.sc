trait Expr

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Var(n: String) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Var(x) => x
    case Sum(l, r) => show(l) + " + " + show(r)
    case Prod(l: Sum, r: Sum) => "(" + show(l) + ")" + " * " + "(" + show(r) + ")"
    case Prod(l: Sum, r) => "(" + show(l) + ")" + " * " + show(r)
    case Prod(l, r: Sum) => show(l) + " * " + "(" + show(r) + ")"
    case Prod(l, r) => show(l) + " * " + show(r)
}

show(Prod(Sum(Number(1), Number(2)), Number(1)))
show(Prod(Number(2), Number(1)))