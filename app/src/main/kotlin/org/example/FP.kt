package org.example

typealias Arithmetic = (Int, Int) -> Int
typealias Concat = ((String?, String?) -> String)?

fun main() {
    val sum: Arithmetic = { valueA, valueB -> valueA + valueB }

    val multiply: Arithmetic = { valueA, valueB -> valueA * valueB }

    val sumResult = sum.invoke(10, 10)
    val multiplyResult = multiply.invoke(20, 20)
    val sumResultDirect = sum(5, 5)
    val multiplyResultDirect = multiply(2, 2)

    println(sumResult)
    println(multiplyResult)
    println(sumResultDirect)
    println(multiplyResultDirect)

    val strA = "Example String And"
    val strB = null

    val doConcat: Concat = { a, b -> "$a $b" }

    val strResult = doConcat?.invoke(strA, strB)

    println(strResult)

    val message :(String) -> String = { name: String ->
        "Hello $name"
    }

    println(message("Asep"))

    val ranges = 1.rangeTo(10) step 3
    ranges.forEachIndexed() { index, value ->
        println("value is $value! ($index)")
    }
}