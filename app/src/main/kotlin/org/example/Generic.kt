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

abstract class VehicleV2(wheel: Int)
class Car(speed: Int) : VehicleV2(4)
class MotorCycle(speed: Int) : VehicleV2(2)

// Covariant
interface ListV2<out E> : Collection<E> {
    operator fun get(index: Int): E
}

// Contravariant
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

interface Binatang {}

class Kandang<out T : Binatang>(private val hewan: T) {
    fun dapatkanHewan(): T {
        return hewan
    }
}

class PenjagaKandang<in T : Binatang> {
    fun urusKandang(hewan: T) {
        // Melakukan sesuatu dengan kandang yang berisi hewan
    }
}

fun main() {
    val numbers = (1..100).toList()
    print(numbers.slice<Int>(1..10))

//    val numbers1 = ListNumber<Long>()
//    val numbers2 = ListNumber<Int>()
//    val numbers3 = ListNumber<String>() // err: Type argument is not within its bounds

    val car = Car(200)
    val motorCycle = MotorCycle(100)
    var vehicle: VehicleV2 = car
    vehicle = motorCycle

    val carList = listOf(Car(100) , Car(120))
    val vehicleList = carList

//    val kandangKucing: Kandang<Cat> = Kandang(Cat())
//    val kandangBinatang: Kandang<Binatang> = kandangKucing // Covariant, dapat di-substitute
//
//    val penjagaBinatang: PenjagaKandang<Binatang> = PenjagaKandang<Binatang>()
//    val penjagaKucing: PenjagaKandang<Kucing> = penjagaBinatang // Contravariant, dapat di-substitute
}