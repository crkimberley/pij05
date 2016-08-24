/**
 * @author crkimberley on 24/08/2016.
 */
// Greatest Common Divisor
// if p > q, then gcd(p,q) = gcd(q,p mod q)

Scanner input = new Scanner(System.in)
while (true) {
    println "Greatest Common Divisor calculator (0 to exit)"
    print "Enter larger number: "
    int p = input.nextInt()
    if (p == 0) {
        break
    }
    print "Enter smaller number: "
    int q = input.nextInt()
    println "Greatest Common Divisor of " + p + " & " + q + " = " + gcd(p, q)
}

int gcd(int p, int q) {
    if (p % q == 0) {
        return q
    }
    return gcd(q, p % q)
}