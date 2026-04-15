class Solution {
    fun findMin(nums: IntArray): Int {
        val n = nums.size
        var l = 0
        var r = n-1
        var ans = Int.MAX_VALUE
        while(l <= r){
            val mid = (l + r) / 2
            // if left is smaller then right then it's sorted return left 
            if(nums[l] <= nums[r]){
                return min(ans, nums[l])
            }
            // if left is smaller then mid then keep left as smaller and move to right 
            if(nums[l] <= nums[mid]){
                ans = min(ans, nums[l])
                l = mid + 1
            } else {
                // if right side is bigger then simply move to left side
                ans = min(ans, nums[mid])
                r = mid - 1
            }
        }
        return ans
    }
}
