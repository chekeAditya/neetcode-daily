class Solution {
    fun reorganizeString(s: String): String {
        val count = IntArray(26)
        val n = s.length

        for (ch in s) {
            count[ch - 'a']++
            if (count[ch - 'a'] > (n + 1) / 2) return ""
        }

        val maxHeap = PriorityQueue<Pair<Int, Char>>(compareByDescending { it.first })

        for (i in 0 until 26) {
            if (count[i] > 0) {
                maxHeap.add(Pair(count[i], ('a' + i)))
            }
        }

        val res = StringBuilder()

        // put two different characters at a time to ensure no two adjacent are the same
        while (maxHeap.size >= 2) {
            val data1 = maxHeap.poll()
            val data2 = maxHeap.poll()

            res.append(data1.second)
            res.append(data2.second)

            if (data1.first - 1 > 0) {
                maxHeap.add(Pair(data1.first - 1, data1.second))
            }

            if (data2.first - 1 > 0) {
                maxHeap.add(Pair(data2.first - 1, data2.second))
            }
        }

        if (maxHeap.isNotEmpty()) {
            res.append(maxHeap.poll().second) // if there is one character left, append it to the end
        }
        
        return res.toString()
    }
}
