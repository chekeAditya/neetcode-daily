/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var i1 = l1
        var i2 = l2
    
        val result: ListNode? = ListNode(0)
        var current = result
    
        var carry: Int = 0
    
        while (i1 != null || i2 != null || carry != 0) {
            val sum = (i1?.`val` ?: 0) + (i2?.`val` ?: 0) + carry
            carry = sum / 10
            current?.next = ListNode(sum % 10)
            current = current?.next
            i1 = i1?.next
            i2 = i2?.next
        }
        return result?.next
    }
}
