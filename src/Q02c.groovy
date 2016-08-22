/**
 * @author crkimberley on 14/08/2016.
 */
// Hanoi towers - number of moves necessary for n discs
// Move n-1 discs, move nth (biggest) disc, move n-1 discs again
// Therefore number of moves = 2 * fib(n-1) + 1
//
// (Minimum number should be (2 to the n) - 1)

long hanoiMoves(int n) {
    if (n == 1) {
        return 1
    } else {
        return 2 * hanoiMoves(n-1) + 1
    }
}

Scanner input = new Scanner(System.in)
while (true) {
    print "Hanoi Towers - number of moves calculator - enter number of discs (0 to exit): "
    int n = input.nextInt()
    if (n == 0) {
        break
    }
    println "Minimum number of moves = " + hanoiMoves(n)
}