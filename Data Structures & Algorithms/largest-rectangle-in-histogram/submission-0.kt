class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size
        val leftSmaller = IntArray(n)
        val rightSmaller = IntArray(n)
        val stack = Stack<Int>()
    
        // Find Nearest Smaller to the Right
        for (i in n - 1 downTo 0) {
            while (stack.isNotEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop()
            }
            // If no smaller element, the boundary is the end of the array (n)
            rightSmaller[i] = if (stack.isEmpty()) n else stack.peek()
            stack.push(i)
        }
    
        stack.clear()
    
        // Find Nearest Smaller to the Left
        for (i in 0 until n) {
            while (stack.isNotEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop()
            }
            // If no smaller element, the boundary is -1
            leftSmaller[i] = if (stack.isEmpty()) -1 else stack.peek()
            stack.push(i)
        }
    
        var ans = 0
        for (i in 0 until n) {
            val width = rightSmaller[i] - leftSmaller[i] - 1 // r - l + 1
            val currArea = heights[i] * width
            ans = max(currArea, ans)
        }
        return ans
    }
}
