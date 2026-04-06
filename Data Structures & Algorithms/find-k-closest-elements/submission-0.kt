class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val n = arr.size
        val list = ArrayList<Int>()

        // Solution 1 : you can solve this question using binary search where you'll find the closest number to x and then put both the pointer on left and right side, add it into list, and if both are equal then priority goes to a and add till k elements

        // Solution 2 : create a window which start from 0 to n - k, and then mid will be on the left side and right pointer will be at mid + k, and if this window is closer to 'x' then add it into list if not and if right pointer is closer to 'x' then move window to right side else move it to left side

        var l = 0
        var r = n - k
        while (l < r) {
            val mid = (l + r) / 2
            if (x - arr[mid] > arr[mid + k] - x) l = mid + 1
            else r = mid
        }
        list.addAll(arr.slice(l until l + k)) // adding element to the list
        return list
    }
}
