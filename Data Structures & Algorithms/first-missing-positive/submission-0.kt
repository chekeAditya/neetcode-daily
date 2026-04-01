class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size

        // if value is less then 0 mark it as zero
        for(i in 0 until n){
            if(nums[i] < 0) nums[i] = 0
        }

        // if it's not variable then mark its
        for(i in 0 until n){
            val value = abs(nums[i])
            if(value >= 1 && value <= n) {
                if(nums[value - 1] > 0){
                    nums[value - 1] *= -1
                } else if(nums[value-1] == 0) {
                    nums[value - 1] = -(n+1)
                }
            } 
        }

        for(i in 1 .. n){
            if(nums[i-1] >= 0) return i
        }

        return n + 1
    }
}
