package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution14(10))
    println(iSolution15(7, 10))
}

/** 피자 나눠 먹기 (1) */
fun iSolution13(n: Int): Int {
    // 피자가 몇 판 있어야 하나
    // 피자는 7조각.
    return if (n % 7 == 0) n / 7 else (n / 7) + 1
}

/** 피자 나눠 먹기 (2) */
fun iSolution14(n: Int): Int {
    // 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각
    // 피자는 6조각
    var answerPizzaCount = 1
    while ((answerPizzaCount*6) % n != 0){
        answerPizzaCount++
    }
    return answerPizzaCount
}

/** 피자 나눠 먹기 (3) */
fun iSolution15(slice: Int, n: Int): Int {
    var answerPizzaCount = 1
    while ((answerPizzaCount*slice) < n){
        answerPizzaCount++
    }
    return answerPizzaCount
}

/** 배열의 평균값 */
fun iSolution16(numbers: IntArray): Double {
/*
테스트 1 〉	통과 (18.39ms, 65.4MB)
테스트 2 〉	통과 (16.52ms, 64.4MB)
테스트 3 〉	통과 (16.80ms, 66.5MB)
테스트 4 〉	통과 (13.64ms, 65.8MB)
테스트 5 〉	통과 (13.75ms, 64.6MB)
     */
//    return numbers.average()
    
    var sum = 0
    repeat(numbers.size){
        sum += numbers[it]
    }
    return sum.toDouble() / numbers.size.toDouble()
/*
테스트 1 〉	통과 (0.03ms, 63.7MB)
테스트 2 〉	통과 (0.03ms, 63.3MB)
테스트 3 〉	통과 (0.03ms, 64.6MB)
테스트 4 〉	통과 (0.03ms, 63.2MB)
테스트 5 〉	통과 (0.03ms, 64.8MB)
 */
}
//
