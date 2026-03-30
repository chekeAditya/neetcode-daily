class Solution {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        if (map.size < k) return intArrayOf()
        // sort map based on it's value
        val sortedMap = map.entries.sortedBy { it.value }.associate { it.key to it.value }

        val res = IntArray(k)
        var index = 0

        for ((key, _) in sortedMap.entries.reversed().take(k)) {
            res[index] = key
            index++
        }

        return res
    }
}
