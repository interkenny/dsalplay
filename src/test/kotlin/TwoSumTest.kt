import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.pow
import kotlin.test.assertContentEquals

class TwoSumTest {
    val twoSum = TwoSum()

    @Test
    fun `numsLengthShouldLessThan10^4`() {
        val inputNums = IntArray((Math.pow(10.0, 4.0) + 1).toInt())
        assertThrows<IndexOutOfBoundsException> {
            twoSum.twoSum(inputNums, 0)
        }
    }

    @Test
    fun numsLengthShouldGreaterThan2() {
        val inputNums = IntArray(1)
        assertThrows<IndexOutOfBoundsException> {
            twoSum.twoSum(inputNums, 0)
        }
    }

    @Test
    fun `numAbsoluteValueShouldLessThan10^9`() {
        val inputNums = intArrayOf(
            1,
            10.0.pow(9.0).toInt().unaryMinus() - 1
        )
        assertThrows<IllegalArgumentException> {
            twoSum.twoSum(inputNums, 0)
        }
    }

    @Test
    fun `targetAbsoluteValueShouldLessThan10^9`() {
        val target = 10.0.pow(9.0).toInt().unaryMinus() - 1
        assertThrows<IllegalArgumentException> {
            twoSum.twoSum(IntArray(2), target)
        }
    }

    @Test
    fun shouldHas2itemsLessThanTarget() {
        val target = 10
        val inputNums = intArrayOf(
            4, 11, 12, 15
        )
        assertThrows<ArithmeticException> {
            twoSum.twoSum(inputNums, target)
        }
    }

    @Test
    fun onlyOneValidAnswerExists() {
        val inputNums = intArrayOf(
            2, 5, 5, 11, 5
        )
        val target = 10

        assertContentEquals(intArrayOf(1, 2), twoSum.twoSum(inputNums, target))
    }
}