class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var s1i = 0
        var s2i = 0
        val n1 = word1.length
        val n2 = word2.length
        val str = StringBuilder()
        var index = 0
        while(s1i < n1 && s2i < n2){
            if(index % 2 == 0){
                str.append(word1[s1i])
                s1i++
            } else {
                str.append(word2[s2i])
                s2i++
            }
            index++
        }

        // left elements
        while(s1i < n1){
            str.append(word1[s1i])
            index++
            s1i++
        }

        while(s2i < n2){
            str.append(word2[s2i])
            index++
            s2i++
        }
        return str.toString()
    }
}
