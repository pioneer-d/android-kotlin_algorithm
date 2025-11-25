package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution17(150000))
//    iSolution18(15000).apply {
//        repeat(this.size){
//            println("$it 번째 값 : ${this[it]}")
//        }
//    }
    iSolution20(intArrayOf(1, 2, 3, 4, 5)).apply {
        repeat(this.size){
            println("${this[it] }")
        }
    }
}

/** 옷 가게 할인 받기 */
fun iSolution17(price: Int): Int {
    // 10만원 이상 5%
    // 30만원 이상 10%
    // 50만원 이상 20%
    return when {
        price >= 100000 && price < 300000 -> (price * 0.95).toInt()
        price >= 300000 && price < 500000 -> (price * 0.9).toInt()
        price >= 500000 -> (price * 0.8).toInt()
        else -> price
    }
    // 범위가 큰 숫자, 즉 먼저 걸리는 범위를 먼저 하면 이중 범위를 안해도 됐겠다.
}

/** 아이스 아메리카노 */
fun iSolution18(money: Int): IntArray {
    // 한잔 5,500
    // 잔수, 남는 돈
    val answerArray = IntArray(2)
    answerArray[0] = money / 5500
    answerArray[1] = money % 5500
    return answerArray
    // 더 간소화 할 수 있었겠다.
}

/** 나이 출력 */
fun iSolution19(age: Int): Int {
    return 2023 - age
}

/** 배열 뒤집기 */
fun iSolution20(num_list: IntArray): IntArray {
    // 1, 2, 3, 4, 5
    // 1, 2, 3, 4, 5, 6
    val repeatCount = if (num_list.size % 2 == 0) num_list.size / 2 else (num_list.size - 1) / 2
    repeat(repeatCount){
        val leftTemp = num_list[it]
        num_list[it] = num_list[num_list.size-1-it]
        num_list[num_list.size-1-it] = leftTemp
    }
    return num_list
}