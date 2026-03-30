class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val res = ArrayList<ArrayList<String>>()
        val map = HashMap<String, ArrayList<String>>()

        for (str in strs) {
            val sorted = str.toCharArray().sorted().joinToString("")
            val list: ArrayList<String> = map.getOrDefault(sorted, arrayListOf())
            list.add(str)
            map[sorted] = list
        }

        for (data in map) {
            if (data.value.isNotEmpty()) res.add(data.value)
        }
        return res
    }
}
