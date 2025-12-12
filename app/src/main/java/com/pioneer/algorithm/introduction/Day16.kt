package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
}

/** 편지 */
fun iSolution61(message: String): Int {
    return message.length * 2
}

/** 가장 큰 수 찾기 */
fun iSolution62(array: IntArray): IntArray {
    var maxValue = 0
    var maxIndex = 0
    for (i in 0 until array.size){
        val target = array[i]
        if (target > maxValue){
            maxValue = target
            maxIndex = i
        }
    }
    return intArrayOf(maxValue, maxIndex)
}

/** 문자열 계산하기 */
fun iSolution63(my_string: String): Int {
    val calList = my_string.split(" ")
    var answer = 0
    var addFlag = true
    for (i in 0 until calList.size){
        val target = calList[i]
        if (target.toIntOrNull() != null){
            if (addFlag) answer += target.toInt()
            else answer -= target.toInt()
        } else addFlag = if (target == "+") true else false
    }

    return answer
}

/** 배열의 유사도 */
fun iSolution64(s1: Array<String>, s2: Array<String>): Int {
    // 각 배열이 중복된 원소를 갖고 있지 않으므로 Set 사용 가능
    val supplySet = s1.toMutableSet()
    var answer = 0
    for (i in 0 until s2.size){
        if (!supplySet.add(s2[i])) answer++
    }
    return answer
}
