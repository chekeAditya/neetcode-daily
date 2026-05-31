/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var diameterResult = Int.MIN_VALUE

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        diameter(root)
        return diameterResult
    }

    private fun diameter(root : TreeNode?) : Int {
        if(root == null) return 0
        val left = diameter(root.left) // find the left max height 
        val right = diameter(root.right) // find the right max height 

        diameterResult = max(diameterResult, (left + right)) // update which is more left one or right one or the one which is already been calculated and updated in diameterResult, and finally result diameterResult

        return (max(left , right) + 1)
    }
}
