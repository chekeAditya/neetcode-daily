class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val ans = nums1.copyOf()

        var i = 0
        var j = 0
        var idx = 0
        while (i < m && j < n) {
            if (ans[i] < nums2[j]) {
                nums1[idx] = ans[i]
                i++
            } else {
                nums1[idx] = nums2[j]
                j++
            }
            idx++
        }

        while (i < m) {
            nums1[idx] = ans[i]
            i++
            idx++
        }

        while (j < n) {
            nums1[idx] = nums2[j]
            j++
            idx++
        }
    }
}
