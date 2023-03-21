import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {
    @Test
    fun shouldMultiply2By2() {
        val calculator = Calculator()
        val result = calculator.parse("2 * 2")
        assertEquals(4, result)
    }

    @Test
    fun shouldDivide2By2() {
        val calculator = Calculator()
        val result = calculator.parse("4 / 2")
        assertEquals(2, result)
    }
}