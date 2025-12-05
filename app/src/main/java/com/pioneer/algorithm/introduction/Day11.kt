package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution41(intArrayOf(10, 8, 6), 3))
//    println(iSolution42(15))
//    println(iSolution43(intArrayOf(0, 31, 24, 10, 1, 9)))
    println(iSolution44(7))
}

/** 주사위 개수 */
fun iSolution41(box: IntArray, n: Int): Int {
    val (width, depth, height) = box
    return (width / n) * (depth / n) * (height / n)
}

/** 합성수 찾기 */
fun iSolution42(n: Int): Int {
    var answer = 0
    for (i in 3 .. n){
        for (l in 2 until i){
            if (i % l == 0){
                answer++
                break
            }
        }
    }
    return answer
}

/** 최댓값 만들기(1) */
fun iSolution43(numbers: IntArray): Int {
    val sortedArray = numbers.sortedArray()
    return sortedArray[sortedArray.size-1] * sortedArray[sortedArray.size-2]
}

/** 팩토리얼 */
fun iSolution44(n: Int): Int {
    var answer = 0
    fun factorial(n: Int): Int{
        var answer = 1
        for (i in 1 .. n){ answer *= i }
        return answer
    }
    for (i in 1 .. 10){
        if (factorial(i) <= n){
            answer = i
            continue
        } else break
    }
    return answer
}
