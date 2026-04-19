/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var size = 0
        var curr = head
        while(curr != null){
            size++
            curr = curr.next
        }
        
        if(n == size) return head?.next

        var prev = head
        for(i in 0 until (size-n-1)){
            prev = prev?.next
        }
        
        prev?.next = prev?.next?.next

        return head
    }
}
