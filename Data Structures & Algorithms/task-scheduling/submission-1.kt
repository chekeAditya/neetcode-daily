class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        // store char freq in int array
        val freqArray = IntArray(26)
        for (ch in tasks) {
            freqArray[ch - 'A']++
        }

        // if freq > 0 then add it into maxHeap
        val pq = PriorityQueue<Int>(compareByDescending { it })
        freqArray.forEach {
            if (it > 0) pq.add(it)
        }

        // time taken
        var time = 0
        // if pq is not empty then pick with most freq and add it to list, then uski freq kaam kardo aur fir usse vapas pq mai add kardo agar uski freq > 0 hai tho,
        // last mai time calculate karlo, agar pq empty hogaya tho list mai item present + kitna time idle raha is the answer
        while (pq.isNotEmpty()) {
            val list = arrayListOf<Int>()
            for (i in 1..n + 1) {
                if (pq.isNotEmpty()) {
                    var currentFreq = pq.poll()
                    list.add(--currentFreq)
                }
            }

            for (f in list) {
                if (f > 0) pq.offer(f)
            }

            time += if (pq.isEmpty()) {
                list.size
            } else {
                n + 1
            }
        }

        return time
    }
}
