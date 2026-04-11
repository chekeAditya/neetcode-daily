class StockSpanner() {

    val st = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var span = 1
        if (st.isEmpty()){
            st.push(Pair(price, 1))
            return 1
        }
        var element = if (st.isNotEmpty()) st.peek().first else Int.MAX_VALUE

        while (element <= price) {
            span += st.peek().second
            st.pop()
            element = if (st.isNotEmpty()) st.peek().first else Int.MAX_VALUE
        }

        st.push(Pair(price, span))
        return span
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * val obj = StockSpanner()
 * val param_1 = obj.next(price)
 */
