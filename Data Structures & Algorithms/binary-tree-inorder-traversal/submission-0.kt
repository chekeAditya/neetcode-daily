/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = arrayListOf<Int>()
        return inOrder(root, list)
    }

    fun inOrder(root: TreeNode?, list: ArrayList<Int>): List<Int> {
        if (root == null) return list
        inOrder(root.left, list)
        list.add(root.`val`)
        inOrder(root.right, list)
        return list
    }
}
