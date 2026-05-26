/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
        return postOrder(root, list)
    }

    fun postOrder(root: TreeNode?, list : ArrayList<Int>) : List<Int> {
        if(root == null) return list
        postOrder(root.left, list)
        postOrder(root.right, list)
        list.add(root.`val`)
        return list
    }
}
