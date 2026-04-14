class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rowSize = matrix.size
        val colSize = if (rowSize > 0) matrix[0].size else 0

        for (row in 0 until rowSize) {
            if (target >= matrix[row][0] && target <= matrix[row][colSize - 1])
                return findPresentInRow(row, colSize, matrix, target)
        }
        return false
    }

    private fun findPresentInRow(row: Int, colSize: Int, matrix: Array<IntArray>, target: Int): Boolean {
        for (col in 0 until colSize) {
            if (matrix[row][col] == target) return true
        }
        return false
    }
}
