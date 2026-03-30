class Solution {
    fun removeElement(nums: IntArray, value: Int): Int {
        val n = nums.size
        var j = -1
        for(i in 0 until n){
            if(nums[i] != value) {
                j++
                nums[j] = nums[i]
            }
        }
        return j + 1
    }
}
