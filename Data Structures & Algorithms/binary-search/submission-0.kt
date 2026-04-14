class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val n = nums.size
        var l = 0
        var r = n - 1

        while(l <= r){
            val mid = (r+l) / 2
            if(nums[mid] == target) return mid
            else if(nums[mid] < target) l = mid + 1
            else r = mid - 1
        }
        return -1
    }
}
