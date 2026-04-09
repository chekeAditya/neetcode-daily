class Solution {
    fun calPoints(operations: Array<String>): Int {
        val stack = Stack<Int>()
        var sum = 0

        for (char in operations) {
            when (char) {
                "+" -> {
                    val firstValue = stack.pop()
                    val secondValue = stack.pop()
                    stack.add(secondValue)
                    stack.add(firstValue)
                    stack.add(firstValue + secondValue)
                    sum += firstValue + secondValue
                }

                "D" -> {
                    val value = stack.peek() * 2
                    stack.add(value)
                    sum += value
                }

                "C" -> {
                    sum -= stack.pop()
                }

                else -> {
                    val value = char.toInt()
                    stack.add(value)
                    sum += value
                }
            }
        }

        return if (stack.isEmpty()) 0 else sum

    }
}
