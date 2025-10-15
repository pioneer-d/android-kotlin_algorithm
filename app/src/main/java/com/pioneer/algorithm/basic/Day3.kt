package com.pioneer.algorithm.basic

import kotlin.math.max

fun main(){
//    solution11("aaaaa", "bbbbb")
//    solution12(arrayOf("a","b","c"))
//    solution13("string",3)
//    solution14(9, 91)
    solution15(2, 91)

}

/** 문자열 섞기 */
fun solution11(str1: String, str2: String): String {
    var answer: String = ""
    repeat(str1.length){
        answer += "${str1[it]}${str2[it]}"
    }
    return answer
}

/** 문자리스트를 문자열로 반환하기 */
fun solution12(arr: Array<String>): String {
    return arr.joinToString("")
}

/** 문자열 곱하기 */
fun solution13(my_string: String, k: Int): String {
    var answer: String = ""
    repeat(k){ answer += my_string }

    // 다른 풀이
//    my_string.repeat(k)

    return answer
}

/** 더 크게 합치기 */
fun solution14(a: Int, b: Int): Int {

    val case1 = "$a$b".toInt()
    val case2 = "$b$a".toInt()

    // max를 활용해도 좋겠다.

    return if (case1 > case2) case1 else case2
}

/** 두 수의 연산값 비교하기 */
fun solution15(a: Int, b: Int): Int {

    val case1 = "$a$b".toInt()
    val case2 = 2 * a * b

    return max(case1, case2)

}