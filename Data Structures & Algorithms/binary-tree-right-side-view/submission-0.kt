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
        val q = ArrayDeque<TreeNode>()
        q.addLast(root)
        val ans = mutableListOf<Int>()

        while (q.isNotEmpty()) {
            val levelSize = q.size
            val list = mutableListOf<Int>()

            for (i in 0..<levelSize) {
                val data = q.removeFirst()
                list.add(data.`val`)
                data.left?.let { q.addLast(it) }
                data.right?.let { q.addLast(it) }
            }

            ans.add(list.removeLast())
        }
        return ans
    }
}
