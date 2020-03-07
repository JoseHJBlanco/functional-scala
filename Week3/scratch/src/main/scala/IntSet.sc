object session{
    abstract class IntSet {
        def incl(x: Int): IntSet
        def contains(x: Int): Boolean
        def union(other: IntSet): IntSet
    }

    object Empty extends IntSet{
        def contains(x: Int) = false
        def incl(x: Int) = new NonEmpty(x)
        def union(other: IntSet): IntSet = other
        override def toString = "."
    }

    class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
        def this(elem: Int) = this(elem, Empty, Empty)
        def contains(x: Int) = 
            if (x < elem) left contains x
            else if (x > elem) right contains x
            else true

        def incl(x: Int) = 
            if (x < elem) new NonEmpty(elem, left incl x, right)
            else if (x > elem) new NonEmpty(elem, left, right incl x)
            else this

        def union(other: IntSet): IntSet =
            right union left union other incl elem

        override def toString = "{" + left + elem + right + "}"
    }
}

val a = session.NonEmpty(3) incl 2 incl 5
val b = session.NonEmpty(4) incl 2
a union b