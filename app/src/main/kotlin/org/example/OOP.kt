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

open class Animal(name: String, protected var weight: Double, age: Int){
    private var name: String
    private val age: Int
    private var isMammal: Boolean

    init {
        this.weight = if(weight < 0) 0.1 else weight
        this.age = if(age < 0) 0 else age
        this.name = name
        this.isMammal = false
    }

    constructor(name: String, weight: Double, age: Int, isMammal: Boolean) : this(name, weight, age) {
        this.isMammal = isMammal
    }
    // Late Init
    lateinit var description: String;

    // Lazy property
    val fullName: String by lazy {
        "Dicoding Miaw"
    }

    fun eat(){
        println(this.name + " makan!")
    }

    fun eat(typeFood: String) {
        println("$name memakan $typeFood!")
    }

    fun eat(typeFood: String, quantity: Double) {
        println("$name memakan $typeFood sebanyak $quantity grams!")
    }

    fun sleep() {
        println(this.name + "tidur!")
    }

    fun getName(): String {
        return name
    }

    fun setName(newName: String) {
        name = newName
    }
}

class Lion(pName: String, pWeight: Double, pAge: Int) : Animal(pName, pWeight, pAge) {}

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

internal class AnimalV2(val name: String)

class Vehicle {
    var name: Any by DelegateGenericClass()
    var weight: Any by DelegateGenericClass()
    var age: Any by DelegateGenericClass()
}

fun main() {
    val animal = Animal("Elephant", 100.24, 0, true)
    animal.eat("Grass", 19.9)
    println("Nama Hewan: ${animal.getName()}")

    val person = Person()
    person.name = "Dimas"
    println("Nama Orang: ${person.name}")

    val hero = Hero()
    hero.name = "Gatotkaca"
    println("Nama Pahlawan: ${hero.name}")

    val urus = Vehicle()
    urus.name = "Toyota Urus"
}
