// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

// Represents a triangle by using all 3 sidex lengths
// typealias provides a meaningful name to an existing type (doesnt create a new one)
typealias Triangle = Triple<Double,Double,Double>   

// Add isValidTriangle() and triangleArea() functions here

// Checks whether the 3 sides can firm a proper triangle
fun isValidTriangle(tri: Triangle): Boolean {   
    val sideA = tri.first
    val sideB = tri.second
    val sideC = tri.third

    // Must ensure each side is smaller than the sum of the other two sides
    return sideA < sideB + sideC &&
           sideB < sideA + sideC &&
           sideC < sideA + sideB
}

fun triangleArea(tri: Triangle): Double {       // Calculates area of triangle using Heron's formula
    // checks if a condition is true and if otherwise throws an IllegalArgumentException that it is invalid
    require(isValidTriangle(tri)) { "Invalid Triangle" }    

    val sideA = tri.first
    val sideB = tri.second
    val sideC = tri.third

    val semiPer = (sideA + sideB + sideC) / 2.0  // Caclulating the semi perimeter

    return sqrt(semiPer * (semiPer - sideA) * (semiPer - sideB) * (semiPer - sideC))                                      // Heron's formula
}