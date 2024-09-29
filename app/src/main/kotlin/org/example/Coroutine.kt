package org.example

import kotlinx.coroutines.*
import kotlin.coroutines.cancellation.CancellationException
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

// cancel job
@InternalCoroutinesApi
fun handleCancel() = runBlocking {
    val job = launch {
        delay(5000)
        println("Start new job!")
    }

    delay(2000)
    job.cancel(cause = CancellationException("Time is up"))
    println("Cancelling job...")
    if (job.isCancelled){
        println("Job is cancelled because: ${job.getCancellationException().message}")
    }
}

fun handleDeferredJob() = runBlocking {
    val capitalDeferred = async { getCapital() }
    val incomeDeferred = async { getIncome() }

    try {
        val capital = capitalDeferred.await()
        val income = incomeDeferred.await()
        println("Your profit is ${income - capital}")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}

fun coroutineDispatchers() = runBlocking {
    // default
    launch(Dispatchers.Default){
        // TODO: Implement suspending lambda here
    }

    // IO
    launch(Dispatchers.IO) {
        // TODO: Implement suspending lambda here
    }

    // Unconfined
    launch(Dispatchers.Unconfined) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()
}

@InternalCoroutinesApi
fun main() {
//    initCoroutine()
//    asyncProcess()
//
//    handleLauch()
//    handleJob()

//    handleCancel()

//    handleDeferredJob()

    coroutineDispatchers()
}
