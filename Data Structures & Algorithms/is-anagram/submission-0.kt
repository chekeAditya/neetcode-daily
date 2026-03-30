class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val arr = IntArray(26) { 0 }

        // increment count of char
        for(i in 0 until s.length){
            arr[s[i] - 'a']++
        }

        for(i in 0 until t.length){
            arr[t[i] - 'a']--
        }

        for(num in arr){
            if(num != 0) return false
        }

        return true
    }
}
