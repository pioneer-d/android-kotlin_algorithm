package com.pioneer.algorithm.basic

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.round

/** solution40번 아직 통과 못함  */
fun main(){
//    println(solution36(true, false, false, false))
//    println(solution37(6, 4, 2, 5))
//    println(solution38("cvsgiorszzzmrpaqpe", intArrayOf(16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7)))
//    print(solution39("78720646226947352489"))
    print(solution40("rermgorpsam", arrayOf(intArrayOf(2, 3), intArrayOf(0, 7), intArrayOf(5, 9), intArrayOf(6, 10))))
}

/** 간단한 논리 연산 */
fun solution36(x1: Boolean, x2: Boolean, x3: Boolean, x4: Boolean): Boolean {
    return (x1 || x2) && (x3 || x4)
}

/** 주사위 게임3 */
fun solution37(a: Int, b: Int, c: Int, d: Int): Int {
    var answer: Int = 0
    /**
     * 1. 네 주사위가 모두 같으면(p) -> p X 1111
     *
     * 2. 세 주사위가 같고(p), 하나가 다르면(q) -> (10 X p + q)^2
     * 3. 두개씩 같으면 (p, q) -> (p + q) x |p-q|
     *
     * 4. 두개가 같고(p) 나머지 2개는(q, r) 각각 다른 경우 -> q x r
     *
     * 5. 모두 다른 경우 -> 가장 작은 숫자
     * */

    val diceSet = setOf(a, b, c, d)
    when (diceSet.size){
        1 -> { answer = 1111 * a }
        2 -> {
            when {
                a == b && a == c ->  answer = (10 * a + d) * (10 * a + d)
                a == b && a == d ->  answer = (10 * a + c) * (10 * a + c)
                a == c && a == d ->  answer = (10 * a + b) * (10 * a + b)
                b == c && c == d ->  answer = (10 * b + a) * (10 * b + a)
                else -> {
                    when (a) {
                        b -> answer = (a + c) * abs(a - c)
                        c, d -> answer = (a + b) * abs(a - b)
                    }
                }
            }
        }
        3 -> {
            when {
                a == b -> answer = c * d
                a == c -> answer = b * d
                a == d -> answer = b * c
                b == c -> answer = a * d
                b == d -> answer = a * c
                c == d -> answer = a * b
            }
        }
        4 -> { answer = min(min(min(a, b), c), d) }
    }

    return answer
}

/** 글자 이어 붙여 문자열 만들기 */
fun solution38(my_string: String, index_list: IntArray): String {
    var answer: String = ""

    repeat(index_list.size){
        answer += my_string[index_list[it]].toString()
    }

    return answer
}

/** 9로 나눈 나머지 */
fun solution39(number: String): Int {
    var sum = 0
    repeat(number.length){
        sum += number[it].digitToInt()
    }
    return sum % 9
}

/** 문자열 여러 번 뒤집기 */
fun solution40(my_string: String, queries: Array<IntArray>): String {
    var answer = StringBuilder(my_string)

    repeat(queries.size){ it ->
        val ceilValue = ceil((queries[it][1].toFloat() - queries[it][0].toFloat()) / 2).toInt()
        println("횟수 : $ceilValue")
        repeat(ceilValue){ i ->
            val temp1 = answer[queries[it][1] - i]
            val temp2 = answer[queries[it][0] + i]
            answer[queries[it][0] + i] = temp1
            answer[queries[it][1] - i] = temp2
        }
    }

    return answer.toString()
}

// 1,  4,  2,  2