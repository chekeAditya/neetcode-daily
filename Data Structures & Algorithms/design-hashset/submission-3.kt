class MyHashSet() {

    val list = IntArray(1000000) { -1 }

    fun add(key: Int) {
        list[key] = key
    }

    fun remove(key: Int) {
        list[key] = -1
    }

    fun contains(key: Int): Boolean {
        return list[key] != -1
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
