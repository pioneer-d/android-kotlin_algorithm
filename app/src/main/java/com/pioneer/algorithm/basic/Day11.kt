package com.pioneer.algorithm.basic

import kotlin.math.absoluteValue

fun main(){
//    solution51("Programmers").apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
//    solution52(10, 3).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
//    println(solution53("apporoograpemmemprs", intArrayOf(1, 16, 6, 15, 0, 10, 11, 3)))
//    solution54(10, 3).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
    println(solution55(intArrayOf(0, 0, 0, 1), 1))
}

/** 문자 개수 세기 */
fun solution51(my_string: String): List<Int> {
    val upperList = MutableList(26) { 0 }
    val letterList = MutableList(26) { 0 }
    repeat(my_string.length){
        if (my_string[it].isUpperCase()){
            val countNumber =  ('A' - my_string[it]).absoluteValue
            upperList[countNumber] += 1
        } else {
            val countNumber =  ('a' - my_string[it]).absoluteValue
            letterList[countNumber] += 1
        }
    }
    upperList.addAll(letterList)

    return upperList
}

/** 배열 만들기 1 */
fun solution52(n: Int, k: Int): List<Int> {
    val returnList = mutableListOf<Int>()
    for (i in 1 .. n){
        if (i % k == 0) returnList.add(i)
    }

    return returnList
}

/** 글자 지우기 */
fun solution53(my_string: String, indices: IntArray): String {
    var stringToList = my_string.toMutableList()
    val sortedArray = indices.sortedArray()

    for (i in sortedArray.size-1 downTo  0){
        stringToList.removeAt(sortedArray[i])
    }
    val answer = stringToList.joinToString(separator = "")
    return answer
}

/** 카운트 다운 */
fun solution54(start_num: Int, end_num: Int): List<Int> {
    val countList = mutableListOf<Int>()
    for (i in start_num downTo end_num){
        countList.add(i)
    }
    return countList
}

/** 가까운 1 찾기 */
fun solution55(arr: IntArray, idx: Int): Int {
    var answer = -1
    for (i in idx until arr.size){
        if (arr[i] == 1) {
            answer = i
            break
        }
    }
    return answer
}