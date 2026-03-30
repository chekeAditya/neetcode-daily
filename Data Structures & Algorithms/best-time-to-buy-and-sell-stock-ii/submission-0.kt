class Solution {
    fun maxProfit(prices: IntArray): Int {
        return optimal(prices)
    }

    fun bruteForce(prices : IntArray) : Int {
        val n = prices.size
        var bp = prices[0]
        var profit = 0
        for(i in 1 until n){
            if(prices[i] < bp) bp = prices[i]
            else if(prices[i] > bp){
                profit += prices[i] - bp
                bp = prices[i]
            }
        }
        return profit
    }

    // if todays profit is more then previous day profile then just add (todays profit - previous day profit)
    fun optimal(prices : IntArray) : Int {
        var profit = 0
        for(i in 1 until prices.size){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1]
            }
        }
        return profit
    }
}
