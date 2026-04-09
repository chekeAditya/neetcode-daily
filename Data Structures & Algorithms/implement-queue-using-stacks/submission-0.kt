class MyQueue() {

    val inputStack = Stack<Int>()
    val outputStack = Stack<Int>()

    fun push(x: Int) {
        // Always add new elements to the input stack
        inputStack.push(x)
    }

    fun pop(): Int {
        shiftStacks()
        return outputStack.pop()
    }

    fun peek(): Int {
        shiftStacks()
        return outputStack.peek()
    }

    fun empty(): Boolean {
        return outputStack.isEmpty() && inputStack.isEmpty()
    }

    private fun shiftStacks() {
        // If output stack is empty, move everything from input stack to output stack
        if (outputStack.isEmpty()) {
            while (inputStack.isNotEmpty()) {
                outputStack.push(inputStack.pop())
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * val obj = MyQueue()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.peek()
 * val param_4 = obj.empty()
 */
