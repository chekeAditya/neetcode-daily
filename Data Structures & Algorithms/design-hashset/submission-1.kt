class MyHashSet() {

    val list = ArrayList<Int>(107)

    fun add(key: Int) {
        if (!(list.contains(key))) list.add(key)
    }

    fun remove(key: Int) {
        list.remove(key)
    }

    fun contains(key: Int): Boolean {
        return list.contains(key)
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
