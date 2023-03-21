import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertContentEquals

class RunningSumTest {

    val runningSum = RunningSum()

    @Test
    fun lengthShouldLessThan1000() {
        val inputArray = IntArray(2000)
        assertThrows<IndexOutOfBoundsException> {
            runningSum.obtainedArray(inputArray)
        }
    }

    @Test
    fun lengthShouldMoreThan1() {
        val inputArray = emptyArray<Int>()
        assertThrows<IndexOutOfBoundsException> {
            runningSum.obtainedArray(inputArray.toIntArray())
        }
    }

    @Test
    fun `absoluteValueShouldLessThan10^6`() {
        val inputArray = intArrayOf(
            0,
            Math.pow(10.0, 6.0).toInt(),
            Math.pow(-10.0, 6.0).toInt()
        )
        assertDoesNotThrow {
            runningSum.obtainedArray(inputArray)
        }
    }

    @Test
    fun `failedAbsoluteValueMoreThan10^6`() {
        val inputArray = intArrayOf(
            0,
            Math.pow(10.0, 6.0).toInt().unaryMinus() - 1
        )
        assertThrows<IllegalArgumentException> {
            runningSum.obtainedArray(inputArray)
        }
    }

    @Test
    fun shouldRetrunRunningSums() {
        val inputArray = intArrayOf(3, 1, 2, 10, 1)
        val result = runningSum.obtainedArray(inputArray)
        assertContentEquals(intArrayOf(3, 4, 6, 16, 17), result)
    }
}