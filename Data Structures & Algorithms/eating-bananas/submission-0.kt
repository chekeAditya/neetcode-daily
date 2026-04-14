class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var result = Int.MAX_VALUE
        var l = 1
        var r = piles.max()
        while (l <= r) {
            val mid = l + (r - l) / 2
            val timeTaken = timeTakenToEat(mid, piles)
            if (timeTaken <= h) {
                result = min(result, mid)
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return result
    }
    
    private fun timeTakenToEat(k: Int, arr: IntArray): Int {
        var timeTaken = 0.0
        for (i in arr) timeTaken += ceil(i.toDouble() / k)
        return timeTaken.toInt()
    }
}
