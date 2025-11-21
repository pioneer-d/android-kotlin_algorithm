package com.pioneer.algorithm.level1

fun main(){
    println(personalityTypeTest(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5)))
}

/** 성격 유형 검사하기 */
fun personalityTypeTest(survey: Array<String>, choices: IntArray): String {

    val answerArray = IntArray(4)
    /*
     [0] -> 음수면 R / 양수면 T
     [1] -> 음수면 C / 양수면 F
     [2] -> 음수면 J / 양수면 M
     [3] -> 음수면 A / 양수면 N
     */

    fun calChoice(num: Int): Pair<Int, Int>{
        // 0번 페어는 방향 (0 -> 비동의쪽 / 1 -> 동의쪽)
        // 1번 페어는 점수
        // 2번 넘기기
        return when (num){
            1 -> Pair(0, 3)  // 비동의, 3점
            2 -> Pair(0, 2)  // 비동의, 2점
            3 -> Pair(0, 1)  // 비동의, 1점
            4 -> Pair(2, 0)  // 모르겠음
            5 -> Pair(1, 1)  // 동의, 1점
            6 -> Pair(1, 2)  // 동의, 2점
            7 -> Pair(1, 3)  // 동의, 3점
            else -> { Pair(0, 0) }
        }
    }

    fun addScore(target: Char, score: Int){
        when (target){
            'R' -> answerArray[0] = answerArray[0]-score
            'T' -> answerArray[0] = answerArray[0]+score
            'C' -> answerArray[1] = answerArray[1]-score
            'F' -> answerArray[1] = answerArray[1]+score
            'J' -> answerArray[2] = answerArray[2]-score
            'M' -> answerArray[2] = answerArray[2]+score
            'A' -> answerArray[3] = answerArray[3]-score
            'N' -> answerArray[3] = answerArray[3]+score
        }
    }

    for (i in 0 until survey.size){
        val whereIGo = calChoice(choices[i])
        when (whereIGo.first){
            0 -> { addScore(survey[i][0], whereIGo.second) }
            1 -> { addScore(survey[i][1], whereIGo.second) }
            2 -> continue   // 모르겠음 경우 넘기기
        }

    }

    val num1Personal = if (answerArray[0] <= 0) "R" else "T"
    val num2Personal = if (answerArray[1] <= 0) "C" else "F"
    val num3Personal = if (answerArray[2] <= 0) "J" else "M"
    val num4Personal = if (answerArray[3] <= 0) "A" else "N"

    return num1Personal+num2Personal+num3Personal+num4Personal
}