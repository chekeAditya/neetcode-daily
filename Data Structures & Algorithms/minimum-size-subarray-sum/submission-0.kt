class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var sum = 0
        var minSize = Int.MAX_VALUE

        for(r in nums.indices){
            sum += nums[r]

            // IMP : shrink window until sum comes below taget 
            while(sum >= target){
                minSize = min(minSize, r - l + 1)
                sum -= nums[l]
                l++
            }
        }
        return if(minSize == Int.MAX_VALUE) 0 else minSize
    }
}
