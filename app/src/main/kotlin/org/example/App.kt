/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example

class App {
    val greeting: String
        // single line comment
        get() {
            /**
             * Multi line comment
             */
            return "Hello World!"
        }
}

fun main() {
    val marga: String = "Simanjuntak"
    var fullName = "Aceng Solihin";

    println(fullName + marga);

    // It started like this.
    var value = 1
    value = value + 2

    // It will be like this.
    var anotherValue = 1
    anotherValue += 2

    // The value of value and anotherValue will be the same value, which is 3
    println(value)
    println(anotherValue)
    println(App().greeting)


    // datatype: CHAR
    var vocal = 'A'

    println("Vocal " + vocal++)
    println("Vocal " + vocal++)
    println("Vocal " + vocal++)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)
    println("Vocal " + vocal--)

    val text  = "Kotlin"
    for (char in text){
        print("$char ")
    }

    val statement = "Kotlin is \"Awesome!\""

    val line = """
        Line 1
        Line 2
        Line 3
        Line 4
    """.trimIndent()

    print(line)

    val name = "Kotlin"
    print("My name is $name")

    val openHours = 7
    val now = 7
    val office: String
    office = if (now > 7) {
        "Office already open"
    } else if (now == openHours){
        "Wait a minute, office will be open"
    } else {
        "Office is closed"
    }

    print(office)
}

