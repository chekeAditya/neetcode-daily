class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHead = PriorityQueue<Int>()
        nums.forEach {
            minHead.add(it)
            if(minHead.size > k) minHead.poll()
        }

        return minHead.peek()
    }
}
