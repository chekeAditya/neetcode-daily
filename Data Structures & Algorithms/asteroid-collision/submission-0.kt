class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (num in asteroids) {
            var isDestroyed = false

            // collide if stack top is going RIGHT (positive) and current is going LEFT (negative)
            while (stack.isNotEmpty() && stack.peek() > 0 && num < 0) {
                val top = stack.peek()
                val currentAbs = abs(num)

                // Top asteroid is smaller, destroy it and continue checking
                if (top < currentAbs) {
                    stack.pop()
                    continue
                } else if (top == currentAbs) {
                    // both size is same destroyed both and stop
                    stack.pop()
                    isDestroyed = true
                    break
                } else {
                    // Current asteroid is smaller, it gets destroyed
                    isDestroyed = true
                    break
                }
            }

            if (!isDestroyed) {
                stack.push(num)
            }
        }

        return stack.toIntArray()
    }
}
