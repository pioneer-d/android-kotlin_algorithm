package com.pioneer.algorithm.introduction

fun main(){
//    iSolution38(intArrayOf(100, 95, 2, 4, 5, 6, 18, 33, 948), 3).apply {
//        repeat(this.size){
//            print("${this[it].contentToString()} ")
//        }
//    }
//    println(iSolution39(intArrayOf(1, 2, 3), 2))
    iSolution40(intArrayOf(4, 455, 6, 4, -1, 45, 6), "left").apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

/** 점의 위치 구하기 */
fun iSolution37(dot: IntArray): Int {
    return when (dot[0] > 0) {
        true -> {   // 1, 4
            when (dot[1] > 0){
                true -> 1
                false -> 4
            }
        }
        false -> {  // 2, 3
            when (dot[1] > 0){
                true -> 2
                false -> 3
            }
        }
    }
}

/** 2차원으로 만들기 */
fun iSolution38(num_list: IntArray, n: Int): Array<IntArray> {
    val answerArray = Array(num_list.size / n) { IntArray(n) }
    for (i in 0 until num_list.size / n){
        repeat(n){
            answerArray[i][it] = num_list[i*n+it]
        }
    }
    return answerArray
}

/** 공 던지기 */
fun iSolution39(numbers: IntArray, k: Int): Int {
    val calNum = (((2 * k)-1) % numbers.size)
    return numbers[if (calNum == 0) numbers.size-1 else calNum-1]
}

/** 배열 회전시키기 */
fun iSolution40(numbers: IntArray, direction: String): IntArray {
    val answerArray = IntArray(numbers.size)
    when (direction){
        "right" -> {
            answerArray[0] = numbers[numbers.size-1]
            for (i in 1 until numbers.size){ answerArray[i] = numbers[i-1] }
        }
        "left" -> {
            answerArray[numbers.size-1] = numbers[0]
            for (i in 0 until numbers.size-1){ answerArray[i] = numbers[i+1] }
        }
    }
    return answerArray
}
