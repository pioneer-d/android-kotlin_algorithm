package com.pioneer.algorithm.basic

fun main(){
    solution56(4, intArrayOf(1, 5, 2), intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)).apply {
        repeat(this.size){
            print("${this[it] }"+" ")
        }
    }

//    println(solution57(intArrayOf(12, 4, 15, 46, 38, -2, 15)))

//    solution58(intArrayOf(1, 2, 3, 4, 5), arrayOf(intArrayOf(1, 3), intArrayOf(0, 4))).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
//    solution59(intArrayOf(1, 2, 1, 2, 1, 10, 2, 1)).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
//    solution60(intArrayOf(0, 1, 2, 3, 4, 5), intArrayOf(4, 1, 2)).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
}

/** 아직 완료 X */
/** 리스트 자르기 */
fun solution56(n: Int, slicer: IntArray, num_list: IntArray): List<Int> {
    val returnList = mutableListOf<Int>()
    val startPoint = if (n == 1) 0 else slicer[0]
    val endPoint = if (n == 2) slicer.size-1 else slicer[1]
    val stepPoint = if (n == 4) slicer[2] else 1

    for (i in startPoint .. endPoint step stepPoint){
        returnList.add(num_list[i])
    }
    return returnList
}

/** 첫번째로 나오는 음수 */
fun solution57(num_list: IntArray): Int {
    var answer = -1
    for (i in 0 until num_list.size){
        if (num_list[i] < 0){
            answer = i
            break
        }
    }
    return answer
}

/** 배열 만들기 3 */
fun solution58(arr: IntArray, intervals: Array<IntArray>): List<Int> {
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()

    for (i in intervals[0][0] .. intervals[0][1]){ firstList.add(arr[i]) }
    for (i in intervals[1][0] .. intervals[1][1]){ secondList.add(arr[i]) }

    firstList.addAll(secondList)
    return firstList
}

/** 2의 영역 */
fun solution59(arr: IntArray): List<Int> {
    val answerList = mutableListOf<Int>()
    val tempList = mutableListOf<Int>()
    var twoCount = 0

    repeat(arr.size){
        when (twoCount){
            0 -> {
                if (arr[it] == 2) {
                    twoCount++
                    answerList.add(arr[it])
                }
            }
            1 -> {
                tempList.add(arr[it])
                if (arr[it] == 2) {
                    twoCount++
                    answerList.addAll(tempList)
                    tempList.clear()
                }
            }
            else -> {
                tempList.add(arr[it])
                if (arr[it] == 2) {
                    answerList.addAll(tempList)
                    tempList.clear()
                }
            }
        }
    }
    if (twoCount == 0) answerList.add(-1)

    return answerList
}

/** 배열 조각하기 */
fun solution60(arr: IntArray, query: IntArray): List<Int> {
    var answerList = arr.toList()
    repeat(query.size){
        answerList = if (it % 2 == 0){
            answerList.slice(0..query[it])
        } else {
            answerList.slice(query[it]..answerList.size-1)
        }
    }

    return answerList
}