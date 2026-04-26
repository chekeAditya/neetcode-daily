/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        return partitionAndMerge(0, lists.size - 1, lists)
    }

    private fun partitionAndMerge(start: Int, end: Int, lists: Array<ListNode?>): ListNode? {
        if (start > end) return null
        if (start == end) return lists[start]
        
        val mid = start + (end - start) / 2
        val l1 = partitionAndMerge(start, mid, lists)
        val l2 = partitionAndMerge(mid + 1, end, lists)
        
        return mergeTwoLists(l1, l2)
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l2 == null) return l1
        if (l1 == null) return l2
        
        return if (l1.`val` <= l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }
}
