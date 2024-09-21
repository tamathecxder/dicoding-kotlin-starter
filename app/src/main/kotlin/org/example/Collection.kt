package org.example

fun main() {
    val numberList = listOf(1, 2, 3, 4, 5)
    val charList = listOf('a', 'b', 'c')

    println(numberList[0])
    println(charList)

    val setA = setOf(1, 2, 4, 2, 1, 5)
    val setB = setOf(1, 2, 4, 5)
    println(setA == setB)
    print(5 in setA)

    val setC = setOf(1, 5, 7)
    val union = setA.union(setC)
    val intersect = setA.intersect(setC)

    println(union)
    println(intersect)

    // mutable
    val mutableSet = mutableSetOf(1, 2, 4, 2, 1, 5)
    //mutableSet[2] = 6 // tidak bisa mengubah mutableSet
    mutableSet.add(6) // menambah item di akhir set
    mutableSet.remove(1) //menghapus item yang memiliki nilai 1

    val numbers = setOf("one", "two", "three")
    val numbers2 = setOf("three", "four")

    // merge differences
    println((numbers - numbers2) union (numbers2 - numbers))

    val capital = mapOf(
        "Jakarta" to "Indonesia",
        "London" to "England",
        "New Delhi" to "India"
    )

    val capitalKeys = capital.keys
    val capitanValues = capital.values

    println(capital["Jakarta"])
    println(capital.getValue("Jakarta"))

    val mutableCapital = capital.toMutableMap()
    mutableCapital.put("Amsterdam", "Netherlands")
    mutableCapital.put("Berlin", "Germany")

    // Collections Operations
    val numberList2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenList = numberList2.filter { it % 2 == 0 }
    // val evenList = numberList2.filterNot { it % 2 == 0 }

    println(evenList)

    val numberList3 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val multipliedBy5 = numberList3.map { it * 5 }

    println(multipliedBy5)
    print(numberList.count())

    val numberList4 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val firstOddNumber = numberList4.find { it % 2 == 1 }
    val firstOrNullNumber = numberList4.firstOrNull { it % 2 == 3 }

    println(firstOddNumber)
    println(firstOrNullNumber)

    val numberList5 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val moreThan10 = numberList5.first { it > 10 }
    print(moreThan10)
}

