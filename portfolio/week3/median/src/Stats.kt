// Task 7.7.1: statistics functions
fun median(data: List<Float>): Float {
    val sortd = data.sorted()
    val mid = sortd.size / 2

    return if (sortd.size % 2 == 1) {
        sortd[mid]
    } else {
        (sortd[mid - 1] + sortd[mid]) / 2
    }
}

fun dispsStat(data: List<Float>) {
    println("Min: ${data.min()}")
    println("Max: ${data.max()}")
    println("Mean: ${data.average()}")
    println("Median: ${median(data)}")
}