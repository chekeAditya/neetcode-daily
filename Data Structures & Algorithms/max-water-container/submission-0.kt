class Solution {
    fun maxArea(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        var j = n-1
        var maxHeight = 0
        var height = 0
        while(i < j) {
            height = (j - i) * min(nums[j], nums[i])
            if(nums[i] > nums[j]) {
                j--
            } else {
                i++
            }
            maxHeight = max(maxHeight, height)
        }
        return maxHeight
    }
}
