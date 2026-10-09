// COMP2850 Portfolio: Week 1
// Program to compute area of a triangle

import kotlin.math.sqrt
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size < 3) {            //Checks all 3 sides were input
        println("Error: values for a, b, c required on command line")
        exitProcess(1)
    }

    // Changes the command line args to FP numbers
    val sideA = args[0].toDouble()
    val sideB = args[1].toDouble()
    val sideC = args[2].toDouble()

    // Heron's formula: SemiPerimete = (sideA + sideB + sideC) / 2 then Area = sqrt(SemiPerimeter(SemiPerimeter - sideA)(SemiPerimeter - sideB)(SemiPerimeter - sidec))
    val semiP = (sideA + sideB + sideC) / 2
    val triArea = sqrt(semiP * (semiP - sideA) * (semiP - sideB) * (semiP - sideC))

    // Formatting the print to 5 d.p.
    println("Area = %.5f".format(triArea))
}