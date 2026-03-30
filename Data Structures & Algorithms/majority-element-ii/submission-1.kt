class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        val n = nums.size
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val occ = n / 3
        val list = ArrayList<Int>()
        for ((key, value) in map) {
            if (value > occ) list.add(key)
        }
        return list
    }
}
