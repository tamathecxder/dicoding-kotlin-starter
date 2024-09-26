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


class ListNumber<T : Number>(private val items: List<T>) : List<T> {
    override fun get(index: Int): T {
        if (index < 0) {
            throw IndexOutOfBoundsException("Index: $index")
        }
        return items[index]
    }
}

fun main() {
    val numbers = (1..100).toList()
    print(numbers.slice<Int>(1..10))

//    val numbers1 = ListNumber<Long>()
//    val numbers2 = ListNumber<Int>()
//    val numbers3 = ListNumber<String>() // err: Type argument is not within its bounds
}