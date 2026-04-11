class Solution {
    fun simplifyPath(path: String): String {
        val pathArr = path.split("/")
        val st = Stack<String>()
        val ans = StringBuilder()
        for(str in pathArr){
            if(str == ".." && st.isNotEmpty()) st.pop()
            else if(str == "." || str.isEmpty() || str == "..") continue
            else st.push(str.trim())
        }
        st.forEach {
            ans.append("/${it.trim()}")
        }
        return if(st.isEmpty()) "/" else ans.toString()
    }
}
