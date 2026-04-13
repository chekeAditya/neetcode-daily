class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val n = position.size
        if (n == 0) return 0

        // Create pairs of (position, speed) and sort them by position descending
        val cars = position.indices.map { i ->
            position[i] to speed[i]
        }.sortedByDescending { it.first }

        val stack = Stack<Double>()

        cars.forEach { (pos, spd) ->
            val timeTaken = (target - pos).toDouble() / spd // time = distance / speed

            // If the current car takes MORE time than the fleet in front, it starts a new fleet.
            if (stack.isEmpty() || timeTaken > stack.peek()) {
                stack.push(timeTaken)
            }
            // If timeTaken <= stack.peek(), this car catches up and joins the existing fleet, so we do nothing (don't push).
        }

        return stack.size
    }
}
