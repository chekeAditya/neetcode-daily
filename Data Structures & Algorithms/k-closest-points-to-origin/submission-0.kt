class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    // Create a Max-Heap to keep track of the 'k' closest points.
    // The comparator calculates the squared Euclidean distance: x^2 + y^2.
    // By comparing distB to distA, the point with the largest distance 
    // stays at the top of the heap.
    val maxHeap = PriorityQueue<IntArray> { a, b ->
        val distA = (a[0] * a[0]) + (a[1] * a[1])
        val distB = (b[0] * b[0]) + (b[1] * b[1])
        distB.compareTo(distA)
    }

    // Iterate through each point in the input array.
    for (point in points) {
        // Add the current point to the Max-Heap.
        maxHeap.offer(point)
        
        // If the heap size exceeds 'k', remove the top element.
        // Since it is a Max-Heap, the point with the largest distance 
        // among the current elements is removed. This ensures only the 
        // 'k' smallest (closest) distances are retained.
        if (maxHeap.size > k) {
            maxHeap.poll()
        }
    }

    // Initialize the result array to hold exactly 'k' points.
    val result = Array(k) { IntArray(2) }
    var index = 0
    
    // Empty the heap and store the remaining 'k' closest points into the result.
    while (!maxHeap.isEmpty()) {
        result[index++] = maxHeap.poll()
    }

    return result
}
}
