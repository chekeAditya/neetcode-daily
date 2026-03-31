class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        val res = IntArray(2)
        while(l < r) {
            if(numbers[l] + numbers[r] == target) {
                res[0] = l + 1
                res[1] = r + 1
                return res
            } else if(numbers[l] + numbers[r] > target) r--
            else l++
        }
        return res
    }
}
