class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val n = nums.size
        val ans = ArrayList<List<Int>>()
        
        nums.sort()

        for(i in 0 until n){
            if(i > 0 && nums[i] == nums[i-1]) continue
            for(j in i+1 until n){
                if(j > i+1 && nums[j] == nums[j-1]) continue

                var k = j+1
                var l = n-1
                while(k < l){
                    val sum = nums[i].toLong() + nums[j].toLong() + nums[k].toLong() + nums[l].toLong()

                    if(sum > target.toLong()) l--
                    else if(sum < target.toLong()) k++
                    else {
                        ans.add(arrayListOf(nums[i], nums[j], nums[k], nums[l]))
                        
                        k++
                        l--
                        
                        while(k < l && nums[k] == nums[k-1]) k++
                        while(k < l && nums[l] == nums[l+1]) l--
                    }
                }
            }
        }
        return ans
    }
}
