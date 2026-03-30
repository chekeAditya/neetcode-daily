class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()
        for(num in nums){
            set.add(num)
        }

        var cnt = 0
        var maxCnt = 0
        for(num in set){
            if(!set.contains(num-1)){
                cnt = 1
                while(set.contains(num + cnt)){
                    cnt++
                }
                maxCnt = max(maxCnt, cnt)
            }
        }

        return maxCnt
    }
}
