package org.example

class User(val name : String, val age : Int)

data class DataUser(val name : String, val age : Int)

fun main() {
    val user = User("Asep", 20)
    val dataUser = DataUser("nrohmen", 17)
    val dataUser2 = DataUser("Agus", 19)
    val dataUser3 = DataUser("dimas", 24)
    val dataUser4 = dataUser.copy()
    val dataUser5 = dataUser.copy(age = 18)

    println(user)
    println(dataUser)
    println(dataUser2.equals(dataUser3))
    println(dataUser4)
    println(dataUser5)

    val name = dataUser.component1()
    val age = dataUser.component2()
    val (name2, age2) = dataUser2

    println("My name is $name, I am $age years old")
    println("My name is $name2, I am $age2 years old")
}