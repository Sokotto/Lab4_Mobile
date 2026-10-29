class FixedBuffer<T>(private val capacity: Int) {
    private val items = ArrayList<T>(capacity)
    init {
        require(capacity > 0) { "Емкость должна быть положительной" }
    }
    fun add(item: T): Boolean {
        if (isFull()) return false
        items.add(item)
        return true
    }
    fun get(index: Int): T? = items.getOrNull(index)
    fun isFull(): Boolean = items.size >= capacity
    fun freeSpace(): Int = capacity - items.size
}

fun main() {
    val buffer = FixedBuffer<String>(3)
    println(buffer.add("A"))
    println(buffer.add("B"))
    println("Свободно: ${buffer.freeSpace()}")
    println(buffer.add("C"))
    println("Полон: ${buffer.isFull()}")
    println(buffer.add("D"))

    println(buffer.get(0))
    println(buffer.get(2))
    println(buffer.get(5))

    val numbers = FixedBuffer<Int>(2)
    numbers.add(10)
    println(numbers.get(0))
    println("Свободно: ${numbers.freeSpace()}")
}
