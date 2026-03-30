class Solution {
    fun sortColors(nums: IntArray): Unit {
        var i = 0      // Boundary for 0s
        var j = 0      // Current element being inspected
        var k = nums.size - 1 // Boundary for 2s

        while (j <= k) {
            when (nums[j]) {
                0 -> {
                    swap(nums, i, j)
                    i++
                    j++ // You must increment j here as well
                }
                1 -> {
                    j++
                }
                else -> { 
                    swap(nums, j, k)
                    k--
                }
            }
        }
    }

    private fun swap(nums: IntArray, first: Int, second: Int) {
        val temp = nums[first]
        nums[first] = nums[second]
        nums[second] = temp
    }
}
