/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun deleteNode(root: TreeNode?, target: Int): TreeNode? {
        if (root == null) return null

        if (target > root.`val`) { // move right
            root.right = deleteNode(root.right, target)
        } else if (target < root.`val`) { // move left
            root.left = deleteNode(root.left, target)
        } else {
            /**
            * Case 1 : one child present
            * Case 2 : two child present
            * Case 3 : no child present
            */
            if (root.left == null && root.right == null) {
                return null
            } else if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            } else {
                val minNode = findMin(root.right!!)
                root.`val` = minNode.`val`
                root.right = deleteNode(root.right, minNode.`val`)
            }
        }

        return root
    }

    private fun findMin(node: TreeNode): TreeNode {
        var curr = node
        while (curr.left != null) {
            curr = curr.left!!
        }
        return curr
    }
}
