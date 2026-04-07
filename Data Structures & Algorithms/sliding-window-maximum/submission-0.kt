class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        if (n == 0) return IntArray(0)

        val result = IntArray(n - k + 1)
        val deque = ArrayDeque<Int>() // Stores indices, not the actual numbers

        for (i in nums.indices) {
            // Rule 1: Remove the index at the front if it is out of the current window
            if (deque.isNotEmpty() && deque.first() < i - k + 1) {
                deque.removeFirst()
            }

            // Rule 2: Remove indices from the back if their numbers are smaller than the current number
            while (deque.isNotEmpty() && nums[deque.last()] < nums[i]) {
                deque.removeLast()
            }

            // Rule 3: Add the current index to the back
            deque.addLast(i)

            // Once the window reaches size k, the front of the deque is the maximum
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.first()]
            }
        }

        return result
    }
}
