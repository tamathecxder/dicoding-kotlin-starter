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

abstract class AnimalV2(val name: String, val weight: Double, val age: Int, val isCarnivore: Boolean){
    open fun eat(){
        println("$name sedang makan!")
    }

    open fun sleep(){
        println("$name sedang tidur!")
    }
}

interface IFly {
    fun fly()
    val numberOfWings: Int
}

class Bird(override val numberOfWings: Int) : IFly {
    override fun fly() {
        if(numberOfWings > 0) println("Flying with $numberOfWings wings")
        else println("I'm Flying without wings")
    }
}

abstract class AnimalV3 {
    //default value not allowed
    abstract val age: Int //must be overridden

    //default value allowed
    open val isEating = true //optional to be overridden
    val isRespire = true //can not be overridden
}

interface IWalk {
    //default value not allowed
    val numberOfLeg: Int //must be overridden
    fun walk() //must be overridden
}

interface IDrink {
}

class Camel : AnimalV3(), IWalk, IDrink {
    override val age: Int = 7   // this property must exist, try to remove it
    override val isEating = true // this property optional, try to remove it
    override val numberOfLeg = 2 // this property must exist, try to remove it
    override fun walk() { // this method  must exist, try to remove it
        println("Camel can walk")
    }
}

class Dog(pName: String, pWeight: Double, pAge: Int, pIsCarnivore: Boolean)
    : AnimalV2(pName, pWeight, pAge, pIsCarnivore) {

    fun playWithHuman() {
        println("$name bermain bersama Manusia !")
    }

    override fun eat(){
        super.eat();
        println("$name sedang memakan ikan !")
    }

    override fun sleep() {
        println("$name sedang tidur di bantal !")
    }
}

class Vehicle {
    var name: Any by DelegateGenericClass()
    var weight: Any by DelegateGenericClass()
    var age: Any by DelegateGenericClass()

    // Extension Properties
    val Int.slice: Int get() = this / 2

    val Int?.sliceSafe: Int
        get() = this?.div(2) ?: 0

    fun handlePrint() {
        println("Sliced Value: " + 20.slice)
        println(20 sum 80)
    }

    infix fun Int.sum(value: Int): Int {
        return this + value
    }
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
    urus.handlePrint()

    var husky = Dog("Husky", 15.20, 2, false)
    println(husky.eat())

    val camel = Camel()
    camel.walk()

    // Extension Functions
    fun Int.printInt() {
        print("value $this")
    }

    10.printInt()
}
