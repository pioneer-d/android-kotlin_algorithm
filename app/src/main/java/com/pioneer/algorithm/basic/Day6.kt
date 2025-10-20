package com.pioneer.algorithm.basic

import kotlin.math.min

fun main(){

//    solution27(intArrayOf(5, 2, 1, 7, 5)).apply {
//        repeat(this.size){
//            println(this[it])
//        }
//    }
//    println(solution28(0, "wsdawsdassw"))
//    println(solution29(intArrayOf(0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1)))
//    solution30(intArrayOf(0, 1, 2, 3, 4), arrayOf(intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(1, 4))).apply {
//        repeat(this.size){
//            println(this[it])
//        }
//    }
    solution31(intArrayOf(0, 1, 2, 4, 3), arrayOf(intArrayOf(0, 4, 2), intArrayOf(0, 3, 2), intArrayOf(0, 2, 2))).apply {
        repeat(this.size){
            println(this[it])
        }
    }

}

/** 마지막 두 원소 */
fun solution27(num_list: IntArray): IntArray {
    var answer: IntArray = intArrayOf()

    val minusValue = num_list[num_list.size-1] - num_list[num_list.size-2]
    when {
        minusValue > 0 -> answer = num_list + minusValue
        minusValue <= 0 -> answer = num_list + num_list[num_list.size-1] * 2
    }

    return answer
}

/** 수 조작하기 1 */
fun solution28(n: Int, control: String): Int {
    var answer = n
    repeat(control.length){
        when (control[it]){
            'w' -> { answer += 1 }
            's' -> { answer -= 1 }
            'd' -> { answer += 10 }
            'a' -> { answer -= 10 }
        }
    }
    return answer
}

/** 수 조작하기 2 */
fun solution29(numLog: IntArray): String {
    var answer: String = ""

    for (i in 0 until numLog.size-1){
        when (numLog[i+1] - numLog[i]){
            1 -> answer += "w"
            -1 -> answer += "s"
            10 -> answer += "d"
            -10 -> answer += "a"
        }
    }

    return answer
}

/** 수열과 구간 쿼리 3 */
fun solution30(arr: IntArray, queries: Array<IntArray>): IntArray {
    var answer = arr

    repeat(queries.size){
        val temp1 = answer[queries[it][0]]
        val temp2 = answer[queries[it][1]]
        answer[queries[it][0]] = temp2
        answer[queries[it][1]] = temp1
    }

    return answer
}

/** 수열과 구간 쿼리 2 */
fun solution31(arr: IntArray, queries: Array<IntArray>): IntArray {
    var answer = IntArray(queries.size)

    repeat(queries.size){
        var answerCase = -1
        for (i in queries[it][0] ..queries[it][1]){
            if (arr[i] <= queries[it][2]) continue
            if (answerCase == -1) answerCase = arr[i]
            answerCase = min(answerCase, arr[i])
        }
        answer[it] = answerCase
    }

    return answer
}