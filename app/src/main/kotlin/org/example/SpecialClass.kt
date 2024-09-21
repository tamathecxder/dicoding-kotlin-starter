package org.example

class User(val name : String, val age : Int)

data class DataUser(val name : String, val age : Int)

class House {
    val buildingArea = 100
    val totalRooms = 4

    inner class Room {
        val totalRooms = 2
        fun measureRoomArea() {
            println(buildingArea / this@House.totalRooms)
            println(buildingArea/ totalRooms)
        }
    }
}

enum class Color(val value: Int) {
    RED(0xFF0000){
        override fun printValue() {
            println("value of RED is $value")
        }
    },
    GREEN(0x00FF00){
        override fun printValue() {
            println("value of GREEN is $value")
        }
    },
    BLUE(0x0000FF){
        override fun printValue() {
            println("value of BLUE is $value")
        }
    };

    abstract fun printValue()
}

sealed class Result {
    sealed class Success(val data: Any) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

// Singleton
object CentralLibrary {
    fun borrowBookById(id: Int) {
        print("Book with $id has been borrowed")
    }
}

class Library {
    companion object{
        fun borrowBookById(id: Int) {
            println("Book with $id has been borrowed")
        }
    }
}

class MyLibrary {
    // Const 'val' are only allowed on top level, in named objects, or in companion objects
    // const val LIBRARY_NAME = "Dicoding Library"

    fun totalBook() {
        print("Total book in $LIBRARY_NAME is unlimited")
    }

    companion object{
        const val LIBRARY_NAME = "Dicoding Library"
    }
}

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

    val house = House()
    val room = house.Room()
    room.measureRoomArea()

    val colorRed = Color.RED
    val colorGreen = Color.GREEN
    val colorBlue = Color.BLUE

    val colors: Array<Color> = Color.values()
    colors.forEach { color ->
        print("$color ")
    }

    val color: Color = Color.valueOf("RED")
    println("Color is $color")
    println("Color value is ${color.value.toString(16)}")

    print("Position is ${color.ordinal}")

    when(color){
        Color.RED -> print("Color is Red")
        Color.BLUE -> print("Color is Blue")
        Color.GREEN -> print("Color is Green")
    }

    val result: Result = Result.Error("Oops!")
    when (result) {
        is Result.Success -> {
            println("Success: ${result.data}")
        }
        is Result.Error -> {
            println("Error: ${result.message}")
        }
        is Result.Loading -> {
            println("Loading...")
        }
    }

    CentralLibrary.borrowBookById(2)
    Library.borrowBookById(1)
    Library.Companion.borrowBookById(5)
    val libName = MyLibrary.LIBRARY_NAME;
    println(libName)

}