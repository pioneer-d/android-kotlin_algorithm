package com.pioneer.algorithm.introduction

import kotlin.math.abs

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    iSolution78(arrayOf("left", "right", "up", "right", "right"), intArrayOf(11, 11)).apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
    println(iSolution80("1 + 112x + 1"))
}

/** 직사각형 넓이 구하기 */
fun iSolution77(dots: Array<IntArray>): Int {
    var width = 0
    var height = 0
    for (i in 0 until dots.size){
        val target1 = dots[i+1][0]
        val target2 = dots[i][0]
        if (target2 != target1){
            width = target1 - target2
            break
        }
    }
    for (i in 0 until dots.size){
        val target1 = dots[i+1][1]
        val target2 = dots[i][1]
        if (target2 != target1){
            height = target1 - target2
            break
        }
    }
    return abs(width * height)
}

/** 캐릭터의 좌표 */
fun iSolution78(keyinput: Array<String>, board: IntArray): IntArray {
    // up, down, left, right
    var xBoard = 0
    var yBoard = 0

    for (i in 0 until keyinput.size){
        when (keyinput[i]){
            "up" -> if (yBoard != (board[1]-1)/2) yBoard++
            "down" -> if (yBoard != -(board[1]-1)/2) yBoard--
            "left" -> if (xBoard != -(board[0]-1)/2) xBoard--
            "right" -> if (xBoard != (board[0]-1)/2) xBoard++
        }
    }

    return intArrayOf(xBoard, yBoard)
}

/** 최댓값 만들기 (2) */
fun iSolution79(numbers: IntArray): Int {
    val sortArray = numbers.sortedArray()

    return when {
        sortArray.last() < 0 && sortArray[0] < 0 -> sortArray[0] * sortArray[1]
        sortArray.last() > 0 && sortArray[0] > 0 -> sortArray[sortArray.size-1] * sortArray[sortArray.size-2]
        else -> {
            val target1 = sortArray[0] * sortArray[1]
            val target2 = sortArray[sortArray.size-1] * sortArray[sortArray.size-2]
            if (target1 > target2) target1 else target2
        }
    }

}

/** 다항식 더하기 */
fun iSolution80(polynomial: String): String {
/*
"3x + 7 + x"	"4x + 7"
"x + x + x"	"3x"
 */
    var xCount = 0
    var intCount = 0
    val calList = polynomial.split(" ")
    for (i in 0 until calList.size){
        val target = calList[i]
        when {
            target == "+" -> continue
            target == "x" -> xCount++
            target[target.length-1] == 'x' -> xCount += target.replace("x" ,"").toInt()
            else -> intCount += target.toInt()
        }
    }

    return when {
        xCount != 0 && intCount != 0 -> xCount.toString()+"x + $intCount"
        xCount != 0 && intCount == 0 -> xCount.toString()+"x"
        xCount == 0 && intCount != 0 -> intCount.toString()
        else -> "0"
    }



    /*
    var xCount = BigInteger("0")
    var intCount = BigInteger("0")
    val calList = polynomial.split(" ")
    for (i in 0 until calList.size){
        val target = calList[i]
        when {
            target == "+" -> continue
            target == "x" -> xCount++
            target[target.length-1] == 'x' -> xCount += BigInteger(target.replace("x" ,""))
            else -> intCount += BigInteger(target)
        }
    }

    return when {
        xCount.toString() != "0" && intCount.toString() != "0" -> xCount.toString()+"x + $intCount"
        xCount.toString() != "0" && intCount.toString() == "0" -> xCount.toString()+"x"
        xCount.toString() == "0" && intCount.toString() != "0" -> intCount.toString()
        else -> "0"
    }
     */
}
