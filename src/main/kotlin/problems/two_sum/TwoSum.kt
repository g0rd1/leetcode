package problems.two_sum

fun main() {
    println(Solution().twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString()) // 0, 1
    println(Solution().twoSum(intArrayOf(3, 2, 4), 6).joinToString()) // 1, 2
    println(Solution().twoSum(intArrayOf(3, 3), 6).joinToString()) // 0, 1
    println(Solution().twoSum(intArrayOf(0, 4, 3, 0), 0).joinToString()) // 0, 3
    println(Solution().twoSum(intArrayOf(-3, 4, 3, 90), 0).joinToString()) // 0, 2
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val pairNumberToIndex = mutableMapOf<Int, Int>()
        nums.forEachIndexed { numIndex, num ->
            val nullableIndex = pairNumberToIndex[num]
            if (nullableIndex != null) return intArrayOf(nullableIndex, numIndex)
            pairNumberToIndex[target - num] = numIndex
        }
        error("No solution")
    }
}