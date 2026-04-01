class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val n = people.size
        var i = 0
        var j = n-1
        var noOfBoats = 0
        people.sort()

        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++
            }
            noOfBoats++
            j--
        }
        return noOfBoats
    }
}
