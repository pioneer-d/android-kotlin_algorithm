package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution85(15))
    println(iSolution87(arrayOf(intArrayOf(0,1), intArrayOf(2,5), intArrayOf(3,9))))
}

/** 저주의 숫자 3 */
fun iSolution85(n: Int): Int {
    var answer = 0
    var breakPoint = true
    for (i in 1 .. n){
        answer++
        while (breakPoint){
            if (answer % 3 == 0 || answer.toString().contains("3")) {
                answer++
            } else breakPoint = false
        }
        breakPoint = true
    }
    return answer
}

/** 평행 */
fun iSolution86(dots: Array<IntArray>): Int {
    var answer = 0
    fun returnGrade(aDot: IntArray, bDot: IntArray): Float {
        val x = if (aDot[0] > bDot[0]) aDot[0] - bDot[0] else bDot[0] - aDot[0]
        val y = if (aDot[0] > bDot[0]) aDot[1] - bDot[1] else bDot[1] - aDot[1]
        return (y.toFloat()/x.toFloat())
    }
    val target1 = returnGrade(dots[0], dots[1])
    val target2 = returnGrade(dots[2], dots[3])
    val target3 = returnGrade(dots[0], dots[2])
    val target4 = returnGrade(dots[1], dots[3])

    when {
        target1 == target2 -> answer = 1
        target3 == target4 -> answer = 1
    }
    return answer
}

/** 겹치는 선분의 길이 */
fun iSolution87(lines: Array<IntArray>): Int {
    var answer = 0

    val line1 = mutableSetOf<Int>()
    for (i in lines[0][0] until lines[0][1]){ line1.add(i) }
    val line2 = mutableSetOf<Int>()
    for (i in lines[1][0] until lines[1][1]){ line2.add(i) }
    val line3 = mutableSetOf<Int>()
    for (i in lines[2][0] until lines[2][1]){ line3.add(i) }

    for (i in -100 .. 99){
        var check = 0

        if (line1.contains(i)) check++
        if (line2.contains(i)) check++
        if (line3.contains(i)) check++

        if (check >= 2) answer++
    }

    return answer
}

/** 유한소수 판별하기 */
fun iSolution88(a: Int, b: Int): Int {
    fun gcd(x: Int, y: Int): Int {
        return if (y == 0) x else gcd(y, x % y)
    }
    val g = gcd(a, b)
    var denom = b / g
    while (denom % 2 == 0) {
        denom /= 2
    }
    while (denom % 5 == 0) {
        denom /= 5
    }
    return if (denom == 1) 1 else 2
}
