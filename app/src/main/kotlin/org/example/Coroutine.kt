package org.example

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun initCoroutine() = runBlocking{
    launch {
        delay(1000L)
        println("Coroutines!")
    }
    println("Hello,")
    delay(2000L)
}

suspend fun getCapital(): Int {
    delay(1000L)
    return 50000
}

suspend fun getIncome(): Int {
    delay(1000L)
    return 75000
}

fun asyncProcess() = runBlocking {
    val timeOne = measureTimeMillis {
        val capital = getCapital()
        val income = getIncome()
        println("Your profit is ${income - capital}")
    }

    val timeTwo = measureTimeMillis {
        val capital = async { getCapital() }
        val income = async { getIncome() }
        println("Your profit is ${income.await() - capital.await()}")
    }

    println("Completed in $timeOne ms vs $timeTwo ms")

}

// use launch():
fun handleLauch() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) { // can be used later
        delay(1000L)
        println("Start new job!")
    }

    // not wait the job and will immediately called
    job.start()
    println("Other task")

    // wait the job until finished and then it will run
    job.join()
    println("Other task but use join method")
}


// use Job():
fun handleJob() = runBlocking {
    val job = Job()
}

fun main() {
    initCoroutine()
    asyncProcess()

    handleLauch()
    handleJob()
}