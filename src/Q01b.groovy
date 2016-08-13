/**
 * @author crkimberley on 13/08/2016.
 */
// Corrected buggy code in question. Stack overflow for odd values of n until I replaced n == 0 with n <= 0
String buggyMethod(int n) {
    if (n <= 0) {
        return ""
    }
    return n + " " + buggyMethod(n - 2)
}

println buggyMethod(9)