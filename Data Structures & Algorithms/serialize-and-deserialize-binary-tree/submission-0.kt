/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    private var idx = 0

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val ans = StringBuilder()
        preOrder(root, str = ans)
        return ans.toString()
    }

    private fun preOrder(root: TreeNode?, str: StringBuilder) {
        if (root == null) {
            str.append("x,")
            return
        }
        str.append("${root.`val`},")
        preOrder(root.left, str)
        preOrder(root.right, str)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val array = data.split(",")
        return createTree(array)
    }

    private fun createTree(array: List<String>): TreeNode? {
        if (idx >= array.size) return null
        val data = array[idx++]

        if (data == "x") return null

        val node = TreeNode(data.toIntOrNull() ?: 0)
        node.left = createTree(array)
        node.right = createTree(array)
        return node
    }
}
