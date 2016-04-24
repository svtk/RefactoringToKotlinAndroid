package com.svtk.refactoringtokotlinandroid

fun fizzBuzz(i: Int): String {
    return if (i % 15 == 0) "FizzBuzz"
    else if (i % 3 == 0) "Fizz"
    else if (i % 5 == 0) "Buzz"
    else "$i"
}

fun fizzBuzz2(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun main(args: Array<String>) {
    for (i in 1..100) {
        print("${fizzBuzz(i)} ")
    }
}
