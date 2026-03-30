class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val PS = IntArray(n)
        val SS = IntArray(n)
        PS[0] = 1
        SS[n - 1] = 1

        for (i in 1 until n) {
            PS[i] = PS[i - 1] * nums[i-1]
        }
        for (i in n - 2 downTo 0) {
            SS[i] = nums[i+1] * SS[i + 1]
        }

        for (i in 0 until n) {
            nums[i] = PS[i] * SS[i]
        }

        return nums
    }
}
