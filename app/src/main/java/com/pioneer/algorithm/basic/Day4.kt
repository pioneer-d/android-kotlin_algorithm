package com.pioneer.algorithm.basic

fun main(){
//    print(solution16(34, 3))
//    print(solution17(55, 10, 5))
//    print(solution18(10))
//    print(solution19(">", "!", 41, 78))
    print(solution20(-4, 7, false))
}

/** n의 배수 */
fun solution16(num: Int, n: Int): Int {
    return if (num % n == 0) 1 else 0
}

/** 공배수 */
fun solution17(number: Int, n: Int, m: Int): Int {
    return if (number % n == 0 && number % m == 0) 1 else 0
}

/** 홀짝에 따라 다른 값 반환하기 */
fun solution18(n: Int): Int {
    var answer = 0
    when(n % 2 == 0){
        true -> for (i in 2..n step(2)){ answer += i*i }
        false -> for (i in 1..n step(2)){ answer += i }
    }
    return answer
}

/** 조건 문자열 */
fun solution19(ineq: String, eq: String, n: Int, m: Int): Int {
    val leftWin = ineq == "<"
    val equalFlag = eq == "="
    return when{
        leftWin && equalFlag -> { if (n <= m) 1 else 0 }
        leftWin && !equalFlag -> { if (n < m) 1 else 0 }
        !leftWin && equalFlag -> { if (n >= m) 1 else 0 }
        !leftWin && !equalFlag -> { if (n > m) 1 else 0 }
        else -> 0
    }
}

/** flag에 따라 다른 값 반환하기 */
fun solution20(a: Int, b: Int, flag: Boolean): Int {
    return if (flag) a+b else a-b
}