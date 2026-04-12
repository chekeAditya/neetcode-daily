class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        val operators = setOf("+", "-", "*", "/")

        // Using a lambda with forEach
        tokens.forEach { token ->
            if (token !in operators) {
                stack.push(token.toInt())
            } else {
                val b = stack.pop()
                val a = stack.pop()
                val result = when (token) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    else -> 0
                }
                stack.push(result)
            }
        }
        return stack.pop()
    }
}
