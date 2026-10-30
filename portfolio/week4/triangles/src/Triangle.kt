// COMP2850 Portfolio: Week 4
// Triangle class

// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

class Triangle(val sideA: Double, val sideB: Double, val sideC: Double) {

    // Initialiser that runs automatically when a Triangle instance or object is made
    // IllegalArgumentException if the triangle is inavlid i.e. not all side lenths form a triangle
    // Require throws an Error or ArgumentException if condition is false
    init{
        require(isValidTriangle()) { "Invalid Triangle" }
    }

    fun isValidTriangle(): Boolean { 
        // Must ensure each side is larger than the sum of the other two sides (Triangle Inequality Theorem)
        return sideA < sideB + sideC &&
            sideB < sideA + sideC &&
            sideC < sideA + sideB
    }

    // Computed property which calculates the perimeter
    val perimeter: Double
        get() = sideA + sideB + sideC

    // Computed property which calculates half of the perimeter
    val semiPerimeter: Double
        get() = perimeter / 2.0

    val area: Double       
        // Calculates area of triangle using Heron's formula
        get() = sqrt(
            semiPerimeter *
            (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC)
        )
    // Overrides Kotlin's default toString() method, returning the sides in the exact required format
    override fun toString(): String {
        return "Triangle($sideA, $sideB, $sideC)"
    }
}