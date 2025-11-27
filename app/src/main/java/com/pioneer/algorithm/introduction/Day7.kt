package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    iSolution28(10)
}

/** 특정 문자 제거하기 */
fun iSolution25(my_string: String, letter: String): String {
    var answer = ""
    repeat(my_string.length){
        val target = my_string[it].toString()
        if (target != letter) answer += target
    }
    return answer
}

/** 각도기 */
fun iSolution26(angle: Int): Int {
    /*
예각 : 0 < angle < 90
직각 : angle = 90
둔각 : 90 < angle < 180
평각 : angle = 180
     */
    return when{
        angle == 90 -> 2
        angle == 180 -> 4
        0 < angle && angle < 90 -> 1
        90 < angle && angle < 180 -> 3
        else -> 0
    }
}

/** 양꼬치 */
fun iSolution27(n: Int, k: Int): Int {
    return (n * 12000) + (k * 2000) - (n / 10 * 2000)
}

/** 짝수의 합 */
fun iSolution28(n: Int): Int {
    var answer = 0
    for (i in 0 .. n step 2){
        println("i : $i")
        answer += i
    }
    return answer
}
