class Solution {
    fun minWindow(s: String, t: String): String {
        val n = s.length
        val map = HashMap<Char, Int>()
        for (char in t) {
            map[char] = map.getOrDefault(char, 0) + 1
        }

        var i = 0
        var j = 0
        var start_i = 0
        var requiredCnt = t.length // start with the total characters needed
        var minWindowSize = Int.MAX_VALUE
        
        while (j < n) {
            val ch = s[j]
            
            if (map.getOrDefault(ch, 0) > 0) {
                requiredCnt--
            }
            map[ch] = map.getOrDefault(ch, 0) - 1

            while (requiredCnt == 0) {
                // start shrinking the window
                val currWindowSize = j - i + 1
                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize
                    start_i = i
                }

                // increase shrinking frequency from left i.e i
                map[s[i]] = map.getOrDefault(s[i], 0) + 1

                if (map.getOrDefault(s[i], 0) > 0) {
                    requiredCnt++
                }
                i++ // shrinking window from left side
            }
            j++
        }

        // the end index is start_i + minWindowSize
        return if (minWindowSize == Int.MAX_VALUE) "" else s.substring(start_i, start_i + minWindowSize)
    }
}
