class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size

        // mai binary search yaha chote size of array pe lagaunga, coz faster result milega, so agar m chota then mai vapas same function call krdunga value swap krke
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1)
        }

        // binary search jo small array h
        var l = 0
        var r = m
        while (l <= r) {
            val Px = l + (r - l) / 2 // nums1 mai humme kitne element lena hai, aur ye mid hota tha
            val Py = (m + n + 1) / 2 - Px // left side mai kitne element lene hai, from nums2

            // left half
            val x1 = if (Px == 0) Int.MIN_VALUE else nums1[Px - 1]
            val x2 = if (Py == 0) Int.MIN_VALUE else nums2[Py - 1]

            // right half
            val x3 = if (Px == m) Int.MAX_VALUE else nums1[Px]
            val x4 = if (Py == n) Int.MAX_VALUE else nums2[Py]

            if (x1 <= x4 && x2 <= x3) {
                // odd number of element hai
                if ((m + n) % 2 == 1) {
                    return maxOf(x1, x2).toDouble() 
                }
                // even number of elements
                return (maxOf(x1, x2) + minOf(x3, x4)) / 2.0
            }

            if (x1 > x4) {
                r = Px - 1
            } else {
                l = Px + 1
            }
        }
        return -1.0
    }
}
