package com.pioneer.algorithm.basic

import kotlin.math.max

fun main(){
//    println(solution66(intArrayOf(4, 2, 6, 1, 7, 6)))
//    solution67(arrayOf("nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx")).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
//    solution68(arrayOf("problemsolving", "practiceguitar", "swim", "studygraph"), booleanArrayOf(true, false, true, false)).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
//    println(solution69(intArrayOf(34, 5, 71, 29, 100, 34), 123))
    solution70(intArrayOf(0, 1, 2, 3, 4), arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))).apply {
        repeat(this.size){
            print("${this[it] }"+" ")
        }
    }
}

/** 홀수 vs 짝수 */
fun solution66(num_list: IntArray): Int {
    var evenAnswer = 0
    var oddAnswer = 0

    repeat(num_list.size){
        if (it % 2 == 0){
            evenAnswer += num_list[it]
        } else {
            oddAnswer += num_list[it]
        }
    }
    return max(evenAnswer, oddAnswer)
}

/** 5명씩 */
fun solution67(names: Array<String>): List<String> {
    val answerList = mutableListOf<String>()
    for (i in 0 until names.size step 5){
        answerList.add(names[i])
    }
    return answerList
}

/** 할 일 목록 */
fun solution68(todo_list: Array<String>, finished: BooleanArray): List<String> {
    val answerList = mutableListOf<String>()
    repeat(todo_list.size){
        if (!finished[it]) answerList.add(todo_list[it])
    }
    return answerList
}

/** n보다 커질 때까지 더하기 */
fun solution69(numbers: IntArray, n: Int): Int {
    var answer = 0

    for (i in 0 until numbers.size){
        if (answer > n) break
        answer += numbers[i]
    }

    return answer
}

/** 수열과 구간 쿼리 1 */
fun solution70(arr: IntArray, queries: Array<IntArray>): List<Int> {
//    val answerList = arr.toMutableList()
    val answerList = mutableListOf<Int>()
    repeat(arr.size){
        answerList.add(arr[it])
    }
    repeat(queries.size){
        for (i in queries[it][0] .. queries[it][1]){
                answerList[i] += 1
        }
    }
    return answerList
}
