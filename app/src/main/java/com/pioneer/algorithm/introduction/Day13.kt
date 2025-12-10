package com.pioneer.algorithm.introduction

import kotlin.math.max

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution49("-1 -2 -3 Z"))
//    println(iSolution51("We are the world"))
    println(iSolution52(intArrayOf(199, 72, 222)))
}

/** 컨트롤 제트 */
fun iSolution49(s: String): Int {
    var answer = 0
    val splitList = s.split(" ")
    var lastTemp = 0
    var isPositive = true
    for (i in 0 until splitList.size){
        val target = splitList[i]
        when (target){
            "-" -> isPositive = false
            "Z" -> answer -= lastTemp
            else -> {
                if (isPositive) lastTemp = target.toInt()
                else {
                    lastTemp = -(target.toInt())
                    isPositive = true
                }
                answer += lastTemp
            }
        }
    }
    return answer
}

/** 배열 원소의 길이 */
fun iSolution50(strlist: Array<String>): IntArray {
    val answerArray = IntArray(strlist.size)
    for (i in 0 until strlist.size){
        answerArray[i] = strlist[i].length
    }
    return answerArray

    // repeat은 시간 초과!
//    repeat(strlist.size){
//        answerArray[it] = strlist[it].length
//    }
}

/** 중복된 문자 제거 */
fun iSolution51(my_string: String): String {
    var answer = ""
    val checkSet = mutableSetOf<String>()
    for (i in 0 until my_string.length){
        val target = my_string[i].toString()
        if (checkSet.add(target)){
            answer += target
        }
    }
    return answer
}

/** 삼각형의 완성조건 (1) */
fun iSolution52(sides: IntArray): Int {
    // 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
    var max = 0
    var elseSum = 0
    for (i in 0 until sides.size){
        if (sides[i] > max) max = sides[i]
        elseSum += sides[i]
    }
    elseSum -= max
    return if (max < elseSum) 1 else 2

//    val maxValue = sides.max()
//    val elseSum = sides.sum() - maxValue
}
