package sorting

fun main() {
    val list = mutableListOf(1, 56, 43, 25, 89, 2, 53, 23)
    mergeSort(list, 0, list.size - 1)
    list.forEach { print("$it ") }
}

fun mergeSort(list: MutableList<Int>, start: Int, end: Int) {
    if (start >= end) return
    val mid = start + (end - start) / 2
    mergeSort(list, start, mid)
    mergeSort(list, mid + 1, end)
    merge(list, start, mid, end)
}

fun merge(list: MutableList<Int>, start: Int, mid: Int, end: Int) {
    val temp1 = list.subList(start, mid + 1).toList()
    val temp2 = list.subList(mid + 1, end + 1).toList()
    val n1 = mid - start + 1
    val n2 = end - mid
    var index1 = 0
    var index2 = 0
    var index = start
    while (index1 < n1 && index2 < n2) {
        if (temp1[index1] <= temp2[index2]) {
            list[index] = temp1[index1]
            index1++
            index++
        } else {
            list[index] = temp2[index2]
            index2++
            index++
        }
    }
    while (index1 < n1) {
        list[index] = temp1[index1]
        index1++
        index++
    }
    while (index2 < n2) {
        list[index] = temp2[index2]
        index2++
        index++
    }
}
