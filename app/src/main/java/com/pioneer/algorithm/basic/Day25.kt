package com.pioneer.algorithm.basic

import kotlin.math.abs
import kotlin.math.max

fun main(){
//    solution121(5).apply {
//        repeat(this.size){
//            print("${this[it].contentToString()} ")
//        }
//    }
//    println(solution122(arrayOf(intArrayOf(19, 498, 258, 587), intArrayOf(63, 93, 7, 754), intArrayOf(258, 7, 1000, 723), intArrayOf(587, 754, 723, 81))))
//    solution123(arrayOf(intArrayOf(57, 192, 534, 2), intArrayOf(9, 345, 192, 999))).apply {
//        repeat(this.size){
//            print("${this[it].contentToString()} ")
//        }
//    }
    println(solution124(arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3), intArrayOf(2, 3, 4), intArrayOf(3, 4, 5)), 2))
}

/** 정수를 나선형으로 배치하기 */
fun solution121(n: Int): Array<IntArray> {
    val answerArray = Array(n){ IntArray(n) }
    var isRightDirection = true
    var isDownDirection = true
    var isVertical = false

    var lastRow = 0
    var lastIndex = 0
    val turnCount = (n - 1) * 2 + 1
    var setValue = 0
    fun calculatedSetValue(): Int{
        setValue++
        return setValue
    }

    // 턴 횟수만큼 반복.
    repeat(turnCount){
        when(isVertical){
            false -> {
                when (isRightDirection) {
                    true -> {
                        // 좌 -> 우
                        for (l in lastIndex until n){
                            if (answerArray[lastRow][l] != 0) {
                                continue
                            }
                            else {
                                answerArray[lastRow][l] = calculatedSetValue()
                                lastIndex = l
                            }
                        }
                    }
                    false -> {
                        // 우 -> 좌
                        for (r in lastIndex downTo 0){
                            if (answerArray[lastRow][r] != 0) continue
                            else {
                                answerArray[lastRow][r] = calculatedSetValue()
                                lastIndex = r
                            }
                        }
                    }
                }
                isRightDirection = !isRightDirection
            }
            true -> {
                when (isDownDirection) {
                    true -> {
                        // 상 -> 하
                        for (d in lastRow until n){
                            if (answerArray[d][lastIndex] != 0) continue
                            else {
                                answerArray[d][lastIndex] = calculatedSetValue()
                                lastRow = d
                            }
                        }
                    }
                    false -> {
                        // 하 -> 상
                        for (u in lastRow downTo 0){
                            if (answerArray[u][lastIndex] != 0) continue
                            else {
                                answerArray[u][lastIndex] = calculatedSetValue()
                                lastRow = u
                            }
                        }
                    }
                }
                isDownDirection = !isDownDirection
            }
        }
        isVertical = !isVertical
    }
    return answerArray
}



/** 특별한 이차원 배열 2 */
fun solution122(arr: Array<IntArray>): Int {
    var answer = 1
    var breakPoint = false
    for (a in 0 until arr.size-1){
        for (i in 0 until arr[a].size){
            if (breakPoint) break
            if (arr[a][i] != arr[i][a]) {
                answer = 0
                breakPoint = true
                break
            }
        }
    }
    return answer
}

/** 정사각형으로 만들기 */
fun solution123(arr: Array<IntArray>): Array<IntArray> {
    val absCount = abs(arr.size - arr[0].size)
    if (absCount == 0) return arr
    else {
        val addCount = max(arr.size, arr[0].size)
        val answerArray = Array(addCount) { IntArray(addCount) }
        for (a in 0 until arr.size){
            for (i in 0 until arr[a].size){
                answerArray[a][i] = arr[a][i]
            }
        }
        return answerArray
    }
}

/** 이차원 배열 대각선 순회하기 */
fun solution124(board: Array<IntArray>, k: Int): Int {
    var answer = 0
    for (i in 0 until board.size){
        for (l in 0 until board[i].size){
            if ((i + l) <= k) answer += board[i][l]
        }
    }
    return answer
}

