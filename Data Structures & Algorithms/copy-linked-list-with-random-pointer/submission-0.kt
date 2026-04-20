/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        // part 1: create new temp node and then iterate node till it becomes null, and put all value of existing node into newTemp node
        val map =
            HashMap<Node, Node>() // ye node store karne ke lia use karre hai, taki pata rahe oldNode ke correspond konsa newNode assign hai
    
        val newHead = Node(node.`val`)
    
        var newTemp: Node? = newHead
        var oldTemp = node.next
    
        map[node] = newHead
    
        while (oldTemp != null) {
            val copyNode = Node(oldTemp.`val`)
            map[oldTemp] = copyNode
            newTemp?.next = copyNode
            oldTemp = oldTemp.next
            newTemp = newTemp?.next
        }
    
        var oldNode = node
        var newNode: Node? = newHead
        while (oldNode != null) {
            newNode?.random = map[oldNode.random]
            oldNode = oldNode.next
            newNode = newNode?.next
        }
    
        return newHead
    }
}
