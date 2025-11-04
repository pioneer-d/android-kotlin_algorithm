package com.pioneer.algorithm.basic

fun main(){
//    solution71(intArrayOf(1, 2, 3, 100, 99, 98)).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
//    println(solution72(intArrayOf(1, 2, 3, 100, 99, 98)))
//    println(solution73(intArrayOf(12, 4, 15, 1, 14)))
//    println(solution74(intArrayOf(2, 3, 4, 5)))
    println(solution75("aaAA", "aaaaa"))
}

/** 조건에 맞게 수열 반환하기 1 */
fun solution71(arr: IntArray): List<Int> {
    val returnList = mutableListOf<Int>()

    repeat(arr.size){
        when {
            arr[it] >= 50 && arr[it] % 2 == 0 -> returnList.add(arr[it] / 2)
            arr[it] < 50 && arr[it] % 2 != 0 -> returnList.add(arr[it] * 2)
            else -> returnList.add(arr[it])
        }
    }

    return returnList
}

/** 조건에 맞게 수열 변환하기 2 */
fun solution72(arr: IntArray): Int {
    var beforeList = arr.toMutableList()
    var currentList = arr.toMutableList()
    var x = 0
    var answer = -1

    while (answer == -1){
        for (i in 0 until beforeList.size){
            when {
                beforeList[i] >= 50 && beforeList[i] % 2 == 0 -> currentList[i] = beforeList[i] / 2
                beforeList[i] < 50 && beforeList[i] % 2 != 0 -> currentList[i] = (beforeList[i] * 2) + 1
                else -> {}
            }
        }
        if (beforeList == currentList){
            answer = x
        } else {
            x++
            beforeList.clear()
            beforeList.addAll(currentList)
            continue
        }
    }

    return answer
}

/** 1로 만들기 */
fun solution73(num_list: IntArray): Int {
    var answer = 0
    repeat(num_list.size){
        var temp = num_list[it]
        while (temp != 1){
            temp = when{
                temp % 2 == 0 -> temp /2
                else -> (temp - 1) /2
            }
            answer++
        }
    }
    return answer
}

/** 길이에 따른 연산 */
fun solution74(num_list: IntArray): Int {
    var answer = 0
    if (num_list.size >= 11){
        repeat(num_list.size){
            answer += num_list[it]
        }
    } else {
        answer = 1
        repeat(num_list.size){
            answer *= num_list[it]
        }
    }
    return answer
}

/** 원하는 문자열 찾기 */
fun solution75(myString: String, pat: String): Int {
    var answer = 0
    if (myString.length >= pat.length){
        for (i in 0 until myString.length - pat.length + 1){
            if (myString.substring(i, i+pat.length).uppercase() == pat.uppercase()) {
                answer = 1
                break
            }
        }
    }
    return answer
    // 다른 풀이
    // if (myString.lowercase().contains(pat.lowercase())) 1 else 0
}