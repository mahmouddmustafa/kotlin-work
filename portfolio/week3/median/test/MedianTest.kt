// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.floats.plusOrMinus

const val tolerance = 0.000001f

@Suppress("Unused")
class MedianTest : FreeSpec({
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf())
        }
    }
    // A list containing one value will have that value as its median
    "Median of on value" {
        meidan(listOf(5.0f)) shouldBe (5.0f plusOrMinus tolerance)
    }

    // An even list uses the mean of the two middle value
    "Median of even sized lists" {
        median(listOf(1.0f, 3.0f, 5.0f, 7.0f)) shouldBe (4.0f plusOrMinus tolerance)
    }

    // An odd list has only one middle value once sorted
    "Median of odd sized lists" {
        median(listOf(1.0f, 3.0f, 5.0f)) shouldBe (3.0f plusOrMinus tolerance)
    }

    // An unsorted list is sorted before findidng the median
    "unsorted list" {
        median(listOf(9.0f, 1.0f, 5.0f, 3.0f, 7.0f)) shouldBe (5.0f plusOrMinus tolerance)
    }
})
