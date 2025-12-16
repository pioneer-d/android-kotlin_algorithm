package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    println(iSolution65(123456, 7))
}

/** 숫자 찾기 */
fun iSolution65(num: Int, k: Int): Int {
    var answer = -1
    val numString = num.toString()

    for (i in 0 until numString.length){
        if (numString[i].digitToInt() == k) {
            answer = i+1
            break
        }
    }

    return answer
}

/** n의 배수 고르기 */
fun iSolution66(n: Int, numlist: IntArray): List<Int> {
    val answerList = mutableListOf<Int>()
    numlist.forEach {
        if (it % n == 0) answerList.add(it)
    }
    return answerList
}

/** 자릿수 더하기 */
fun iSolution67(n: Int): Int {
    var answer = 0
    n.toString().forEach { answer += it.digitToInt() }
    return answer
}

/** OX퀴즈 */
fun iSolution68(quiz: Array<String>): Array<String> {
    val answerArray = Array(quiz.size, {""})
    for (i in 0 until quiz.size){
        val (a, b, c, d, e) = quiz[i].split(" ")
        val realAnswer = if (b == "+"){
            a.toInt() + c.toInt()
        } else {
            a.toInt() - c.toInt()
        }
        answerArray[i] = if (e.toInt() == realAnswer) "O" else "X"
    }
    return answerArray
}
