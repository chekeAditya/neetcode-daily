/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var curr1 = list1
        var curr2 = list2
        if (curr1 == null) return curr2
        if (curr2 == null) return curr1

        val ans: ListNode? = ListNode(0)
        var temp: ListNode? = ans
        while (curr1 != null && curr2 != null) {
            if (curr1.`val` < curr2.`val`) {
                temp?.next = curr1
                curr1 = curr1.next
            } else {
                temp?.next = curr2
                curr2 = curr2.next
            }
            temp = temp?.next
        }

        while (curr1 != null) {
            temp?.next = curr1
            curr1 = curr1.next
            temp = temp?.next
        }

        while (curr2 != null) {
            temp?.next = curr2
            curr2 = curr2.next
            temp = temp?.next
        }

        return ans?.next
    }
}
