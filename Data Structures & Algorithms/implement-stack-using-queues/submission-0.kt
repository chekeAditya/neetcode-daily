class MyStack() {

    val queue = mutableListOf<Int>()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        val value = queue[queue.size - 1]
        queue.removeAt(queue.size - 1)
        return value
    }

    fun top(): Int {
        return queue[queue.size - 1]
    }

    fun empty(): Boolean {
        return queue.size == 0
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */
