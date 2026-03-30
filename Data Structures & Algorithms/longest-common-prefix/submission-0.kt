class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var firstStr = if(strs[0].isEmpty()) return "" else strs[0]

        for(i in 1 until strs.size){
            while(!strs[i].startsWith(firstStr)) {
                // keep decreasing the length of the first string and check weather it's a substring of all strings present in strs array ? if no then reduce substring size and then check and keep doing this
                firstStr = firstStr.substring(0, firstStr.length - 1) 
            }
        }
        return firstStr
    }
}
