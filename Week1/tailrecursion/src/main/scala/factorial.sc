def regFactorial(n: Int): Int = {
    if (n == 0) 1 else n * regFactorial(n - 1)
}

def tailFactorial(n: Int): Int = {
    val acc: Int = 1

    def tailFactorialIter(n: Int, acc: Int): Int = {
        if (n == 0) acc else tailFactorialIter(n=n - 1, acc=n * acc)
    }
    tailFactorialIter(n, acc)
}
tailFactorial(5)