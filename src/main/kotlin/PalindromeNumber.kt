import kotlin.math.pow

class PalindromeNumber {
    fun isPalindromeNumber(x: Int): Boolean {
        if (x < 2.0.pow(31.0).toInt().unaryMinus()) throw IllegalArgumentException()
        if (x >= 2.0.pow(31.0).toInt()) throw IllegalArgumentException()
        if (x < 0 || (x != 0 && x % 10 == 0)) throw IllegalArgumentException()

        // kotlin like
        // x.toString().let { return it == it.reversed() }

        var reversed = 0
        var original = x
        while (original > 0) {
            val digit = original % 10
            reversed = reversed * 10 + digit
            original /= 10
        }
        return reversed == x
    }
}