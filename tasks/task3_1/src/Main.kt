// Task 3.1: command line arguments

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Error: exactly two arguments required")
        exitProcess(1)
    } else {
        println(args[0])
        println(args[1])
    }
}