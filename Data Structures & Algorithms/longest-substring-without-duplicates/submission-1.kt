class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 1) return 1
        var left = 0
        var maxLength = 0
        val map = mutableMapOf<Char, Int>()
        for (right in s.indices) {
            val char = s[right]
            if (char in map) {
                left = maxOf(left, map[char]!! + 1)
            }
            map[char] = right
            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}
