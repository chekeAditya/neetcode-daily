class Solution {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val n = tasks.size
        val sortedTasks = Array(n) { IntArray(3) }
        
        // hume index return karna hai islia hum new array banare hai jismai index bhi hoga
        tasks.forEachIndexed { index, ints ->
            val startTime = ints[0]
            val processingTime = ints[1]
            sortedTasks[index] = intArrayOf(startTime, processingTime, index)
        }

        sortedTasks.sortBy { it[0] } 

        val result = arrayListOf<Int>()

        var currentTime = 0
        var idx = 0
        
        // Added a tie-breaker so if processing times (it.first) match, it checks the index (it.second)
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }) // min heap

        while (pq.isNotEmpty() || idx < n) {

            // agar tasks ka first time jayada ho then hum apne currentTime ko bhi update kar denge
            if (pq.isEmpty() && currentTime < sortedTasks[idx][0])
                currentTime = sortedTasks[idx][0]

            // agar task time is smaller then current time then hum usse apn PQ mai store kr lenge
            // Corrected Fix: Changed condition to <= so it grabs tasks that have already arrived
            while (idx < n && sortedTasks[idx][0] <= currentTime) {
                pq.offer(Pair(sortedTasks[idx][1], sortedTasks[idx][2])) // storing processing time and index
                idx++
            }

            val currTask = pq.poll()
            currentTime += currTask?.first ?: 0
            
            // Corrected Fix: Handled potential nullability check cleanly
            currTask?.let {
                result.add(it.second)
            }
        }

        return result.toIntArray()
    }
}
