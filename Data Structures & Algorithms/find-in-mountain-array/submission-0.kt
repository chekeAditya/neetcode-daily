/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     fun get(index: Int): Int
 *     fun length(): Int
 * }
 */

class Solution {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        val n = mountainArr.length()
        val peakIndex = findPeak(mountainArr)
        
        // search in ascending (0 to peakIndex)
        val firstTry = binarySearch(mountainArr, 0, peakIndex, target)
        if (firstTry != -1) return firstTry
        
        // search in descending (peakIndex + 1 to n - 1)
        return reverseBinarySearch(mountainArr, peakIndex + 1, n - 1, target)
    }
    
    private fun findPeak(mountainArr: MountainArray): Int {
        var l = 0
        var r = mountainArr.length() - 1
        while (l < r) {
            val mid = l + (r - l) / 2
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return l
    }
    
    private fun binarySearch(mountainArr: MountainArray, start: Int, end: Int, target: Int): Int {
        var l = start
        var r = end
        while (l <= r) {
            val mid = l + (r - l) / 2
            val curr = mountainArr.get(mid)
            if (curr == target) return mid
            else if (curr < target) l = mid + 1
            else r = mid - 1
        }
        return -1
    }
    
    private fun reverseBinarySearch(mountainArr: MountainArray, start: Int, end: Int, target: Int): Int {
        var l = start
        var r = end
        while (l <= r) {
            val mid = l + (r - l) / 2
            val curr = mountainArr.get(mid)
            if (curr == target) return mid
            else if (curr < target) r = mid - 1
            else l = mid + 1
        }
        return -1
    }
}
