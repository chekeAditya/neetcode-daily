class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Cnt = IntArray(26)
        val s2Cnt = IntArray(26)

        // store al element of s1 into s1Cnt array
        for (char in s1) {
            s1Cnt[char - 'a']++
        }

        for (i in s2.indices) {
            s2Cnt[s2[i] - 'a']++

            // if window becomes greater then s1 length then decrease windows size
            if (i >= s1.length) {
                s2Cnt[s2[i - s1.length] - 'a']--
            }

            if (s1Cnt.contentEquals(s2Cnt)) return true
        }

        return false
    }
}
