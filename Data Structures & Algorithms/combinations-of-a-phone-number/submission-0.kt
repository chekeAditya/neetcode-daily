class Solution {
    fun letterCombinations(digits: String): List<String> {
        val map = HashMap<Char, String>()
        val result = arrayListOf<String>()
        map['2'] = "abc"
        map['3'] = "def"
        map['4'] = "ghi"
        map['5'] = "jkl"
        map['6'] = "mno"
        map['7'] = "pqrs"
        map['8'] = "tuv"
        map['9'] = "wxyz"

        if (digits.isEmpty()) return arrayListOf()

        helper(digits, map, 0, StringBuilder(), result)

        return result
    }

    private fun helper(
        digits: String,
        map: HashMap<Char, String>,
        idx: Int,
        path: StringBuilder,
        result: ArrayList<String>
    ) {

        if (path.length == digits.length) {
            result.add(path.toString())
            return
        }

        val possibleCombination: String? = map[digits[idx]]

        if (possibleCombination != null) {
            for (str in possibleCombination) {
                path.append(str)

                helper(digits, map, idx + 1, path, result)

                path.deleteCharAt(path.length - 1)
            }
        }
    }
}
