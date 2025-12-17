package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    println(iSolution71(2, 10))
}

/** 문자열안에 문자열 */
fun iSolution69(str1: String, str2: String): Int {
    return if (str1.contains(str2)) 1 else 2
}

/** 제곱수 판별하기 */
fun iSolution70(n: Int): Int {
    var answer = 2
    for (i in 2 .. n/2){
        if (i * i == n) {
            answer = 1
            break
        }
    }
    return answer
}

/** 세균 증식 */
fun iSolution71(n: Int, t: Int): Int {
    var answer = n
    repeat(t){
        answer *= 2
    }
    return answer
}

/** 문자열 정렬하기 (2) */
fun iSolution72(my_string: String): String {
    val sortList = my_string.lowercase().toList().sorted()
    var answer = ""
    for (i in 0 until sortList.size){
        answer += sortList[i]
    }
    return answer
}
