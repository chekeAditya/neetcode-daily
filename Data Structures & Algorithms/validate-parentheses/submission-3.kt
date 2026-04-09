class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (char in s) {
            when (char) {
                '(', '[', '{' -> stack.add(char)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            }
        }

        return stack.isEmpty()
    }
}
