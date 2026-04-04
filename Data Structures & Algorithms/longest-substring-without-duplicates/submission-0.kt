class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        var i = 0
        val str = StringBuilder()
        var maxSize = 0
        while(i < n){
            var j = i
            while(j < n){
                if(str.contains(s[j])) break
                else str.append(s[j])
                j++
            }
            i++
            maxSize = max(maxSize, str.length)
            str.clear()
        }
        return maxSize
    }
}
