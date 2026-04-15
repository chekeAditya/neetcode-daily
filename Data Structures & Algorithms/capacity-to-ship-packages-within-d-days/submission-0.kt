class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var minimalWeight = Int.MAX_VALUE
        
        var r = 0
        var l = 0

        for(i in weights){
            l = maxOf(l, i)
            r += i
        }

        while(l <= r){
            val mid = (l + r) / 2
            if(canShipCarryKWeight(mid, weights) <= days) {
                minimalWeight = min(mid, minimalWeight)
                r = mid - 1
            } else l = mid + 1
        }
        return minimalWeight
    }

    fun canShipCarryKWeight(maxCapacity : Int, weights: IntArray) : Int {
        var days = 1
        var load = 0
        for(w in weights) {
            if(load + w > maxCapacity) {
                days++
                load = 0
            }

            load += w
            
        }
        return days
    }
}
