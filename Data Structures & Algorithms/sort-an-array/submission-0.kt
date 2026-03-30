class Solution {
    fun sortArray(nums: IntArray): IntArray {
        if (nums.isEmpty()) return intArrayOf()
        return sortList(nums, 0, nums.size - 1)
    }

    fun sortList(nums: IntArray, start: Int, end: Int): IntArray {
        if (start >= end) return intArrayOf(nums[start])
        val mid = start + (end - start) / 2
        val list1 = sortList(nums, start, mid)
        val list2 = sortList(nums, mid + 1, end)
        return mergeLists(list1, list2)
    }

    fun mergeLists(list1: IntArray, list2: IntArray): IntArray {
        val res = IntArray(list1.size + list2.size)
        if (list1.isEmpty()) return list2
        if (list2.isEmpty()) return list1

        var l = 0
        var r = 0
        var k = 0

        while (l < list1.size && r < list2.size) {
            if (list1[l] < list2[r]) res[k++] = list1[l++]
            else res[k++] = list2[r++]
        }
        // add remaining elements of list1
        while (l < list1.size) res[k++] = list1[l++]

        // add remaining elements of list2
        while (r < list2.size) res[k++] = list2[r++]

        return res
    }
}
