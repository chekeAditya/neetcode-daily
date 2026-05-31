/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        //return usingListComparision(p, q)
        return usingRecusion(p, q)
    }

    private fun usingRecusion(p: TreeNode?, q: TreeNode?) : Boolean {
        if(p == null && q == null) return true
        if(p == null || q == null) return false
        if(p.`val` != q.`val`) return false
        return usingRecusion(p.left, q.left) && usingRecusion(p.right, q.right)
    }

    private fun usingListComparision(p: TreeNode?, q: TreeNode?): Boolean {
        val pList = arrayListOf<Int>()
        val qList = arrayListOf<Int>()
        printTree(p, pList)
        printTree(q, qList)
        return qList == pList
    }

    private fun printTree(root: TreeNode?, list: ArrayList<Int>): List<Int> {
        if (root == null) {
            list.add(Int.MIN_VALUE)
            return emptyList()
        }
        list.add(root.`val`)
        printTree(root.left, list)
        printTree(root.right, list)
        return list
    }
}
