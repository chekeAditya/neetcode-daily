/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var count : Int = 0
    private var result : Int = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        helper(root, k)
        return result
    }

    /*
     * Move left till you end of the node and once you reached create a local counter check if you found 
     count of local count == k if yes then this is the element we're looking for else keep moving right then left and then top
    */
    private fun helper(root: TreeNode?, k : Int) {
        if (root == null) return

        helper(root.left, k)
        
        if(++count == k) {
            result = root.`val`
            return
        }

        helper(root.right, k)
    }
}
