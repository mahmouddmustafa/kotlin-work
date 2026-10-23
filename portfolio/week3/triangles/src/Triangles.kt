// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

typealias Triangle = Triple<Double,Double,Double>   

// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle(tri: Triangle): Boolean {   // Checking whether the 3 side lengths can form a triangle
    val sideA = tri.first
    val sideB = tri.second
    val sideC = tri.third

    // Must ensure each side is larger than the sum of the other two sides
    return sideA < sideB + sideC &&
           sideB < sideA + sideC &&
           sideC < sideA + sideB
}

fun triangleArea(tri: Triangle): Double {       // Calculates area of triangle using Heron's formula
    require(isValidTriangle(tri)) { "Invalid Triangle" }    // IllegalArgumentException if the triangle is invalid

    val sideA = tri.first
    val sideB = tri.second
    val sideC = tri.third

    val semiPer = (sideA + sideB + sideC) / 2.0  // Caclulating the semi perimeter

    return sqrt(semiPer * (semiPer - sideA) * (semiPer - sideB) * (semiPer - sideC))                                      // Heron's formula
}