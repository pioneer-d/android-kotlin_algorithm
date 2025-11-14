package com.pioneer.algorithm.basic

import kotlin.math.absoluteValue

fun main(){
//    println(solution107("18446744073709551615", "287346502836570928366"))
    println(solution110("banana", "wxyz"))
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
}

/** 0 떼기 */
fun solution106(n_str: String): String {
    return n_str.toInt().toString()
}

/** 두 수의 합 */
fun solution107(a: String, b: String): String {
    var answer = ""

    // 1. 둘다 9자리 이하면 toInt()
    if (a.length < 10 && b.length < 10){
        answer = (a.toInt() + b.toInt()).toString()
    } else {
        // 2. 긴 것을 기준으로 반복
        val repeatCount = if (a.length > b.length) a.length else b.length
        var isUp = false
        val reversA = a.reversed()
        val reversB = b.reversed()
        repeat(repeatCount){
            val aNum = if (reversA.length-1 >= it) reversA[it].digitToInt() else null
            val bNum = if (reversB.length-1 >= it) reversB[it].digitToInt() else null
            var calNum = (aNum ?: 0)+(bNum ?: 0) + if (isUp) + 1 else 0
            if (calNum >= 10){
                calNum -= 10
                isUp = true
            } else isUp = false
            answer = "$calNum"+answer
        }
        if (isUp) answer = "1$answer"
    }
    return answer
    // 다른 풀이...
    // return (a.toBigDecimal() + b.toBigDecimal()).toString()
}

/** 문자열로 변환 */
fun solution108(n: Int): String {
    return n.toString()
}

/** 배열의 원소 삭제하기 */
fun solution109(arr: IntArray, delete_list: IntArray): IntArray {
    val answerSet = arr.toMutableSet()
    repeat(delete_list.size){
        answerSet.remove(delete_list[it])
    }
    return answerSet.toIntArray()
}

/** 부분 문자열인지 확인하기 */
fun solution110(my_string: String, target: String): Int {
    var answer = 0
    for (i in 0 until my_string.length - target.length+1){
        if (my_string.substring(i, i+target.length) == target) {
            answer = 1
            break
        }
    }
    return answer
}