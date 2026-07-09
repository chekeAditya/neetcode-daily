class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val path = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()
        helper(nums, path, result)

        return result
    }

    private fun helper(
        nums : IntArray,
        path : MutableList<Int>,
        result : MutableList<List<Int>>
    ) {
        if(path.size == nums.size) {
            result.add(path.toList())
            return
        }

        for(num in nums) {
            if(path.contains(num).not()){
                path.add(num)
                helper(nums, path, result)
                path.removeLast()
            }
        }
    }
}
