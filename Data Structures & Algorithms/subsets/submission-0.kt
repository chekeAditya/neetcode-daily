class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val path = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()
        helper(0, nums, path, result)
        return result
    }

    private fun helper(index : Int, nums: IntArray, path : MutableList<Int>, result : MutableList<List<Int>>) {
        if(index == nums.size ) {
            result.add(path.toList())
            return
        }
        path.add(nums[index])
        helper(index+1, nums, path, result)

        path.removeLast()

        helper(index+1, nums, path, result)
    }
}
