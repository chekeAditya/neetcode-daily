class NumMatrix(matrix: Array<IntArray>) {
    val matrix = matrix

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var sum = 0
        for (r in row1..row2) {
            for (c in col1..col2) {
                sum += matrix[r][c]
            }
        }
        return sum
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
