/**
 * @author crkimberley on 13/08/2016.
 */
int factorial(int n) {
    if (n == 1) {
        return 1
    } else {
        return n * factorial(n - 1)
    }
}

Scanner input = new Scanner(System.in)
while (true) {
    print "Factorial calculator - enter n (0 to exit): "
    int n = input.nextInt()
    if (n == 0) {
        break
    }
    println factorial(n)
}