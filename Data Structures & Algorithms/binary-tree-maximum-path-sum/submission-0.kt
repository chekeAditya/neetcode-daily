/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        return max(helper(root), maxSum)
    }

    private fun helper(root : TreeNode?) : Int {
        if(root == null) return 0

        val leftPathSum = helper(root.left)
        val rightPathSum = helper(root.right)

        val leftMax = max(leftPathSum, 0)
        val rightMax = max(rightPathSum, 0)

        val currNodeSum = leftMax + rightMax + root.`val`

        maxSum = max(currNodeSum, maxSum)

        return root.`val` + max(leftMax, rightMax)
    }
}
