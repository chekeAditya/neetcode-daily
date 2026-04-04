class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val n = nums.size
        if(k == 0 || n < 2) return false
        val set = HashSet<Int>()
        var left = 0
        for (right in 0 until n) {
            if(right - left > k){
                set.remove(nums[left]) // remove islia karre hai coz agar humne dekha hai tho vo window size ke bahar dekha hai, window size ke andar nhi dekha
                left++
            }

            if(!set.add(nums[right])) return true
        }
        return false
    }
}
