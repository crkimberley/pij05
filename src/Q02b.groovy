/**
 * @author crkimberley on 13/08/2016.
 */
int fibonacci(int n) {
    if (n == 1 || n == 2) {
        return 1
    } else {
        return fibonacci(n-1) + fibonacci(n-2)
    }
}

int fibonacciIterative(int n) {
    int prevPrevElement = 0
    int prevElement = 1
    int currentElement = 1
    for (int i = 2; i<=n; i++) {
        currentElement = prevElement + prevPrevElement
        prevPrevElement = prevElement
        prevElement = currentElement
    }
    return currentElement
}

Scanner input = new Scanner(System.in)
while (true) {
    print "Fibonacci calculator - enter n (0 to exit): "
    int n = input.nextInt()
    if (n == 0) {
        break
    }
    println fibonacci(n) + " (recursive)"
    println fibonacciIterative(n) + " (iterative)"
}