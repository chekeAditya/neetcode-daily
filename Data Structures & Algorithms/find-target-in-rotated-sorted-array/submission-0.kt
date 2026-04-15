class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val n = nums.size
        var l = 0
        var r = n - 1
        while (l <= r) {
            val mid = (l + r) / 2
            if (nums[mid] == target) return mid
            // left side is sorted
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) r = mid - 1
                else l = mid + 1
            } else {
                if (target > nums[mid] && target <= nums[r]) l = mid + 1
                else r = mid - 1
            }
    
        }
        return -1
    }
}
