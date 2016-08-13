/**
 * @author crkimberley on 13/08/2016.
 */
void printNumbers(int n) {
    if (n <= 0) {
        return
    }
    println n
    printNumbers(n-2)
    printNumbers(n-3)
    println n
}

printNumbers(6)