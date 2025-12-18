package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    iSolution74("abc1Addfggg4556b", 6).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

/** 7의 개수 */
fun iSolution73(array: IntArray): Int {
    var answer = 0
    for (i in 0 until array.size){
        val intToString = array[i].toString()
        for (l in 0 until intToString.length){
            if (intToString[l] == '7') answer++
        }
    }
    return answer
}

/** 잘라서 배열로 저장하기 */
fun iSolution74(my_str: String, n: Int): List<String> {
    val answerList = mutableListOf<String>()
    var targetElement = ""
    for (i in 0 until my_str.length){
        if (i != 0 && i % n == 0) {
            answerList.add(targetElement)
            targetElement = ""
        }
        targetElement += my_str[i]
    }
    if (targetElement != "") answerList.add(targetElement)
    return answerList
}

/** 중복된 숫자 개수 */
fun iSolution75(array: IntArray, n: Int): Int {
    var answer = 0
    for (i in 0 until array.size){
        if (array[i] == n) answer++
    }
    return answer
}

/** 머쓱이보다 키 큰 사람 */
fun iSolution76(array: IntArray, height: Int): Int {
    var answer = 0
    for (i in 0 until array.size){
        if (array[i] > height) answer++
    }
    return answer

}
