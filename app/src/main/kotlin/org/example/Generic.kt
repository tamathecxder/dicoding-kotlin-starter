package org.example

interface List<T> {
    operator fun get(index: Int): T
}

class LongList : List<Long>{
    override fun get(index: Int): Long {
        return this[index]
    }
}

class ArrayList<T> : List<T>{
    override fun get(index: Int): T {
        return this[index]
    }
}

//public fun <T> List<T>.slice(indices: Iterable<Int>): List<T> {
//    /*...*/
//}

fun main() {
    val numbers = (1..100).toList()
    print(numbers.slice<Int>(1..10))
}