class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numsSet = HashSet<Int>(nums.size * 2)
        for (i in nums.indices) {
            if (!numsSet.add(nums[i])) return true
        }
        return false
    }
}
