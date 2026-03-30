class Solution {
    fun isPalindrome(s: String): Boolean {
        val n = s.length
        var i = 0
        var j = n - 1
        while(i < j) {
            if(!isAlphanumeric(s[i])) {
                i++
                continue
            }
            if(!isAlphanumeric(s[j])) {
                j--
                continue
            }

            if(isLowerCase(s[i]) == isLowerCase(s[j])){
                i++
                j--
            } else return false
        }
        return true
    }

    private fun isAlphanumeric(c : Char) : Boolean {
        return if(c in 'a'..'z' || c in 'A'..'Z' || c in '0'..'9') true
        else false
    }

    private fun isLowerCase(c : Char) : Char {
        return if(c in 'A'..'Z') c + 32 
        else c
    }
}
