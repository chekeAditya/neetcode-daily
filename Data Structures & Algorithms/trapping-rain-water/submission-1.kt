class Solution {
    fun trap(height: IntArray): Int {
        if(height.isEmpty()) return 0
        val n = height.size

        var l = 0
        var r = n - 1
        var leftMax = height[l]
        var rightMax = height[r]
        var ans = 0
        while(l < r){
            if(leftMax < rightMax) {
                l++
                leftMax = max(leftMax, height[l])
                ans += leftMax - height[l] // don't add the -1, for that reason we're taking max
            } else {
                r--
                rightMax = max(rightMax, height[r])
                ans += rightMax - height[r] // 
            }
        }
        return ans
    }
}
