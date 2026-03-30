class Solution {
    fun validPalindrome(s: String): Boolean {
        for (i in 0 until s.length) {
            if (isPalindrome(s.replaceRange(i, i + 1, ""))) return true
        }
        return false
    }

    private fun isPalindrome(s: String): Boolean {
        val n = s.length
        var i = 0
        var j = n - 1
        while (i < j) {
            if (s[i] != s[j]) return false
            i++
            j--
        }
        return true
    }
}
