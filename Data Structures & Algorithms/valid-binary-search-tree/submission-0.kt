/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun helper(root: TreeNode?, min: Long, max: Long): Boolean {
        if (root == null) return true

        if (root.`val` <= min || root.`val` >= max) return false

        val leftValid = helper(root.left, min, root.`val`.toLong())

        val rightValid = helper(root.right, root.`val`.toLong(), max)

        return rightValid && leftValid
    }
}
