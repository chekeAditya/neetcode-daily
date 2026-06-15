/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0
        return dfs(root, root.`val`)
    }

    private fun dfs(root: TreeNode?, maxSoFar: Int): Int {
        if (root == null) return 0

        val maxCnt = if (root.`val` >= maxSoFar) 1 else 0

        val leftMaxCnt = dfs(root.left, max(maxSoFar, root.`val`))

        val rightMaxCnt = dfs(root.right, max(maxSoFar, root.`val`))

        return leftMaxCnt + rightMaxCnt + maxCnt
    }
}
