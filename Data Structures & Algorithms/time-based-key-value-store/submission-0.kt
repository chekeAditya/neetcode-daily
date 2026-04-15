class Node(val timestamp: Int, val value: String) {
    var left: Node? = null
    var right: Node? = null
}

class TimeMap() {
    private val map = HashMap<String, Node?>()

    fun set(key: String, value: String, timestamp: Int) {
        val root = map[key]
        map[key] = insert(root, timestamp, value)
    }

    private fun insert(root: Node?, timestamp: Int, value: String): Node {
        if (root == null) return Node(timestamp, value)
        // new nodes go on right of BST
        if (timestamp < root.timestamp) {
            root.left = insert(root.left, timestamp, value)
        } else {
            root.right = insert(root.right, timestamp, value)
        }
        return root
    }

    fun get(key: String, timestamp: Int): String {
        var current = map[key]
        var result = ""

        while (current != null) {
            if (current.timestamp == timestamp) {
                return current.value
            } else if (current.timestamp < timestamp) {
                // look for a larger timestamp that is still <= target.
                result = current.value
                current = current.right
            } else {
                current = current.left
            }
        }
        return result
    }
}
