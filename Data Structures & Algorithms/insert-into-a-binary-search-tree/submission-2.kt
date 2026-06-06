/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, target: Int): TreeNode? {
        if(root == null) return TreeNode(target)

        if(root.`val` < target){
            root.right = insertIntoBST(root.right, target)
        } else {
            root.left = insertIntoBST(root.left, target)
        }

        return root
    }
}
