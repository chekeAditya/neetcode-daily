class Solution {
    private var rows = 0
    private var cols = 0

    fun exist(board: Array<CharArray>, word: String): Boolean {
        rows = board.size
        cols = board[0].size

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (dfs(board, word, r, c, 0)) {
                    return true
                }
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, word: String, r: Int, c: Int, i: Int): Boolean {
        if (i == word.length) {
            return true
        }
        if (r < 0 || c < 0 || r >= rows || c >= cols ||
            board[r][c] != word[i] || board[r][c] == '#'
        ) {
            return false
        }

        board[r][c] = '#'
        val res = dfs(board, word, r + 1, c, i + 1) ||
                dfs(board, word, r - 1, c, i + 1) ||
                dfs(board, word, r, c + 1, i + 1) ||
                dfs(board, word, r, c - 1, i + 1)
        
        board[r][c] = word[i]
        return res
    }
}
