class Solution {
    fun majorityElement(nums: IntArray): Int {
        var c = 0
        var el = 0
        for(i in nums){
            if(c == 0){
                c = 1
                el = i
            } else if(i == el) c++
            else {
                c--
            }
        }
        c = 0
        for(i in 0 until nums.size){
            if(el == nums[i]) c++
        }
        if(c > nums.size/2) return el
        else return -1
    }
}
