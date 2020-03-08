# Reasoning about concat

## `Concat` definition

```scala
def concat[T](xs: List[T], ys: List[T]) = xs match {
    case Nil => ys
    case head :: tail => head :: concat(tail, ys)
}
```


## Property

```scala
xs ++ Nil = xs
```

## Proof

### Base case
```scala
xs ++ Nil = xs
Nil ++ Nil = Nil
(Nil ++ ys) = ys => Nil = Nil
xs == Nil == Nil
```

### Induction

```scala
xs = x :: xs1 = x :: Nil

(x :: xs1) ++ Nil = xs
= x :: (xs1 ++ Nil) \\ 2nd clause
= x :: Nil = xs
```