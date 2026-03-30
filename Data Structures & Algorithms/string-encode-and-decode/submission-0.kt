class Solution {

    fun encode(strs: List<String>): String {
        var encodedStr = StringBuilder()
        for(i in 0 until strs.size){
            encodedStr.append("${strs[i].length}#${strs[i]}")
        }
        return encodedStr.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while(i < str.length){
            var j = i
            
            while(str[j] != '#') j++

            val length = str.substring(i, j).toInt()
            
            val actualStr = str.substring(j + 1, j + 1 + length)

            result.add(actualStr)

            i = j + 1 + length
        }
        return result
    }
}