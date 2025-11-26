package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution21("jaron"))
//    iSolution22()
//    iSolution23(intArrayOf(1, 2, 3, 4, 5)).apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    println(iSolution24("hello", 3))
}

/** 뒤집힌 문자열 */
fun iSolution21(my_string: String): String {
    /*
테스트 1 〉	통과 (9.04ms, 65MB)
테스트 2 〉	통과 (9.31ms, 62.9MB)
테스트 3 〉	통과 (9.47ms, 63.8MB)
테스트 4 〉	통과 (9.45ms, 65.2MB)
테스트 5 〉	통과 (9.27ms, 64.1MB)
     */
//    var answerString = ""
//    for (i in my_string.length-1 downTo 0){
//        answerString += my_string[i].toString()
//    }
//    return answerString

    return my_string.reversed()
    /*
테스트 1 〉	통과 (7.09ms, 65.8MB)
테스트 2 〉	통과 (9.65ms, 64.2MB)
테스트 3 〉	통과 (7.31ms, 62.6MB)
테스트 4 〉	통과 (7.31ms, 65.3MB)
테스트 5 〉	통과 (7.01ms, 64.2MB)
     */
}

/** 직각삼각형 출력하기 */
fun iSolution22(){
    val (n) = readLine()!!.split(' ').map(String::toInt)
    repeat(n){
        repeat(it+1){
            print("*")
        }
        if (it!=n) println()
    }
}

/** 짝수 홀수 개수 */
fun iSolution23(num_list: IntArray): IntArray {
    val answerArray = IntArray(2)
    repeat(num_list.size){
        if (num_list[it] % 2 == 0) answerArray[0] += 1
        else answerArray[1] += 1
    }
    return answerArray
}

/** 문자 반복 출력하기 */
fun iSolution24(my_string: String, n: Int): String {
    var answer = ""
    for (i in 0 until my_string.length){
        repeat(n){
            answer += my_string[i].toString()
        }
    }
    return answer
}
