package com.pioneer.algorithm.introduction

import kotlin.math.abs

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution53(intArrayOf(2,2,3,4,), 1))
//    println(iSolution54(3))
//    println(iSolution55("dfjardstddetckdaccccdegk",4))
    println(iSolution56("cccCCC"))
}

/** 가까운 수 */
fun iSolution53(array: IntArray, n: Int): Int {
    // 빼고
    // 이전거랑 같으면 flag 세워두고
    // 저 작은게 나오면 flag 다시 반환하고
    // flag가 true면 n에서 차이만큼 뺀거 리턴
    var guessAnswer = array[0]
    var bestNearSize = abs(n - array[0])
    var isDual = false
    for (i in 1 until array.size){
        val target = abs(n - array[i])
        if (target < bestNearSize) {
            bestNearSize = target
            guessAnswer = array[i]
            isDual = false
        } else if (target == bestNearSize && guessAnswer != array[i]){
            isDual = true
        }
    }
    return if (isDual) n - bestNearSize else guessAnswer
}

/** 369게임 */
fun iSolution54(order: Int): Int {
    var answer = 0
    val orderToString = order.toString()
    for (i in 0 until orderToString.length){
        when (orderToString[i]){
            '3', '6', '9' -> answer++
        }
    }
    return answer
}

/** 암호 해독 */
fun iSolution55(cipher: String, code: Int): String {
    var answer = ""
    for (i in code-1 until cipher.length step code){
        answer += cipher[i]
    }
    return answer
}

/** 대문자와 소문자 */
fun iSolution56(my_string: String): String {
    var answer = ""
    for (i in 0 until my_string.length){
        answer += if (my_string[i].isUpperCase()) my_string[i].lowercase()
        else my_string[i].uppercase()
    }
    return answer
}
