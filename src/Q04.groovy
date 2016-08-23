/**
 * @author crkimberley on 23/08/2016.
 */
Scanner input = new Scanner(System.in)
while (true) {
    print "Palindrome checker - enter text (q to quit): "
    String text = input.nextLine()
    if (text.charAt(0) == 'q' as char) {
        break
    }
    println text + " is " + (isPalindrome(text) ? "" : "not ") + "a palindrome"
}

boolean isPalindrome(String text) {
    if (text.length() < 2) {
        return true
    }
    if (text.charAt(0) != text.charAt(text.length() - 1)) {
        return false
    }
    isPalindrome(text.substring(1, text.length() - 1))
}