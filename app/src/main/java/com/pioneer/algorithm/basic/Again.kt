package com.pioneer.algorithm.basic


/** Day 12 */
fun solution56_a(n: Int, slicer: IntArray, num_list: IntArray): List<Int> {
    val returnList = mutableListOf<Int>()
    val startPoint = if (n == 1) 0 else slicer[0]
    val endPoint = if (n == 2) slicer.size-1 else slicer[1]
    val stepPoint = if (n == 4) slicer[2] else 1

    for (i in startPoint .. endPoint step stepPoint){
        returnList.add(num_list[i])
    }
    return returnList
}


/** Day 13 */
fun solution63_a(str_list: Array<String>): List<String> {
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