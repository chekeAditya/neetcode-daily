/* Think of this problem like a Music Chart where you have different "Top 10" lists based on how popular a song is.

The Main Parts

Frequency Map: This is a simple counter. It keeps track of how many times each "song" (number) has been played.

Groups Map (The Piles): Instead of one big stack, you have many small stacks.

Stack 1 is for songs appearing for the 1st time.

Stack 2 is for songs appearing for the 2nd time.

Stack 3 is for songs appearing for the 3rd time, and so on.

MaxFreq: This is just a pointer that tells you which stack is the highest one currently in use.

How Push Works

When you push a number (let's say it's the 3rd time you've seen it):

You update your counter to show this number has now appeared 3 times.

You put this number into the Stack 3 pile.

You make sure your "highest pile" pointer is set to at least 3.

How Pop Works

When you pop, you always look at the highest pile available (the one pointed to by maxFreq).

You take the top item off that highest pile.

You go to your counter and subtract 1 from that number's total count (since one instance of it is now gone).

If that highest pile is now totally empty, you move your maxFreq pointer down by one level. */
class FreqStack() {

    private var maxFreq = 0
    private val freqMap = HashMap<Int, Int>()
    private val groups = HashMap<Int, Stack<Int>>()

    fun push(x: Int) {
        // Update the frequency of this number
        val f = (freqMap[x] ?: 0) + 1
        freqMap[x] = f

        // Update max frequency seen so far
        maxFreq = max(maxFreq, f)

        // Add the number to the stack corresponding to its current frequency computeIfAbsent creates a new Stack if one doesn't exist for this frequency
        groups.computeIfAbsent(f) { Stack<Int>() }.push(x)
    }

    fun pop(): Int {
        // Get the top element from the stack of the highest frequency
        val x = groups[maxFreq]!!.pop()

        // Decrease the frequency of this number in our map
        freqMap[x] = freqMap[x]!! - 1

        // If the stack for the max frequency is now empty, lower the max frequency
        if (groups[maxFreq]!!.isEmpty()) {
            maxFreq--
        }

        return x
    }

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * val obj = FreqStack()
 * obj.push(`val`)
 * val param_2 = obj.pop()
 */
