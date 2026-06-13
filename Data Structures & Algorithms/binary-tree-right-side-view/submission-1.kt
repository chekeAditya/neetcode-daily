/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val ans = mutableListOf<Int>()
        helper(root, ans, 0)
        return ans
    }

    private fun helper(root: TreeNode?, ans: MutableList<Int>, depth: Int) {
        if (root == null) return

        if (depth == ans.size) ans.add(root.`val`)

        helper(root.right, ans, depth + 1) // will keeping oning right depth and measure it's depth if it matches with the ans list then only will add it to list else will move left or right
        helper(root.left, ans, depth + 1)
    }
}
