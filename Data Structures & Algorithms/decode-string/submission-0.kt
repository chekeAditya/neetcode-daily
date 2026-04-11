class Solution {
    fun decodeString(s: String): String {
        val st = Stack<Int>() // holds how much string will release
        val strStack = Stack<StringBuilder>() // holds string to repeat
        var ans = StringBuilder()
        var n = 0

        for (i in s) {
            when {
                i.isDigit() -> {
                    n = n * 10 + (i - '0')
                }

                i == '[' -> {
                    strStack.push(ans)
                    st.push(n)
                    n = 0
                    ans = StringBuilder()
                }

                i == ']' -> {
                    // 1. Get the repeat count
                    val repeatCount = st.pop()

                    // 2. This is the string we just finished building inside the brackets [ ... ]
                    val contentInsideBrackets = ans

                    // 3. Get the string we were building BEFORE we hit the current '['
                    ans = strStack.pop()

                    // 4. Append the content to the old string 'repeatCount' times
                    repeat(repeatCount) {
                        ans.append(contentInsideBrackets)
                    }
                }

                else -> {
                    ans.append(i)
                }
            }
        }

        return ans.toString()
    }
}
// The **Decode String** problem asks you to expand a compressed string like `3[a]2[bc]` into `aaabcbc`. use two stacks: one to keep track of the **repeat count ($k$)** and 
// another to store the **string** built so far before entering a new bracket. 

// When you hit an opening bracket `[`, you save your current progress and reset to start fresh 

// when you hit a closing bracket `]`, you retrieve the saved count and the previous string, then append your finished work to it $k$ times. 

// This "nesting" logic ensures that inner brackets are solved first and correctly multiplied into the outer parts of the string. 