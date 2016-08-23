/**
 * @author crkimberley on 23/08/2016.
 */
Scanner input = new Scanner(System.in)
while (true) {
    println "Power calculator (-1 to quit)"
    print "Enter base: "
    int base = input.nextInt()
    if (base == -1) {
        break
    }
    print "Enter exponent: "
    int exponent = input.nextInt()
    print base + " to the power of " + exponent + " = " + pow(base, exponent)
    println "\t\t(iterative method) " + powIterative(base, exponent)
    println()
}

int pow(int base, int exponent) {
    if (exponent == 0) {
        return 1
    }
    return base * pow(base, exponent - 1)
}

int powIterative(int base, int exponent) {
    int result = 1
    for (int i=0; i<exponent; i++) {
        result = result * base
    }
    return result
}