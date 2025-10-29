package com.pioneer.algorithm.basic

import kotlin.math.ceil

fun main(){
//    println(solution46("ProgrammerS123", 11))
//    println(solution47("banana", "nan"))
//    println(solution48("Progra21Sremm3", 6, 12))
//    println(solution49("ihrhbakrfpndopljhygc", 4, 2))
    println(solution50(3, 1, "qjnwezgrpirldywt"))
}

/** 문자열의 앞의 n글자 */
fun solution46(my_string: String, n: Int): String {
    return my_string.substring(0, n)
}

/** 접두사인지 확인하기 */
fun solution47(my_string: String, is_prefix: String): Int {
    val subStringMap = mutableMapOf<String, Int>()
    repeat(my_string.length){
        val subString = my_string.substring(0, it)
        subStringMap[subString] = 1
    }
    return if (subStringMap.containsKey(is_prefix)) 1 else 0
}

/** 문자열 뒤집기 */
fun solution48(my_string: String, s: Int, e: Int): String {
    var answer = StringBuilder(my_string)

    val ceilValue = ceil((e.toFloat() - s.toFloat()) / 2).toInt()
    repeat(ceilValue){ i ->
        val temp1 = answer[e - i]
        val temp2 = answer[s + i]
        answer[s + i] = temp1
        answer[e - i] = temp2
    }

    return answer.toString()
}

/** 세로 읽기 */
fun solution49(my_string: String, m: Int, c: Int): String {
    var answer: String = ""
    val repeatCount = my_string.length / m
    val listTable = mutableListOf<String>()

    repeat(repeatCount){
        if (it == 0) {
            listTable.add(my_string.substring(0, m))
        } else {
            listTable.add(my_string.substring((m*it), m*(it+1)))
        }
    }

    repeat(listTable.size){
        answer += listTable[it][c-1].toString()
    }

    return answer
}

/** qr code */
fun solution50(q: Int, r: Int, code: String): String {
    var answer = ""
    repeat(code.length){
        if (it % q == r) answer += code[it].toString()
    }
    return answer
}