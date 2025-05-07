package math
// https://leetcode.com/problems/reverse-integer/description/

class ReverseInteger {
    fun reverse(x: Int): Int {
        var y = x

        var result = y % 10
        y /= 10

        while (y != 0) {
            val digit = y % 10
            y /= 10

            if (result > Int.MAX_VALUE / 10
                || (result == Int.MAX_VALUE / 10 && digit > 7)) {
                return 0
            }

            if (result < Int.MIN_VALUE / 10
                || (result == Int.MIN_VALUE / 10 && digit < -8)) {
                return 0
            }

            result = result * 10 + digit
        }

        return result
    }
}

fun main() {
    val sol = ReverseInteger()
    println(sol.reverse(20))
}
