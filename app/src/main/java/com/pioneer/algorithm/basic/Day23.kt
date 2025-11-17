package com.pioneer.algorithm.basic

import kotlin.math.abs

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(solution111("abc", "aabcc"))
//    println(solution112(arrayOf("abc", "def", "ghi"), "ef"))
//    println(solution113(intArrayOf(1, 2, 3, 4, 5), 3))
//    println(solution114(2, 4))
    println(solution115(intArrayOf(2021, 12, 28), intArrayOf(2021, 12, 29)))
}

/** 부분 문자열 */
fun solution111(str1: String, str2: String): Int {
    var answer = 0
    for (i in 0 until str2.length - str1.length + 1){
        if (str2.substring(i, i+str1.length) == str1) {
            answer = 1
            break
        }
    }
    return answer
}

    // 더 오래걸림
//    if (str2.contains(str1)){
//        answer = 1
//    }

    // 더더 오래걸림
//    return if (str1 in str2) 1 else 0


/** 꼬리 문자열 */
fun solution112(str_list: Array<String>, ex: String): String {
    var answer = ""
    for (i in 0 until str_list.size){
        if (solution111(ex, str_list[i]) == 1) continue
        else answer += str_list[i]
    }
    return answer
}


/** 정수 찾기 */
fun solution113(num_list: IntArray, n: Int): Int {
    // 상대적으로 오래 걸림
//    return if (num_list.contains(n)) 1 else 0
    var answer = 0
    for (i in 0 until num_list.size){
        if (num_list[i] == n) {
            answer = 1
            break
        }
    }
    return answer
}

/** 주사위 게임 1 */
fun solution114(a: Int, b: Int): Int {
    var answer = 0
    val isAOdd = a % 2 != 0
    val isBOdd = b % 2 != 0
    when{
        isAOdd && isBOdd -> answer = a*a + b*b
        isAOdd || isBOdd -> answer = 2 * (a+b)
        else -> answer = abs(a - b)
    }
    return answer
}

/** 날짜 비교하기 */
fun solution115(date1: IntArray, date2: IntArray): Int {
    var isExpired = 0
    val (todayYear, todayMonth, todayDay) = date1
    val (endYear, endMonth, endDay) = date2
    when {
        todayYear < endYear -> isExpired = 1
        todayYear == endYear && todayMonth < endMonth -> isExpired = 1
        todayYear == endYear && todayMonth == endMonth && todayDay < endDay -> isExpired = 1
    }
    return isExpired
}