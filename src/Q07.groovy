/**
 * @author crkimberley on 17/08/2016.
 */
// Hanoi Redux: even-numbered discs are on the leftmost post while the odd-numbered discs are on the rightmost post
// Method calculates the number of moves necessary to exchange n discs
//
// Can't be certain (without attempting some kind of proof) that it will be the minimum of moves
//
// n-1 discs from L & R posts are moved to middle post
// then the largest disc can be moved from L to the empty R post
// then even discs are moved to R post and odd discs to L post - reverse of stacking moves (same number of moves)
// total moves = 2 * minimum moves to stack n-1 on middle + 1 to move largest disc
//
// Algorithm to calculate moves is not as simple as the basic Hanoi Towers arrangement
// Sequence of 8 steps is repeated.
// Calculation in method is based on 2nd set of moves as follows...
// (moves would be same number in reverse for 1st set)...
//
// n-2 discs from middle stack -> right     H(n-2)
// single middle disc -> left               1
// n-4 discs from right stack -> middle     H(n-4)
// top right disc -> left                   1
// n-5 discs from middle stack -> left      H(n-5)
// single middle disc -> right              1
// n-7 discs from left stack -> middle      H(n-7)
// top left disc -> right                   1
//
// then
// n-8 discs from middle stack -> right     H(n-8)
// single middle disc -> left
// n-10 discs from right stack -> middle    H(n-10)
// etc.
//
// Last few moves are slightly different for 3 cases...
// n = 6, 12...
// stop when n-x = 1 and add 2 to cumulative result
// final move is single middle disc -> right
// n = 8, 14... and n = 10, 16...
// // stop when n-x = 0 and add 1 to cumulative result
// n = 8, 14... final move: single middle disc -> left (rather than -> right)
// n = 10, 16... final move: top right disc -> left (rather than -> middle)

Scanner input = new Scanner(System.in)
while (true) {
    println "Hanoi Towers Redux - swap even discs on left tower with odd discs on right tower"
    print "Number of moves calculator - enter an even number of discs (0 to exit): "
    numberOfDiscs = input.nextInt()
    if (numberOfDiscs == 0) {
        break
    }
    println "Minimum number of moves = " + hanoiReduxMoves(numberOfDiscs)
}

int hanoiReduxMoves(int n) {
    // result variable is for calculating one set of moves
    // total is 2 * result + 1
    int result = 0
    int x = 2
    int step = 1
    // calculation is slightly different when n is a multiple of 6
    boolean numberOfDiscsIsAMultipleOf6 = (n % 6 == 0)
    while (true) {
        if ((numberOfDiscsIsAMultipleOf6 && n - x == 1) || (!numberOfDiscsIsAMultipleOf6 && n - x == 0)) {
            return 2 * (result + (numberOfDiscsIsAMultipleOf6 ? 2 : 1)) + 1
        } else {
            result = result + (hanoiMoves(n - x) + 1)
        }
        step++
        // number of moves in a group move decreases (n - x)
        // with x increasing by 2, 1, 2, 1...
        x = x + (step % 2 == 0 ? 2 : 1)
    }
}

long hanoiMoves(int n) {
    if (n == 1) {
        return 1
    } else {
        return 2 * hanoiMoves(n-1) + 1
    }
}