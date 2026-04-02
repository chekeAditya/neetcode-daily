class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // agar row mai element hai tho row array mai store karo, aur agar duplicate mila tho return false
        val rows = Array(9) { HashSet<Char>() } 
        // agar col mai element hai tho row array mai store karo, aur agar duplicate mila tho return false
        val cols = Array(9) { HashSet<Char>() }
        // agar 3*3 grid mai element hai tho row array mai store karo, aur agar duplicate mila tho return false
        val boxes = Array(9) { HashSet<Char>() }

        for(i in 0 until 9){
            for(j in 0 until 9){
                val value = board[i][j]

                if(value == '.') continue

                val boxIndex = (i / 3) * 3 + (j / 3) // ye grid ke check karta hai

                if(rows[i].contains(value) || cols[j].contains(value) || boxes[boxIndex].contains(value)) {
                    return false
                }

                rows[i].add(value)
                cols[j].add(value)
                boxes[boxIndex].add(value)
            }
        }
        return true
    }
}
