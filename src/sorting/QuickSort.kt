package sorting

import java.util.Collections.swap
import java.util.concurrent.ThreadLocalRandom

// 3 sections
// [start - i - 1] contains numbers less than and equal to pivot
// [i - curr - 1] contains numbers greater than pivot
// [curr = end - 1] unexplored section of the array
// [end] is pivot
fun newPartitionIndex(arr: List<Int>, start: Int, end: Int, pIndex: Int): Int {
    swap(arr, pIndex, end)
    val pivot = arr[end]
    var i = start
    for (curr in start until end) {
        if (arr[curr] <= pivot) {
            swap(arr, i++, curr)
        }
    }
    swap(arr, i, end)
    return i
}


fun main() {
    val list = listOf(10, 25, 812, 3, 15, 19, 5, 233, 667)
    quickSort(list, 0, list.size - 1)
    println(list)
}

fun quickSort(list: List<Int>, start: Int, end: Int) {
    if (start == end || start == end + 1) return
    val pivotIndex = choosePivot(list, start, end)
    val partitionIndex = newPartitionIndex(list, start, end, pivotIndex)
    quickSort(list, start, partitionIndex - 1)
    quickSort(list, partitionIndex + 1, end)
}

/**
 * Time complexity and Space complexity for the original
 * code on an input that has N unique values in increasing order
 * worst case is N^2
 */
fun choosePivot(list: List<Int>, start: Int, end: Int): Int {
    return ThreadLocalRandom.current().nextInt(start, end + 1)
}
