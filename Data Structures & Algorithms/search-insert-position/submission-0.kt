class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        val n = nums.size
        var l = 0
        var r = n - 1
        var ans = n // this is imp here, keep ans value as size of array, if item is greater then n-1 then we've to insert at the end of the array

        while (l <= r) {
            val mid = (r + l) / 2
            if (nums[mid] >= target) {
                ans = mid
                r = mid - 1
            } else l = mid + 1
        }
        return ans
    }
}
