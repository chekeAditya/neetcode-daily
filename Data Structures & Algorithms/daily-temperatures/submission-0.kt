class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val stack = Stack<Pair<Int, Int>>()
        val ans = IntArray(n)
        for(i in n-1 downTo 0){

            // if previous days temperature is less then current temperature then remove it from stack 
            while(stack.isNotEmpty() && stack.peek().first <= temperatures[i]) stack.pop()

            // if stack has some data means temperature is above then previous day then calucate peak - current
            if(stack.isNotEmpty()) ans[i] = stack.peek().second - i

            stack.push(Pair(temperatures[i], i))
        }
        return ans
    }
}
