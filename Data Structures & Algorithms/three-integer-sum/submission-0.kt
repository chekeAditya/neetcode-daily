class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val ans = mutableListOf<List<Int>>()
        nums.sort() // Using Kotlin's built-in sort

        for (i in 0 until n) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var j = i + 1
            var k = n - 1

            while (j < k) {
                val total = nums[i] + nums[j] + nums[k]
                if (total > 0) {
                    k--
                } else if (total < 0) {
                    j++
                } else {
                    // Fixed: Added nums[k] instead of the second nums[j]
                    ans.add(listOf(nums[i], nums[j], nums[k]))
                    
                    j++
                    k-- // Fixed: Move both pointers when a match is found
                    
                    // Skip duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) j++
                    
                    // Skip duplicates for k as well to be safe and fast
                    while (j < k && nums[k] == nums[k + 1]) k--
                }
            }
        }
        return ans
    }
}
