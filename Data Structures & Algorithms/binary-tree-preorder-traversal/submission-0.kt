/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = arrayListOf<Int>()
        return preOrder(root, list)
    }

    private fun preOrder(root: TreeNode?, list: ArrayList<Int>): List<Int> {
        if (root == null) return list
        list.add(root.`val`)
        preOrder(root.left, list)
        preOrder(root.right, list)
        return list
    }
}
