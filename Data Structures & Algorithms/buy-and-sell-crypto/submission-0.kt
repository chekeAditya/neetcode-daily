class Solution {
    fun maxProfit(prices: IntArray): Int {
        var purchase = prices[0]
        var maxProfit = 0
        for(price in prices){
            if(price < purchase) purchase = price
            else maxProfit = max(maxProfit, price - purchase)
        }
        return maxProfit
    }
}
