package com.pioneer.algorithm.basic

import java.util.Stack

fun main(){
//    solution91("baconlettucetomato").apply {
//        repeat(this.size){
//            print(this[it]+" ")
//        }
//    }
//    solution92(intArrayOf(5, 1, 4)).apply {
//        repeat(this.size){
//            print(this[it])
//        }
//    }
//    solution93(intArrayOf(3, 2, 4, 1, 3), booleanArrayOf(true, false, true, false, false)).apply {
//        repeat(this.size){
//            print(this[it])
//        }
//    }
//    solution94(intArrayOf(0, 1, 1, 1, 0)).apply {
//        repeat(this.size){
//            print(this[it])
//        }
//    }
    solution95(intArrayOf(0, 1, 1, 2, 2, 3 ), 3).apply {
        repeat(this.size){
            print(this[it])
        }
    }
}

/** 세 개의 구분자 */
fun solution91(myStr: String): List<String> {
    val returnList = mutableListOf<String>()
    var temp = ""
    for (i in 0 until myStr.length){
        if (myStr[i] == 'a' || myStr[i] == 'b' || myStr[i] == 'c') {
            if (temp != "") returnList.add(temp)
            temp = ""
        } else {
            temp += myStr[i].toString()
        }
        if (i == myStr.length-1 && temp != "") returnList.add(temp)
    }

    return if (returnList.isEmpty()) listOf("EMPTY") else returnList
}

/** 배열의 원소만큼 추가하기 */
fun solution92(arr: IntArray): List<Int> {
    val returnList = mutableListOf<Int>()
    repeat(arr.size){
        for (i in 0 until arr[it]){
            returnList.add(arr[it])
        }
    }
    return returnList
}

/** 빈 배열에 추가, 삭제하기 */
fun solution93(arr: IntArray, flag: BooleanArray): List<Int> {
    val returnList = mutableListOf<Int>()
    repeat(flag.size){ it ->
        if (flag[it]){
            repeat(arr[it] * 2){ a ->
                returnList.add(arr[it])
            }
        } else {
            repeat(arr[it]){
                returnList.removeLast()
            }
        }
    }
    return returnList
}

/** 배열 만들기 6 */
fun solution94(arr: IntArray): Stack<Int> {
    val answerStack = Stack<Int>()
    var i = 0

    while (i != arr.size){
        if (answerStack.isEmpty()) {
            answerStack.push(arr[i])
        } else {
            if (answerStack.peek() == arr[i]) answerStack.pop() else answerStack.push(arr[i])
        }
        i++
    }
    if (answerStack.isEmpty()) answerStack.push(-1)
    return answerStack
}

/** 무작위로 K개의 수 뽑기 */
fun solution95(arr: IntArray, k: Int): List<Int> {
    val answerList = mutableListOf<Int>()
    val testSet = arr.toSet().toList()
    repeat(k){
        if (it < testSet.size) answerList.add(testSet[it])
        else answerList.add(-1)
    }
    return answerList
}