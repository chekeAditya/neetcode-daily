class MinStack() {

    val stack = Stack<Pair<Long, Long>>()

    fun push(x: Int) {
        val currentVal = x.toLong()
        val currentMin = if (stack.isEmpty()) currentVal else min(currentVal, stack.peek().second)
        stack.push(Pair(currentVal, currentMin))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().first.toInt()
    }

    fun getMin(): Int {
        return stack.peek().second.toInt()
    }
}