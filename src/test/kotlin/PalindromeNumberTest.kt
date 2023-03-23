import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.pow
import kotlin.test.assertEquals

class PalindromeNumberTest {
    val solution = PalindromeNumber()

    @Test
    fun `numberShouldGreaterThan-2^31`() {
        val input = 2.0.pow(31.0).toInt().unaryMinus() - 1
        assertThrows<IllegalArgumentException> {
            solution.isPalindromeNumber(input)
        }
    }

    @Test
    fun `numberShouldLessThan2^31-1`() {
        val input = 2.0.pow(31.0).toInt()
        assertThrows<IllegalArgumentException> {
            solution.isPalindromeNumber(input)
        }
    }

    @Test
    fun numberShouldGreaterThan0() {
        val input = -1
        assertThrows<IllegalArgumentException> {
            solution.isPalindromeNumber(input)
        }
    }

    @Test
    fun lastNumberDigitShouldGreaterThan0() {
        val input = 110
        assertThrows<IllegalArgumentException> {
            solution.isPalindromeNumber(input)
        }
    }

    @Test
    fun isPalindromeNumber() {
        val input = 12321
        assertEquals(true, solution.isPalindromeNumber(input))
    }
}