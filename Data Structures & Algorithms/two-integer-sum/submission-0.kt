class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in 0 until nums.size) {
            val element = target - nums[i]
            if (map.contains(element)) return intArrayOf(map[element] ?: 0, i)
            else map[nums[i]] = i
        }
        return intArrayOf()
    }
}
