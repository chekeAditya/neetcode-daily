class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
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
        idx : Int,
        sum : Int,
        target : Int,
        list : MutableList<Int>,
        result : MutableList<List<Int>>
    ) {
        if(sum == target) {
            result.add(list.toList())
            return
        }

        if(sum > target) return

        for(i in idx until nums.size){
            if (i > idx && nums[i] == nums[i - 1]) continue

            list.add(nums[i])
            helper(nums, i + 1, sum + nums[i], target, list, result)
            
            // remove
            list.removeLast()
        }
    }
}
