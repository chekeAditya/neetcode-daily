/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val ans = ArrayList<List<Int>>()

        if (root == null) return ans

        val q = ArrayDeque<TreeNode>()
        q.addLast(root)

        while (q.isNotEmpty()) {
            val levelSize = q.size
            val currentLevelList = ArrayList<Int>()
            
            for (i in 0 until levelSize) {
                val currentNode = q.removeFirst()
                
                currentLevelList.add(currentNode.`val`)
                
                // queue up children for next level 
                currentNode.left?.let { q.addLast(it) }
                currentNode.right?.let { q.addLast(it) }
            }
            
            // Add the completed level to our final answer list
            ans.add(currentLevelList)
        }
        
        return ans
    }
}
