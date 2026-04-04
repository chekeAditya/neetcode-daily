class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val occurance = IntArray(26)
        val n = s.length
        var left = 0 // left pointer
        var right = 0 // right pointer starts from 0 till end
        var ans = 0 
        var maxOcc = 0 // how long does a contigous substring can occur

        while(right < n){
            // find which character occurs most frequestly in int array
            maxOcc = max(maxOcc, ++occurance[s[right] - 'A'])

            // if it occurs more then reduce window size, decrease occurance
            if(right - left + 1 - maxOcc > k){
                occurance[s[left] - 'A']--
                left++
            }

            // count maximum size of longest repeating character 
            ans = max(ans, right - left + 1)
            right++
        }

        return ans
    }
}
