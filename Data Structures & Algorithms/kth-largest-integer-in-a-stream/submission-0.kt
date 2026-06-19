class KthLargest(k: Int, nums: IntArray) {

    private val pq = PriorityQueue<Int>()
    private val maxSize = k

    init {
        nums.forEach {
            pq.add(it)
            if (pq.size > maxSize) pq.poll()
        }
    }

    fun add(`val`: Int): Int {
        pq.add(`val`)
        if (pq.size > maxSize) pq.poll()
        return pq.peek()
    }
}
