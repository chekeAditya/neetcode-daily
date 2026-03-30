class Solution {
    fun validPalindrome(s: String): Boolean {
        val n = s.length
        var i = 0
        var j = n-1
        while(i < j){
            if(s[i] != s[j]) {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1)
            }
            i++
            j--
        }
        return true
    }

    private fun isPalindrome(s: String, left : Int, right : Int): Boolean {
        var i = left
        var j = right
        while (i < j) {
            if (s[i] != s[j]) return false
            i++
            j--
        }
        return true
    }
}
