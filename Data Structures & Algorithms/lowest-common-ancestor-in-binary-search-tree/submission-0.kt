/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var currentNode = root

        while (currentNode != null) {
            val parentVal = currentNode.`val`
            val pVal = p?.`val` ?: 0
            val qVal = q?.`val` ?: 0

            if (pVal > parentVal && qVal > parentVal) {
                // Both p and q are greater, so move to the right subtree
                currentNode = currentNode.right
            } else if (pVal < parentVal && qVal < parentVal) {
                // Both p and q are smaller, so move to the left subtree
                currentNode = currentNode.left
            } else {
                // We found the split point or one of the nodes itself
                return currentNode
            }
        }
        
        return null
    }
}
