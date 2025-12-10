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
    iSolution48(420).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
//    for (n in 2..10000) {
//        val result = iSolution48(n).joinToString(", ", "[", "]")
//        println("Input : $n / Output : $result")
//    }
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
//    12 -> 2,3
//    17 -> 17
//    420 -> 2,3,5,7

    val unitSet = mutableSetOf(n)

    var breakPoint = true
    while (breakPoint){
        val removeTarget = mutableSetOf<Int>()
        for (unit in unitSet){
            val beforeUnitSetSize = unitSet.size
            for (i in 2 .. unit-1){
                if (unit % i == 0){
                    removeTarget.add(unit)
                    unitSet.add(i)
                    unitSet.add(unit / i)
                }
            }

            val afterUnitSetSize = unitSet.size
            if (beforeUnitSetSize == afterUnitSetSize) breakPoint = false
        }
        for (target in removeTarget){
            unitSet.remove(target)
        }
    }

    return unitSet.sorted().toIntArray()


//    if (n > 1 && (n and (n - 1)) == 0) return intArrayOf(2) // 비트 연산
//    var breakPoint = true
//    var innerBreak = false
//    var startPoint = 0
//    val unitList = mutableListOf(n)
//    while (breakPoint){
//        for (i in startPoint until unitList.size){
//            println("${unitList[i]} 차례")
//            for (l in 2 .. unitList[i]-1){
//                if (unitList[i] % l == 0){
//                    println("$l 로 나눠지는 경우")
//                    unitList.add(l)
//                    println("$l 추가")
////                    if (l != unitList[i] / l)
//                    unitList.add(unitList[i] / l)
//                    println("${unitList[i] / l} 추가")
//                    unitList.removeAt(i)
//                    println("${unitList[i]} 제거")
//                    startPoint = i
//                    innerBreak = true
//                    break
//                }
//                if (l == unitList[i]-1) breakPoint = false
//            }
//            if (innerBreak) {
//                innerBreak = false
//                break
//            }
//        }
//    }
//    val answerSet = mutableSetOf<Int>()
//    repeat(unitList.size){
//        answerSet.add(unitList[it])
//    }
//    return answerSet.toIntArray().sortedArray()
}
