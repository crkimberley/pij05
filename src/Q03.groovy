import static java.lang.Math.pow

/**
 * @author crkimberley on 23/08/2016.
 */
Scanner input = new Scanner(System.in)
while (true) {
    print "Enter paper size, eg A4 (q to exit): "
    String areaString = input.next()
    if (areaString.charAt(0) == 'q' as char) {
        break
    }
    double area
    if (areaString.charAt(1) == '0' as char) {
        area = areaString.length() - 1
    } else {
        int sizeNumber = Integer.parseInt(areaString.substring(1))
        area = pow(2, -sizeNumber)
    }
    println "Area = " + area + "sq.m"
    println "Long side = " + longSide(area) + "mm"
    println "Short side = " + shortSide(area) + "mm"
    println()
}

int longSide(double area) {
    if (area == 1) {
        return 1189
    } else {
        return area > 1 ? 2 * shortSide(area / 2) : shortSide(area * 2)
    }
}

int shortSide(double area) {
    if (area == 1) {
        return 841
    } else {
        return area > 1 ? longSide(area / 2) : longSide(area * 2) / 2
    }
}