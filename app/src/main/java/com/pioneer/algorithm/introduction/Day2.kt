package com.pioneer.algorithm.introduction

fun main(){
    iSolution7(1, 2, 3, 4).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

/** 두 수의 나눗셈 */
fun iSolution5(num1: Int, num2: Int): Int {
    return ((num1.toFloat() / num2.toFloat()) * 1000f).toInt()
}

/** 숫자 비교하기 */
fun iSolution6(num1: Int, num2: Int): Int {
    return if (num1 == num2) 1 else -1
}

/** 분수의 덧셈 */
fun iSolution7(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
    // 1분자 numer1 / 1분모 denom1
    // 2분자 numer2 / 2분모 denom2
    // 각 분모 최소 공배수 구하고
    // 분자랑 동시에 공약수 있는지 확인하고
    // 없으면 return
    val answerArray = IntArray(2)

    var answerNumer = (numer1*denom2)+(numer2*denom1)
    var answerDenom = denom1*denom2

    fun gcd(num1: Int, num2: Int): Int{
        return if (num2 == 0) num1 else gcd(num2, num1 % num2)
    }
    var isGoing = true
    while (isGoing){
        val gcd = gcd(answerNumer, answerDenom)
        if (gcd == 1){
            isGoing = false
        } else {
            answerNumer = answerNumer / gcd
            answerDenom = answerDenom / gcd
        }
    }

    answerArray[0] = answerNumer
    answerArray[1] = answerDenom

    return answerArray

//    var isGoing = true

//    while (isGoing){
//        when {
//            answerDenom % 2 == 0 && answerNumer % 2 == 0 -> {
//                answerDenom = answerDenom/2
//                answerNumer = answerNumer/2
//            }
//            answerDenom % 3 == 0 && answerNumer % 3 == 0 -> {
//                answerDenom = answerDenom/3
//                answerNumer = answerNumer/3
//            }
//            answerDenom % 5 == 0 && answerNumer % 5 == 0 -> {
//                answerDenom = answerDenom/5
//                answerNumer = answerNumer/5
//            }
//            answerDenom % answerNumer == 0 -> {
//                answerDenom = answerDenom/answerNumer
//                answerNumer = answerNumer/answerNumer
//            }
//            answerNumer % answerDenom == 0 -> {
//                answerDenom = answerDenom/answerDenom
//                answerNumer = answerNumer/answerDenom
//            }
//            answerNumer == 1 || answerDenom == 1 -> isGoing = false
//            else -> isGoing = false
//        }
//    }

}

/** 배열 두 배 만들기 */
fun iSolution8(numbers: IntArray): IntArray {
    repeat(numbers.size){
        numbers[it] = numbers[it]*2
    }
    return numbers
    // 다음에는 map 함수 활용해보자
}