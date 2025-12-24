package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution81("asdfgserter"))
//    println(iSolution82(arrayOf(intArrayOf(1, 1, 1, 1, 1), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 1, 0), intArrayOf(1, 1, 1, 1, 1))))
    println(iSolution83(intArrayOf(1, 2)))
}

/** 숨어있는 숫자의 덧셈 (2) */
fun iSolution81(my_string: String): Int {
    var answer = 0
    var temp = ""
    for (i in 0 until my_string.length){
        val target = my_string[i]
        if (target.isDigit()) {
            temp += target
        } else {
            answer += if (temp != "") temp.toInt() else 0
            temp = ""
        }
    }
    if (temp != "") answer += temp.toInt()
    return answer
}

/** 안전지대 */
fun iSolution82(board: Array<IntArray>): Int {
    // 이전 행의 -+= Index를 1로, 이후 행의 -+= Index를 1로
    var answer = 0
//    val answerList = board
    val answerList = board.map { it -> it.copyOf() }.toTypedArray()
    for (b in 0 until board.size){
        for (i in 0 until board[b].size){
            if (board[b][i] == 1){
                // 이전 행
                if (b-1 >= 0){
                    if (i-1 >= 0) answerList[b-1][i-1] = 1
                    if (i+1 < board[b-1].size) answerList[b-1][i+1] = 1
                    answerList[b-1][i] = 1
                }
                // 다음행
                if (b+1 < board.size){
                    if (i-1 >= 0) answerList[b+1][i-1] = 1
                    if (i+1 < board[b+1].size) answerList[b+1][i+1] = 1
                    answerList[b+1][i] = 1
                }
                if (i-1 >= 0) answerList[b][i-1] = 1
                if (i+1 < board[b].size) answerList[b][i+1] = 1
            }
        }
    }
    for (a in 0 until answerList.size){
        for (i in 0 until answerList[a].size){
            if (answerList[a][i] == 0) answer++
        }
    }
    answerList.apply {
        repeat(this.size){
            println(answerList[it].contentToString())
        }
    }
    return answer
}

/** 삼각형의 완성조건 (2) */
fun iSolution83(sides: IntArray): Int {
    var answer = 0
    val (target1, target2) = sides
    val tempArray = IntArray(3).apply {
        this[0] = target1
        this[1] = target2
    }
    for (i in 1 until target1+target2){
        tempArray[2] = i
        var maxIndex = 0
        var maxValue = 0
        for (i in 0 until tempArray.size){
            if (tempArray[i] > maxValue){
                maxIndex = i
                maxValue = tempArray[i]
            }
        }
        when (maxIndex){
            0 -> if (tempArray[1] + tempArray[2] > tempArray[0]) answer++
            1 -> if (tempArray[0] + tempArray[2] > tempArray[1]) answer++
            2 -> if (tempArray[1] + tempArray[0] > tempArray[2]) answer++
        }
    }
    return answer
}

/** 외계어 사전 */
fun iSolution84(){
    // -> AlienDictionary.kt 에서 확인!
}
