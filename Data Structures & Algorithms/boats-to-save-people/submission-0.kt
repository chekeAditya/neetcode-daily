class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val n = people.size
        var i = 0
        var j = n-1
        var noOfBoats = 0
        people.sort()

        while(i <= j){
            if(people[j] == limit) {
                noOfBoats++
                j--
            } else if(people[i] + people[j] <= limit){
                noOfBoats++
                i++
                j--
            } else if (people[i] + people[j] > limit) {
                noOfBoats++
                j--
            } else {
                i++
            }
        }
        return noOfBoats
    }
}
