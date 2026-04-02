class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // Check all 9 rows and 9 columns
        for (i in 0 until 9) {
            if (isNumOccurMultipleTimeInRow(board, i) ||
                isNumOccurMultipleTimeInCol(board, i)
            ) {
                return false
            }
        }

        // Check all 9 distinct 3x3 grids
        for (i in 0 until 9 step 3) {
            for (j in 0 until 9 step 3) {
                val endingRow = i + 2
                val endingCol = j + 2
                if (isNumOccurMultipleTimeInGrid(board, i, j, endingRow, endingCol)) {
                    return false
                }
            }
        }

        return true
    }

    fun isNumOccurMultipleTimeInRow(board: Array<CharArray>, row: Int): Boolean {
        val set = HashSet<Char>()
        for (j in 0 until 9) {
            if (board[row][j] == '.') continue
            if (set.contains(board[row][j])) return true // Found a duplicate
            set.add(board[row][j])
        }
        return false // No duplicates found
    }

    fun isNumOccurMultipleTimeInCol(board: Array<CharArray>, col: Int): Boolean {
        val set = HashSet<Char>()
        for (i in 0 until 9) {
            if (board[i][col] == '.') continue
            if (set.contains(board[i][col])) return true
            set.add(board[i][col])
        }
        return false
    }

    fun isNumOccurMultipleTimeInGrid(
        board: Array<CharArray>,
        startingRow: Int,
        startingCol: Int,
        endingRow: Int,
        endingCol: Int,
    ): Boolean {
        val set = HashSet<Char>()
        for (i in startingRow..endingRow) {
            for (j in startingCol..endingCol) {
                if (board[i][j] == '.') continue
                if (set.contains(board[i][j])) return true
                set.add(board[i][j])
            }
        }
        return false
    }
}
