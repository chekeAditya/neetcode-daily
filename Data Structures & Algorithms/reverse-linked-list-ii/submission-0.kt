/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null || head.next == null) return head

        val dummy = ListNode(0)
        dummy.next = head

        var prev: ListNode? = dummy

        for (i in 1 until left) {
            prev = prev?.next
        }

        val curr: ListNode? = prev?.next

        for (i in 1..(right - left)) {
            val temp = prev?.next
            prev?.next = curr?.next
            curr?.next = curr.next?.next
            prev?.next?.next = temp
        }
        return dummy.next
    }
}
