class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        val n = nums.size
        var l = 0
        var r = n - 1
        while(l <= r){
            val mid = (l + r)/ 2
            if(nums[mid] == target) return true

            /*
            If the numbers at the left, middle, and right are identical, you shrink your search area. You do this by moving the left pointer forward by one and the right pointer backward by one. You keep doing this until the edges are different, and then your normal logic from the first part will work perfectly again.
            */
            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                l++
                r--
                continue
            }

            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1
                } else l = mid + 1
            } else {
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1
                } else r = mid - 1
            }
        }
        return false
    }
}
