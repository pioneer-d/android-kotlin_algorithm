package com.pioneer.algorithm.introduction

import kotlin.math.sqrt

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(99.toChar())
//    println(iSolution30(23))
//    iSolution31(intArrayOf(3, 76, 24)).apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    println(iSolution32(100))
}

/** 배열 자르기 */
fun iSolution29(numbers: IntArray, num1: Int, num2: Int): IntArray {
    val answerArray = IntArray(num2-num1+1)
    for (i in 0 until num2-num1+1){
        answerArray[i] = numbers[i+num1]
    }
    return answerArray
}

/** 외계행성의 나이 */
fun iSolution30(age: Int): String {
    var answer = ""
    val ageString = age.toString()
    repeat(ageString.length){
        answer += (ageString[it].digitToInt() + 97).toChar()
    }
    return answer
}

/** 진료순서 정하기 */
fun iSolution31(emergency: IntArray): IntArray {
    val emergencySort = emergency.sortedDescending()
    val emergencySequence = mutableMapOf<Int, Int>()
    for (i in 0 until emergencySort.size){
        emergencySequence[emergencySort[i]] = i+1
    }
    repeat(emergencySort.size){
        emergency[it] = emergencySequence[emergency[it]]!!
    }
    return emergency
}

/** 순서쌍의 개수 */
fun iSolution32(n: Int): Int {
    var answer = 0
    for (i in 1 ..sqrt(n.toFloat()).toInt()){
        for (l in i .. n){
            if (i * l == n) {
                println("i : $i / l : $l")
                if (i == l) answer++ else answer += 2
                break
            }
        }
    }
    return answer
    /*
    테스트 1 〉	통과 (8.88ms, 62.7MB)
테스트 2 〉	통과 (10.48ms, 63.6MB)
테스트 3 〉	통과 (5811.51ms, 63.2MB)
테스트 4 〉	통과 (9.82ms, 64.1MB)
테스트 5 〉	실패 (5947.88ms, 62.8MB)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	통과 (11.41ms, 62.4MB)
테스트 8 〉	통과 (8.54ms, 64.1MB)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)

-> 제곱근까지만 해도 됨!

테스트 1 〉	통과 (11.05ms, 63.9MB)
테스트 2 〉	통과 (7.99ms, 63.8MB)
테스트 3 〉	통과 (87.31ms, 63.5MB)
테스트 4 〉	통과 (10.77ms, 63.9MB)
테스트 5 〉	통과 (77.85ms, 65MB)
테스트 6 〉	통과 (1883.59ms, 63.2MB)
테스트 7 〉	통과 (10.65ms, 64.7MB)
테스트 8 〉	통과 (7.79ms, 63.6MB)
테스트 9 〉	통과 (1559.15ms, 64.5MB)
테스트 10 〉	통과 (1622.00ms, 61.9MB)
     */
}
