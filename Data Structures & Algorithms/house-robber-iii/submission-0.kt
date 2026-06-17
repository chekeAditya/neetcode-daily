/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rob(root: TreeNode?): Int {
        return max(dfs(root).first, dfs(root).second)
    }

    private fun dfs(root: TreeNode?): Pair<Int, Int> {
        if (root == null) return Pair(0, 0)

        val leftPair = dfs(root.left)
        val rightPair = dfs(root.right)

        val withRoot = root.`val` + leftPair.second + rightPair.second
        val withoutRoot = max(leftPair.first, leftPair.second) + max(rightPair.first, rightPair.second)

        return Pair(withRoot, withoutRoot)
    }
}
