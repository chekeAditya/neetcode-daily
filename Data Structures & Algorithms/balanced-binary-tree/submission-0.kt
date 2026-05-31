/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var balancedRes = true

    fun isBalanced(root: TreeNode?): Boolean {
        balanced(root)
        return balancedRes
    }

    private fun balanced(root : TreeNode?) : Int {
        if(root == null) return 0
        val leftHeight = balanced(root.left)
        val rightHeight = balanced(root.right)

        if(abs(leftHeight - rightHeight) > 1) balancedRes = false

        return max(leftHeight, rightHeight) + 1
    }
}
