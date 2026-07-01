class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val path = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()

        helper(1, n, k, path, result)
        
        return result
    }

    private fun helper(start: Int, n : Int, k : Int, path : MutableList<Int>, result : MutableList<List<Int>>){
        if(path.size == k){
            result.add(path.toList())
            return
        }

        for(i in start .. n) {
            path.add(i)

            helper(i + 1, n, k, path, result)

            path.removeLast()
        }
    }
}
