class Solution {
    fun mySqrt(x: Int): Int {
        var l: Long = 0
        var r: Long = x.toLong() // this part is important use long instead of int as storing int * int will be to huge so store it in long and return it in Int
        var ans = 0

        while (l <= r) {
            val mid: Long = (l + (r - l) / 2)
            val square = mid * mid
            if (square <= x) {
                ans = mid.toInt()
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return ans
    }
}
