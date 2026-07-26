class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var word: Boolean = false
}

class WordDictionary {

    private val root = TrieNode()

    fun addWord(word: String) {
        var cur = root
        for (c in word) {
            val index = c - 'a'
            if (cur.children[index] == null) {
                cur.children[index] = TrieNode()
            }
            cur = cur.children[index]!!
        }
        cur.word = true
    }

    fun search(word: String): Boolean {
        return dfs(word, 0, root)
    }

    private fun dfs(word: String, j: Int, root: TrieNode): Boolean {
        var cur = root
        for (i in j until word.length) {
            val c = word[i]
            if (c == '.') {
                for (child in cur.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true
                    }
                }
                return false
            } else {
                val index = c - 'a'
                if (cur.children[index] == null) {
                    return false
                }
                cur = cur.children[index]!!
            }
        }
        return cur.word
    }
}
