package com.pioneer.algorithm.introduction

import kotlin.math.abs

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    iSolution89(intArrayOf(1, 2, 3, 4, 5, 6), 4).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

/** 특이한 정렬 */
fun iSolution89(numlist: IntArray, n: Int): IntArray {
    // n과 가까운 순서로 정렬, 거리가 같은 경우 큰 수가 먼저 오도록

//    1. 새로운 list
//    2.  순회하면서 n을 뺀 뒤, 절대값이 제일 작은 인덱스와 값 변수에 담기 (만약 같은 경우 큰 값 담기)
//    3. 다 돌았으면 해당 index의 값을 정답 list에 추가한 뒤 후보군 list에서 제거
    val answerArray = IntArray(numlist.size)
    val targetList = numlist.toMutableList()
    var sequence = 0
    while (targetList.isNotEmpty()){
        var targetIndex = 0
        var targetValue = 0
        var targetDistance = -1
        for (i in 0 until targetList.size){
            val distance = abs(n - targetList[i])
            when {
                distance == 0 || targetDistance == -1 || targetDistance > distance -> {
                    targetIndex = i
                    targetValue = targetList[i]
                    targetDistance = distance
                }
                targetDistance == distance -> {
                    if (targetValue < targetList[i]){
                        targetIndex = i
                        targetValue = targetList[i]
                        targetDistance = distance
                    }
                }
            }
        }
        answerArray[sequence] = targetValue
        sequence++
        targetList.removeAt(targetIndex)
    }
    return answerArray
}

/** 등수 매기기 */
fun iSolution90(score: Array<IntArray>): IntArray {
    // 합계 List 만들고
    // 높은 것 순서대로 하나씩 추가 해당 인덱스 제거
    // 이전에 추가한 값과 같으면 같은 등수 부여
    val answerArray = IntArray(score.size)
    var rank = 1
    val sumList = mutableListOf<Int>()
    for (i in 0 until score.size){
        sumList.add(score[i][0] + score[i][1])
    }

}

/** 옹알이 (1) */
fun iSolution91(){

}

/** 로그인 성공? */
fun iSolution92(){

}
