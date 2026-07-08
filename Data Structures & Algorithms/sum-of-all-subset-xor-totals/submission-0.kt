class Solution {
    fun subsetXORSum(nums: IntArray): Int {
        return helper(0, nums, 0)
    }

    private fun helper(index : Int, nums: IntArray, xorSum : Int) : Int {
        if(index == nums.size ) {
            return xorSum
        }

        // it's too simple first include it then exclude it and then return sum of both of them
        val include = helper(index+1, nums, xorSum xor nums[index]) 
        val exclude = helper(index+1, nums, xorSum)

        return include + exclude
    }
}
