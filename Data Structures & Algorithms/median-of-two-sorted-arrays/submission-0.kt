class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        val array = IntArray(m + n)
        var index = 0
        var l1 = 0
        var l2 = 0
        while (l1 < m && l2 < n) {
            if (nums1[l1] < nums2[l2]) {
                array[index] = nums1[l1]
                l1++
            } else {
                array[index] = nums2[l2]
                l2++
            }
            index++
        }

        while (l1 < m) {
            array[index] = nums1[l1]
            l1++
            index++
        }

        while (l2 < n) {
            array[index] = nums2[l2]
            l2++
            index++
        }
        println(array)
        val k = array.size
        if (k == 1) return array[0].toDouble()
        return if (k % 2 == 0) {
            val first = array[k / 2]
            val second = array[(k / 2) - 1]
            println("$first and $second")
            (first.toDouble() + second.toDouble()) / 2
        } else array[k / 2].toDouble()
    }
}
