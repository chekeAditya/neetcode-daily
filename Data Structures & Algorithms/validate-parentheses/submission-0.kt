class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (char in s) {
            if (stack.isEmpty()) {
                if (char == '}' || char == ')' || char == ']') return false
            }
            when (char) {
                '(', '[', '{' -> {
                    stack.add(char)
                }

                ')', ']', '}' -> {
                    if (stack.peek() == '(' && char == ')' ||
                        stack.peek() == '[' && char == ']' ||
                        stack.peek() == '{' && char == '}'
                    ) {
                        stack.pop()
                    } else {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}
