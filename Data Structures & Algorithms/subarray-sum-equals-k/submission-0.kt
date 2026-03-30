class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixCount = mutableMapOf(0 to 1)  // base case
        var sum = 0
        var count = 0
        
        for (num in nums) {
            sum += num
            // How many earlier prefixes give us a valid subarray ending here?
            count += prefixCount.getOrDefault(sum - k, 0)
            // Record this prefix sum
            prefixCount[sum] = prefixCount.getOrDefault(sum, 0) + 1
        }
        
        return count
    }
}
