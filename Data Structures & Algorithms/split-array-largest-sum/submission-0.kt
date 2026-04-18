class Solution {
    fun splitArray(nums: IntArray, k: Int): Int {
        var l = nums.maxOrNull() ?: 0
        var r = nums.sum()

        var result = r
        while (l <= r) {
            val mid = l + (r - l) / 2
            // canSplit check karta hai ki kya hum array ko k parts mein 
            // divide kar sakte hain jisme koi bhi sum mid se bada na ho
            if (canSplit(nums, k, mid)) {
                result = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return result
    }

    private fun canSplit(nums: IntArray, k: Int, maxSum: Int): Boolean {
        var subArrayCount = 1
        var currSum = 0
        
        for (n in nums) {
            if (currSum + n > maxSum) {
                // Naya subarray start karna padega
                subArrayCount += 1
                currSum = n
            } else {
                currSum += n
            }
        }
        return subArrayCount <= k
    }
}
