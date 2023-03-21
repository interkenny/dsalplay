import kotlin.math.absoluteValue

class RunningSum {

    fun obtainedArray(inputArray: IntArray): IntArray {
        if (inputArray.size !in (1..1000)) throw IndexOutOfBoundsException()
        val valueCheckList = inputArray.filter {
            it.absoluteValue > Math.pow(10.0, 6.0)
        }
        if (valueCheckList.isNotEmpty()) throw IllegalArgumentException()

        // over kotlin 1.4
        // val result = inputArray.runningReduce { acc, i -> acc + i }

        // kotlin method
        /* val result = inputArray.mapIndexed { index, value ->
            inputArray.asList().subList(0, index + 1).toIntArray().sum()
        }*/

        for (i in 1 until inputArray.size) {
            inputArray[i] += inputArray[i - 1]
        }

        println("result: ${inputArray}")

        return inputArray
    }
}