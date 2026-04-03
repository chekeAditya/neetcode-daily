class Solution {
    fun trap(height: IntArray): Int {
        val leftMax = getLeftMax(height)
        val rightMax = getRightMax(height)
        var sum = 0
        for(i in 0 until height.size){
            val h = min(leftMax[i], rightMax[i]) - height[i]
            sum += h
        }
        return sum
    }

    fun getLeftMax(height: IntArray): IntArray {
        val leftMax = IntArray(height.size)
        leftMax[0] = height[0]
        for (i in 1 until height.size) {
            leftMax[i] = max(leftMax[i-1], height[i])
        }
        println(leftMax.contentToString())
        return leftMax
    }

    fun getRightMax(height: IntArray): IntArray {
        val rightMax = IntArray(height.size)
        val n = height.size
        rightMax[n - 1] = height[n - 1]
        for (i in n-2 downTo 0) {
            rightMax[i] = max(rightMax[i+1], height[i])
        }
        println(rightMax.contentToString())
        return rightMax
    }
}
