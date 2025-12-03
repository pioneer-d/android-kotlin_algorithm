package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution33(999))
//    println(iSolution34(".... . .-.. .-.. ---"))
    println(iSolution36(29, 1))
}

/** 개미 군단 */
fun iSolution33(hp: Int): Int {
    var answer = 0
    var calHp = hp

    for (i in 5 downTo  1 step 2){
        answer += calHp / i
        calHp = calHp % i
    }

    return answer
}

/** 모스부호 (1) */
fun iSolution34(letter: String): String {
    var answer = ""
    val morseMap = mapOf(
        ".-" to "a", "-..." to "b", "-.-." to "c", "-.." to "d", "." to "e", "..-." to "f",
        "--." to "g", "...." to "h", ".." to "i", ".---" to "j", "-.-" to "k", ".-.." to "l", "--" to "m",
        "-." to "n", "---" to "o", ".--." to "p", "--.-" to "q", ".-." to "r", "..." to "s", "-" to "t",
        "..-" to "u", "...-" to "v", ".--" to "w", "-..-" to "x", "-.--" to "y", "--.." to "z"
    )
    val letterSplit = letter.split(" ")
    repeat(letterSplit.size){
        answer += morseMap[letterSplit[it]]
    }
    return answer
}

/** 가위 바위 보 */
fun iSolution35(rsp: String): String {
    // 가위 2
    // 바위 0
    // 보  5
    var answer = ""
    repeat(rsp.length){
        when(rsp[it]){
            '2' -> answer += "0"
            '0' -> answer += "5"
            '5' -> answer += "2"
        }
    }
    return answer
}

/** 구슬을 나누는 경우의 수 */
fun iSolution36(balls: Int, share: Int): Int {
    // balls C share
    var parent: Double = 1.0
    var child: Double = 1.0
    if (balls != share){

        for (i in balls downTo share+1 ){ parent *= i }
        for (i in 2 .. balls - share){ child *= i }
    }
    return (parent / child).toInt()
}
