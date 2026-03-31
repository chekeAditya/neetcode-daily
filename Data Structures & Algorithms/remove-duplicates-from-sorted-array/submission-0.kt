class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        var j = 0
        while (j < n) {
            if (nums[i] == nums[j]) {
                j++
            } else {
                swap(nums, i + 1, j)
                i++
                j++
            }
        }
        return i + 1
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}
