package org.example

typealias Arithmetic = (Int, Int) -> Int
typealias Concat = ((String?, String?) -> String)?

inline fun printResult(value: Int, sum: (Int) -> Int) {
    val result = sum(value)
    println(result)
}

class PersonV2(val name: String, val age: Int) {
}

val sumV2: (Int, Int) -> Int = ::count
fun count(valueA: Int, valueB
: Int): Int {
    return valueA + valueB
}

fun Int.isEvenNumber() = this % 2 == 0

var messagex: String = "Test"

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

    printResult(10, { value ->
        value + value
    })

    printResult(20, { value ->
        value + value
    })

    fun buildString(action: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.action()
        return stringBuilder.toString()
    }

    val messages = buildString {
        append("Hello ")
        append("from ")
        append("lambda ")
    }

    println(messages)

    // receiver "this"
    val buildString = StringBuilder().apply {
        append("Hello ")
        append("Kotlin ")
    }

    // receiver "it"
    val text = "Hello"
    text.let {
        val message = "$it Kotlin"
        println(message)
    }

    // apply: Menginisialisasi objek dan mengatur propertinya, kemudian mengembalikan objek tersebut
    val personApply = PersonV2("John", 25).apply {
        println("apply: Initializing $name, age $age")
    }

    // also: Melakukan tindakan tambahan pada objek dan mengembalikan objek tersebut
    val personAlso = PersonV2("Jane", 30).also {
        println("also: Initializing ${it.name}, age ${it.age}")
    }

    // let: Melakukan operasi pada objek dan mengembalikan hasil operasi tersebut
    val personLet = PersonV2("Bob", 22).let {
        println("let: Initializing ${it.name}, age ${it.age}")
        "Result: ${it.name} is ${it.age} years old" // return value
    }
    println("let result: $personLet")

    // run: Menjalankan blok kode pada objek dan mengembalikan hasil blok kode tersebut
    val personRun = PersonV2("Alice", 28).run {
        println("run: Initializing $name, age $age")
        "Result: $name is $age years old" // return value
    }
    println("run result: $personRun")

    // with: Menggunakan objek sebagai receiver untuk blok kode dan mengembalikan hasil blok kode tersebut
    val personWithResult = with(PersonV2("Charlie", 35)) {
        println("with: Initializing $name, age $age")
        "Result: $name is $age years old" // return value
    }

    // run
    val result1 = text.run {
        val from = this
        val to = this.replace("Hello", "Kotlin")
        "replace text from $from to $to"
    }
    println("result : $result1")

    // with
    val message2 = "Hello Kotlin!"
    val result2 = with(message2) {
        "First character is ${this[0]}" +
                " and last character is ${this[this.length - 1]}"
    }

    println(result2)

    // apply
    val message3 = StringBuilder().apply {
        append("Hello ")
        append("Kotlin!")
    }

    println(message3.toString())

    // also
    val message7: String? = null
    message7?.let {
        val length = it.length * 2
        val text = "text length $length"
        println(text)
    } ?: run {
        val text = "message is null"
        println(text)
    }

    // let
    val text1 = "Hello Kotlin"
    val result = text1.also {
        println("value length -> ${it.length}")
    }

    println("text -> $result")



    val numbers = 1.rangeTo(10)
    val evenNumbers = numbers.filter(Int::isEvenNumber)

    println(evenNumbers)



    println(::messagex.name)
    println(::messagex.get())

    ::messagex.set("Kotlin Academy")

    println(::messagex.get())

    fun sum(valueA: Int, valueB: Int, valueC: Int): Int {
        fun validateNumber(value: Int) {
            if (value == 0) {
                throw IllegalArgumentException("value must be better than 0")
            }
        }

        validateNumber(valueA)
        validateNumber(valueB)
        validateNumber(valueC)

        return valueA + valueB + valueC
    }

    println(sum(20, 50, 90))

    tailrec fun factorial(n: Int, result: Int = 1): Int {
        val newResult = n * result
        return if (n == 1) {
            newResult
        } else {
            factorial(n - 1, newResult)
        }
    }

    println(factorial(2, 1))
}