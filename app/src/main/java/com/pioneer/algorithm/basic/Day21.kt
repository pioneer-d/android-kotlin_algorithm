package com.pioneer.algorithm.basic

fun main(){
//    solution101(intArrayOf(12, 4, 15, 46, 38, 1, 14, 56, 32, 10)).apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(solution102(intArrayOf(3, 7, 2, 5, 4, 6, 1), booleanArrayOf(false, true, true, true, true, false, false)))
//    println(solution103(69.32))
//    println(solution104("123456789"))
    println(solution105("10"))
}

/** 뒤에서 5등 위로 */
fun solution101(num_list: IntArray): List<Int> {
    // 가장 작은 수 제외, 오름차순
    val answerList = num_list.sorted().toMutableList().apply {
        repeat(5){ removeFirst() }
    }
    return answerList
}

/** 전국 대회 선발 고사 */
fun solution102(rank: IntArray, attendance: BooleanArray): Int {
    // 10000 × a + 100 × b + c
    val answerList = mutableListOf<Int>()

    var startPoint = 1
    while (answerList.size != 3){
        val target = rank.indexOf(startPoint)
        if (attendance[target]) answerList.add(target)
        startPoint++
    }

    return 10000 * answerList[0] + 100 * answerList[1] + answerList[2]
}

/** 정수 부분 */
fun solution103(flo: Double): Int {
//    return flo.toString().split('.')[0].toInt()
    return flo.toInt()
}

/** 문자열 정수의 합 */
fun solution104(num_str: String): Int {
    var answer = 0
    repeat(num_str.length){
        answer += num_str[it].digitToInt()
    }
    return answer
}

/** 문자열을 정수로 변환하기 */
fun solution105(n_str: String): Int {
    return n_str.toInt()
}