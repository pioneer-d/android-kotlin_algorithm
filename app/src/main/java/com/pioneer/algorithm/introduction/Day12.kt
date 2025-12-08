package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution45("nice to meet you"))
//    iSolution46("hi12392").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution47("aAb1B2cC34oOp"))
    iSolution48(2).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

/** 모음 제거 */
fun iSolution45(my_string: String): String {
    // a, e, i, o, u
    var answer = my_string
    val replaceText = "aeiou"
    replaceText.forEach { re ->
        answer = answer.replace(re.toString(), "")
    }
    return answer
}

/** 문자열 정렬하기 (1) */
fun iSolution46(my_string: String): IntArray {
    var intString = ""
    my_string.forEach { it ->
        if (it.digitToIntOrNull() != null){
            intString += it
        }
    }
    val answerArray = IntArray(intString.length)
    repeat(intString.length){
        answerArray[it] = intString[it].digitToInt()
    }
    return answerArray.sortedArray()
}

/** 숨어있는 숫자의 덧셈 (1) */
fun iSolution47(my_string: String): Int {
    var answer = 0
    var intString = ""
    my_string.forEach { it ->
        if (it.digitToIntOrNull() != null){
            intString += it
        }
    }
    repeat(intString.length){
        answer += intString[it].digitToInt()
    }
    return answer
}

/** 소인수분해 */
fun iSolution48(n: Int): IntArray {
    if (n == 2) return intArrayOf(2)
    var breakPoint = true
    var innerBreak = false
    var startPoint = 0
    val unitList = mutableListOf(n)
    while (breakPoint){
        for (i in startPoint until unitList.size){
            println("${unitList[i]} 차례")
            for (l in 2 .. unitList[i]-1){
                if (l == 2 && unitList[i] == 2) continue
                println("${unitList[i]} 를 $l 로 나눴을 때")
                if (unitList[i] % l == 0){
                    println("약수 발견 : $l")
                    unitList.add(unitList[i] / l)
                    unitList.add(l)
                    unitList.apply {
                        repeat(this.size){
                            println("추가 후 list[$it] : ${unitList[it]}")
                        }
                    }
                    unitList.removeAt(i)
                    unitList.apply {
                        repeat(this.size){
                            println("제거 후 list[$it] : ${unitList[it]}")
                        }
                    }
                    startPoint = i
                    innerBreak = true
                    break
                }
                if (l == unitList[i]-1) breakPoint = false
            }
            if (innerBreak) {
                innerBreak = false
                break
            }
        }
    }
    val answerSet = mutableSetOf<Int>()
    repeat(unitList.size){
        answerSet.add(unitList[it])
    }
    return answerSet.toIntArray().sortedArray()
}
