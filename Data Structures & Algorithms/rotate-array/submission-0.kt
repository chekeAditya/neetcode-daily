class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        var modK = k % n
        var i = n - modK
        val arr1 = IntArray(modK)
        val arr2 = IntArray(n - modK)
        for (a in 0 until modK) {
            arr1[a] = nums[i]
            i++
        }

        for (a in 0 until n - modK) {
            arr2[a] = nums[a]
        }

        i = 0
        while (i < arr1.size) {
            nums[i] = arr1[i]
            i++
        }
        var j = 0
        while (j < arr2.size) {
            nums[i] = arr2[j]
            i++
            j++
        }
    }
}
