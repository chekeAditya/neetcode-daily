/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var slow : ListNode? = head
        var fast : ListNode? = head?.next

        while(fast != null){
            slow = slow?.next
            fast = fast?.next?.next
        }

        val secondHalfStarted = slow?.next
        slow?.next = null

        var p1 = head
        var p2 = reverse(secondHalfStarted)

        while(p2 != null){
            var next1 = p1?.next
            var next2 = p2?.next

            p1?.next = p2
            p2?.next = next1

            p1 = next1
            p2 = next2
        }
    }

    private fun reverse(node : ListNode?) : ListNode? {
        var prev : ListNode? = null
        var curr = node
        while(curr != null){
            var temp = curr.next
            curr?.next = prev
            prev = curr
            curr = temp
        }
        return prev
    }
}
