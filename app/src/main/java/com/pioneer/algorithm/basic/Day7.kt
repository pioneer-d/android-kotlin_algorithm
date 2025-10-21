package com.pioneer.algorithm.basic

fun main(){

//    solution32(intArrayOf(0, 1, 2, 4, 3), arrayOf(intArrayOf(0, 4, 1), intArrayOf(0, 3, 2), intArrayOf(0, 3, 3))).apply {
//        repeat(this.size){
//            println(this[it])
//        }
//    }

//    solution33(5, 555).apply {
//        repeat(this.size){
//            println(this[it])
//        }
//    }

//    solution34(3, 10).apply {
//        repeat(this.size){
//            println(this[it])
//        }
//    }

//    solution35(10).apply {
//        repeat(this.size){
//            println(this[it])
//        }
//    }

    solution36(intArrayOf(1, 4, 2, 5, 3)).apply {
        repeat(this.size){
            println(this[it])
        }
    }


}

/** 수열과 구간 쿼리4 */
fun solution32(arr: IntArray, queries: Array<IntArray>): IntArray {
    var answer = arr.copyOf()

    repeat(queries.size){
        for(i in queries[it][0] .. queries[it][1]){
            if (i % queries[it][2] != 0) continue
            answer[i] = (answer[i]+1)

        }
    }

    return answer
}

/** 배열 만들기 2 */
fun solution33(l: Int, r: Int): List<Int> {
    val answerList = mutableListOf<Int>()

    // 5의 배수로 만들기 -> step 활용 가능
    val startPoint = if (l % 5 != 0) (l + (5 - (l%5))) else l
    for (i in startPoint..r step 5){
        for (v in 0 until i.toString().length){
            if (i.toString()[v] != '5' && i.toString()[v] != '0' ) break
            if (v == i.toString().length - 1) answerList.add(i)
        }
    }

    return if (answerList.isEmpty()) listOf(-1) else answerList
}

/** 카운트 업 */
fun solution34(start_num: Int, end_num: Int): List<Int> {

    val answerList = mutableListOf<Int>()

    for (i in start_num..end_num) answerList.add(i)

    return answerList
}

/** 콜라츠 수열 */
fun solution35(n: Int): List<Int> {
    val answer = mutableListOf<Int>().apply { add(n) }
    var num = n
    while (num != 1){
        num = if (num % 2 == 0) num / 2 else 3 * num + 1
        answer.add(num)
    }
    return answer
}

/** 배열 만들기 4 */
fun solution36(arr: IntArray): List<Int> {
    val stk = mutableListOf<Int>()
    var i = 0

    while (i < arr.size){
        if (stk.isEmpty()) {
            stk.add(arr[i])
            i++
        } else {
            if (stk[stk.size-1] < arr[i]){
                stk.add(arr[i])
                i++
            } else stk.removeLast()
        }
    }

    return stk
}