package org.example

import kotlin.reflect.KProperty

class DelegateName {
    private var value: String = "Default"

    operator fun getValue(classRef: Any?, property: KProperty<*>) : String {
        println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
        return value
    }

    operator fun setValue(classRef: Any?, property: KProperty<*>, newValue: String){
        println("Fungsi ini sama seperti setter untuk properti ${property.name} pada class $classRef")
        println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
        value = newValue
    }
}

class Animal() {
    var name: String by DelegateName()

    var weight: Double = 3.2
    var age: Int = 2
    var isMammal: Boolean = true

    // Late Init
    lateinit var description: String;

    // Lazy property
    val fullName: String by lazy {
        "Dicoding Miaw"
    }

    fun eat(){
        println("$name makan!")
    }

    fun sleep() {
        println("$name tidur!")
    }
}

class Hero() {
    var name: String by DelegateName()
}

class Person() {
    var name: String by DelegateName()
}

class DelegateGenericClass {
    private var value: Any = "Default"

    operator fun getValue(classRef: Any, property: KProperty<*>): Any {
        println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
        return value
    }

    operator fun setValue(classRef: Any, property: KProperty<*>, newValue: Any) {
        println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
        value = newValue
    }
}

class Vehicle {
    var name: Any by DelegateGenericClass()
    var weight: Any by DelegateGenericClass()
    var age: Any by DelegateGenericClass()
}

fun main() {
    val cat = Animal();
    println("Nama: ${cat.name}, Berat: ${cat.weight}, Umur: ${cat.age}, mamalia: ${cat.isMammal}")
    cat.eat()
    cat.sleep()

    val animal = Animal()
    animal.name = "Dicoding Miaw"
    println("Nama Hewan: ${animal.name}")

    val person = Person()
    person.name = "Dimas"
    println("Nama Orang: ${person.name}")

    val hero = Hero()
    hero.name = "Gatotkaca"
    println("Nama Pahlawan: ${hero.name}")

    val urus = Vehicle()
    urus.name = "Toyota Urus"
}
