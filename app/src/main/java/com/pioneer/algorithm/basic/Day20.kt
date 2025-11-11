package com.pioneer.algorithm.basic

import kotlin.math.pow

fun main(){
//    solution96(intArrayOf(58, 172, 746, 89)).apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(solution97(intArrayOf(49, 13), intArrayOf(70, 11, 2)))
//    println(solution98(arrayOf("a","bc","d","efg","hi")))
//    solution99(intArrayOf(49, 12, 100, 276, 33), 27).apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    solution100(intArrayOf(12, 4, 15, 46, 38, 1, 14)).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

/** 배열의 길이를 2의 거듭제곱으로 만들기 */
fun solution96(arr: IntArray): List<Int> {
    val answerList = arr.toMutableList()
    var mul = 0
    while (2.0.pow(mul).toInt() < arr.size){
        mul++
    }
    if (2.0.pow(mul).toInt() != arr.size){
        repeat(2.0.pow(mul).toInt() - arr.size){
            answerList.add(0)
        }
    }
    return answerList
}

/** 배열 비교하기 */
fun solution97(arr1: IntArray, arr2: IntArray): Int {
    var answer = 0
    val arr1Size = arr1.size
    val arr2Size = arr2.size
    if (arr1Size == arr2Size){
        var arr1Sum = 0
        var arr2Sum = 0
        repeat(arr1.size){ arr1Sum += arr1[it] }
        repeat(arr2.size){ arr2Sum += arr2[it] }
        answer = if (arr1Sum != arr2Sum){
            if (arr1Sum > arr2Sum) 1 else -1
        } else 0
    } else answer = if (arr1Size > arr2Size) 1 else -1
    return answer
}

/** 문자열 묶기 */
fun solution98(strArr: Array<String>): Int {
    var answer = 0
    val countMap = mutableMapOf<Int, Int>()
    repeat(strArr.size){
        if (countMap[strArr[it].length] == null) countMap[strArr[it].length] = 1
        else countMap[strArr[it].length] = countMap[strArr[it].length]!!+1
        val targetCount = countMap[strArr[it].length]!!
        if (answer < targetCount) answer = targetCount
    }
    return answer
}

/** 배열의 길이에 따라 다른 연산하기 */
fun solution99(arr: IntArray, n: Int): IntArray {
    if (arr.size % 2 == 0){
        repeat(arr.size){ if (it % 2 != 0) arr[it] += n }
    } else repeat(arr.size){ if (it % 2 == 0){ arr[it] += n } }

    return arr
}

/** 뒤에서 5등까지 */
fun solution100(num_list: IntArray): IntArray {
    return num_list.sortedArray().sliceArray(0..4)
}