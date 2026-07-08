class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val list = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()

        candidates.sort()

        helper(
            candidates, 0, 0, target, list, result
        )

        return result
    }

    private fun helper(
        nums : IntArray,        
        sum : Int,
        idx : Int,
        target : Int,
        list : MutableList<Int>,
        result : MutableList<List<Int>>
    ) {

        if(sum == target && result.contains(list).not()) {
            result.add(list.toList())
            return
        }

        if(sum > target || idx > nums.size - 1) return

        list.add(nums[idx]) // include element
        helper(nums, sum + nums[idx], idx, target, list, result)
        list.removeLast() // skip element
        helper(nums, sum, idx + 1, target, list, result)
    }
}
