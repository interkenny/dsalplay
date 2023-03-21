import kotlin.math.absoluteValue
import kotlin.math.pow

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size !in (2..10.0.pow(4.0).toInt())) throw IndexOutOfBoundsException()
        nums.forEach {
            if (it.absoluteValue > 10.0.pow(9.0).toInt()) throw IllegalArgumentException()
        }
        if (target.absoluteValue > 10.0.pow(9.0).toInt()) throw IllegalArgumentException()

        val checkInput = nums.filter { it <= target }
        if (checkInput.size < 2) throw ArithmeticException()

        /*        val resultMap = mutableMapOf<Int, Int>()
                nums.forEachIndexed { i, d ->
                    resultMap[d]?.let {
                        return intArrayOf(it, i)
                    }
                    resultMap[target - d] = i
                }*/
        val hash = HashMap<Int, Int>()
        hash[nums[0]] = 0
        for (i in 1 until nums.size) {
            hash[target - nums[i]]?.let { return intArrayOf(it, i) }
            hash[nums[i]] = i
        }
        return intArrayOf()
    }
}