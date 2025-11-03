package com.pioneer.algorithm.basic


fun main(){
    solution63(arrayOf("i")).apply {
        repeat(this.size){
            print("${this[it] }"+" ")
        }
    }
}

/** Day 13 */
fun solution63_a(str_list: Array<String>): List<String> {

//   ["u", "u", "l", "r"]       -> l : 2 / r : 3
//   ["u", "d", "u", "r", "d"]  -> l : 0 / r : 3
//   ["u", "d", "u", "l", "d"]  -> l : 3 / r : 0
//   ["u", "u", "r", "l"]       -> l : 3 / r : 2
//    l, r
//    l이면 완쪽부터
//    r이면 오른쪽부터
    val answerList = mutableListOf<String>()
    val LIndex = str_list.indexOf("l")
    val RIndex = str_list.indexOf("r")
    if ((RIndex > LIndex && LIndex != -1) || RIndex == -1 && LIndex > RIndex){
        for (i in 0 until LIndex) { answerList.add(str_list[i]) }
    } else if ((LIndex > RIndex) || LIndex == -1 && RIndex > LIndex){
        for (i in RIndex+1 until str_list.size) { answerList.add(str_list[i]) }
    } else {}

    return answerList
}