package problems.container_with_most_water

fun main() {
    println(Solution().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))) // 49
    println(Solution().maxArea(intArrayOf(8, 20, 1, 2, 3, 4, 5, 6))) // 42
    println(Solution().maxArea(intArrayOf(2, 3, 4, 5, 18, 17, 6))) // 17
    println(Solution().maxArea(intArrayOf(1, 2, 4, 3))) // 4
    println(Solution().maxArea(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))) // 25
    println(Solution().maxArea(((0..10000) + (9999 downTo 0)).toIntArray())) // 50000000
}

class Solution {
    fun maxArea(height: IntArray): Int {
        var startIndex = 0
        var endIndex = height.size - 1
        var maxArea = endIndex * minOf(height[startIndex], height[endIndex])
        while (endIndex - startIndex > 1) {
            if (height[startIndex] <= height[endIndex]) {
                val newArea = (endIndex - startIndex - 1) * minOf(height[startIndex + 1], height[endIndex])
                if (maxArea < newArea) maxArea = newArea
                startIndex++
            } else {
                val newArea = (endIndex - startIndex - 1) * minOf(height[endIndex - 1], height[startIndex])
                if (maxArea < newArea) maxArea = newArea
                endIndex--
            }
        }
        return maxArea
    }
}

