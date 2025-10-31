package com.pioneer.algorithm.basic

fun main(){

//    solution61(intArrayOf(2, 1, 6), 3).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }

//    solution62(intArrayOf(5, 2, 1, 7, 5), 3).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }

//    solution63(arrayOf("i")).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }

//    solution64(intArrayOf(2, 1, 6), 1).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }

    solution65(intArrayOf(4, 2, 6, 1, 7, 6), 2).apply {
        repeat(this.size){
            print("${this[it] }"+" ")
        }
    }

}

/** n 번째 원소부터 */
fun solution61(num_list: IntArray, n: Int): List<Int> {
    // subList는 원본이 수정되는 것에 따라 영향을 받음.
//    return num_list.toList().subList(n-1, num_list.size)
    val returnList = mutableListOf<Int>()
    for (i in n-1 until num_list.size){
        returnList.add(num_list[i])
    }
    return returnList
}
/** 61번 문제 차이
테스트 1 〉	통과 (14.58ms, 65.9MB)             테스트 1 〉	통과 (0.04ms, 62.2MB)
테스트 2 〉	통과 (16.82ms, 64.1MB)             테스트 2 〉	통과 (0.03ms, 61.3MB)
테스트 3 〉	통과 (23.07ms, 65MB)               테스트 3 〉	통과 (0.04ms, 62.7MB)
테스트 4 〉	통과 (14.54ms, 66.2MB)             테스트 4 〉	통과 (0.04ms, 61.1MB)
테스트 5 〉	통과 (13.95ms, 65.2MB)             테스트 5 〉	통과 (0.03ms, 62.6MB)
테스트 6 〉	통과 (19.47ms, 65.1MB)             테스트 6 〉	통과 (0.02ms, 63.3MB)
테스트 7 〉	통과 (23.04ms, 65MB)               테스트 7 〉	통과 (0.02ms, 64.4MB)
테스트 8 〉	통과 (22.16ms, 65.1MB)             테스트 8 〉	통과 (0.02ms, 64.1MB)
테스트 9 〉	통과 (22.38ms, 65.3MB)             테스트 9 〉	통과 (0.04ms, 64.7MB)
테스트 10 〉	통과 (18.20ms, 66MB)               테스트 10 〉	통과 (0.04ms, 61.9MB)
테스트 11 〉	통과 (15.87ms, 64.9MB)             테스트 11 〉	통과 (0.04ms, 62.8MB)
테스트 12 〉	통과 (21.46ms, 65.8MB)             테스트 12 〉	통과 (0.03ms, 62.5MB)
테스트 13 〉	통과 (22.30ms, 64MB)               테스트 13 〉	통과 (0.05ms, 62.9MB)
테스트 14 〉	통과 (19.30ms, 65.3MB)             테스트 14 〉	통과 (0.03ms, 63.1MB)
테스트 15 〉	통과 (20.15ms, 64.8MB)             테스트 15 〉	통과 (0.03ms, 65.1MB)
테스트 16 〉	통과 (15.37ms, 65.6MB)             테스트 16 〉	통과 (0.03ms, 61.1MB)
테스트 17 〉	통과 (15.40ms, 65.3MB)             테스트 17 〉	통과 (0.03ms, 60.4MB)
테스트 18 〉	통과 (13.54ms, 65.5MB)             테스트 18 〉	통과 (0.03ms, 64.4MB)
테스트 19 〉	통과 (13.80ms, 65.4MB)             테스트 19 〉	통과 (0.03ms, 63.1MB)
테스트 20 〉	통과 (13.86ms, 64.9MB)             테스트 20 〉	통과 (0.03ms, 63MB)
 */

/** 순서 바꾸기 */
fun solution62(num_list: IntArray, n: Int): List<Int> {
    val returnList = mutableListOf<Int>()
    for (i in n until num_list.size){ returnList.add(num_list[i]) }
    for (i in 0 until n){ returnList.add(num_list[i]) }
    return returnList
}

/** 아직 완료 X */
/** 왼쪽 오른쪽 */
fun solution63(str_list: Array<String>): List<String> {
//    l, r
//    l이면 완쪽부터
//    r이면 오른쪽부터
    val answerList = mutableListOf<String>()
    val LIndex = str_list.indexOf("l").coerceAtLeast(0)
    val RIndex = str_list.indexOf("r").coerceAtLeast(0)
    if (LIndex < RIndex){
        for (i in 0 until LIndex) { answerList.add(str_list[i]) }
    } else if (LIndex > RIndex){
        for (i in RIndex+1 until str_list.size) { answerList.add(str_list[i]) }
    } else {}

    return answerList
}

/** n 번째 원소까지 */
fun solution64(num_list: IntArray, n: Int): List<Int> {
    val returnList = mutableListOf<Int>()
    for (i in 0 until n){
        returnList.add(num_list[i])
    }
    return returnList
}

/** n개 간격의 원소들 */
fun solution65(num_list: IntArray, n: Int): List<Int> {
    val answerList = mutableListOf<Int>()
    for(i in 0 until num_list.size step n){
        answerList.add(num_list[i])
    }
    return answerList
}

