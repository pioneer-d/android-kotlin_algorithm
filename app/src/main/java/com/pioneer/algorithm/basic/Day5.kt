package com.pioneer.algorithm.basic

fun main(){
//    print(solution21("abc1abc1abc"))
//    print(solution22(7, 1, booleanArrayOf(false, false, false, true, false, false, false)))
//    print(solution23(4, 4, 4))
//    println(solution24(intArrayOf(3, 4, 5, 2, 1)))
    println(solution25(intArrayOf(5, 7, 8, 3)))
}

/** 코드 처리하기 */
fun solution21(code: String): String {

    var let = ""
    var mode = false    // 0

    for(i in 0 until code.length){
        if (code[i] == '1') {
            mode = !mode
            continue
        }
        when {
            !mode && i % 2 == 0 -> {
                let += code[i].toString()
                continue
            }
            mode && i % 2 != 0 -> {
                let += code[i].toString()
                continue
            }
        }
    }

    if (let == "") let = "EMPTY"

    return let
}

/** 등차수열의 특정한 항만 더하기 */
fun solution22(a: Int, d: Int, included: BooleanArray): Int {

    var answer = 0

    repeat(included.size){
        if (included[it]) answer += (it * d) + a
    }

    return answer
}

/** 주사위 게임2 */
fun solution23(a: Int, b: Int, c: Int): Int {

    var answer = 0

    setOf(a, b, c).apply {
        when (this.size){
            1 -> answer = (a + b + c) * ((a * a) + (b * b) + (c * c)) * ((a * a * a) + (b * b * b) + (c * c * c))
            2 -> answer = (a + b + c) * ((a * a) + (b * b) + (c * c))
            3 -> answer = (a + b + c)
        }
    }
    return answer
}

/** 원소들의 곱과 합 */
fun solution24(num_list: IntArray): Int {
    // 합이 곱보다 작으면 1, 크면 0
    var sum = 0
    var mul = 1
    repeat(num_list.size){
        sum += num_list[it]
        mul *= num_list[it]
    }
    return if (mul < sum * sum) 1 else 0
}

/** 이어 붙인 수 */
fun solution25(num_list: IntArray): Int {
    var odd = ""  // 홀수
    var even = "" // 짝수

    repeat(num_list.size) {
        if (num_list[it] % 2 != 0){
            odd += num_list[it].toString()
        } else {
            even += num_list[it].toString()
        }
    }

    return odd.toInt() + even.toInt()
}