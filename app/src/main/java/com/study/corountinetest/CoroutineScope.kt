package com.study.corountinetest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import kotlin.coroutines.EmptyCoroutineContext


suspend fun suspendTest(): String {
    var string: String;
    withContext(Dispatchers.IO) {
        delay(1000)
        println()
        string = "1"
    }
    return string
}

fun main() = runBlocking<Unit>{



    val numbersFlow = flow<Int> {
        emit(1)
        emit(2)
    }

    val coroutineScope_1 = CoroutineScope(EmptyCoroutineContext)
    coroutineScope_1.launch {
        numbersFlow.collect{
            println(it)
        }
    }




//    val coroutineScope = CoroutineScope(Dispatchers.Default)

    val filter = arrayListOf("aaa", "bbb","a","1").filter {
        it == suspendTest()
    }

    val channel1 = Channel<Int>()
    //多处调用collect会报错
    channel1.consumeAsFlow()
    channel1.receiveAsFlow()
    val asFlow = filter.asFlow()
    //每次collect的时候才会有channel
    val channelFlow = channelFlow<Int> {
        send(1)
        awaitClose()
    }
    channelFlow.collect{

    }
    callbackFlow<Int> {
        //不调用会报错
        awaitClose()
    }

    asFlow.collect{

    }
    println(filter)



    val coroutineScope = CoroutineScope(EmptyCoroutineContext)

    val channel = Channel<Int>()
    coroutineScope.launch {
        println("1111")
        while (true) {
//            delay(1000)
//            println("22222")
//            channel.send(1)
//            val trySend = channel.trySend(1)
//            println("trySend: $trySend")
//            channel.close()

        }
    }
        launch() {
            while (true) {
//                println("33333")
//                val tryReceive = channel.tryReceive()
//                println(tryReceive)
//                println(channel.receive())
                //            channel.cancel()

            }
        }
    }


//    CoroutineScope(Dispatchers.Main).launch() {
//        val suspendTest = suspendTest()
//        // TODO: 做主线程操作
//
//    }



