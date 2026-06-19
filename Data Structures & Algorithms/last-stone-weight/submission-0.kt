class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        var ans = 0

        if (stones.size == 1) return stones[0]

        stones.forEach {
            maxHeap.add(it)
        }

        while (maxHeap.size > 1) {
            val stone1 = maxHeap.poll()
            val stone2 = maxHeap.poll()

            ans = stone1 - stone2

            maxHeap.add(ans)
        }

        return ans
    }
}
