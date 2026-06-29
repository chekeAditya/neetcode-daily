class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val maxHeap = PriorityQueue<Pair<Char, Int>>(compareByDescending { it.second })
        if (a > 0) maxHeap.add(Pair('a', a))
        if (b > 0) maxHeap.add(Pair('b', b))
        if (c > 0) maxHeap.add(Pair('c', c))

        val res = StringBuilder()

        while (maxHeap.isNotEmpty()) {
            val first = maxHeap.poll()

            // If no second character available, append up to 2 char of the first character and then stop
            if (maxHeap.isEmpty()) {
                for (i in 0 until min(2, first.second)) {
                    res.append(first.first)
                }
                break
            }

            val second = maxHeap.poll()

            // If the first character is larger than the second use 2 copies of it to drain its count faster
            val firstCount = if (first.second > second.second) 2 else 1
            
            for (i in 0 until firstCount) {
                res.append(first.first)
            }

            res.append(second.first)

            if (first.second - firstCount > 0) {
                maxHeap.add(Pair(first.first, first.second - firstCount))
            }
            if (second.second - 1 > 0) {
                maxHeap.add(Pair(second.first, second.second - 1))
            }
        }

        return res.toString()
    }
}
