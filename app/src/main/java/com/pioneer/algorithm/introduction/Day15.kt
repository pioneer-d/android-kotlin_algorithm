package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution57("onefourzerosixseven"))
//    println(iSolution58("hello", 1, 2))
//    println(iSolution59("abcabcadc"))
    iSolution60(24).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

/** 영어가 싫어요 */
fun iSolution57(numbers: String): Long {
    val numberSet = setOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    var check = ""
    var answer = ""
    for (i in 0 until numbers.length){
        check += numbers[i]
        if (numberSet.contains(check)){
            when (check){
                "zero" ->answer += "0"
                "one" -> answer += "1"
                "two" -> answer += "2"
                "three" -> answer += "3"
                "four" -> answer += "4"
                "five" -> answer += "5"
                "six" -> answer += "6"
                "seven" -> answer += "7"
                "eight" -> answer += "8"
                "nine" -> answer += "9"
            }
            check = ""
        }
    }
    return answer.toLong()
}

/** 안덱스 바꾸기 */
fun iSolution58(my_string: String, num1: Int, num2: Int): String {
    val answer = StringBuilder(my_string)
    val num1Char = my_string[num1]
    val num2Char = my_string[num2]
    answer.setCharAt(num1, num2Char)
    answer.setCharAt(num2, num1Char)
    return answer.toString()
}

/** 한 번만 등장한 문자 */
fun iSolution59(s: String): String {
    var answer = ""
    val checkSet = mutableSetOf<Char>()
    for (i in 0 until s.length){
        val target = s[i]
        if (!checkSet.add(target)) {
            answer = answer.replace(target.toString(),"", false)
        } else answer += target
    }
    return answer.split("").sorted().joinToString("")
}

/** 약수 구하기 */
fun iSolution60(n: Int): IntArray {
    val answerSet = mutableSetOf<Int>()
    for (i in 1 .. n){
        if (n % i == 0){
            answerSet.add(i)
            answerSet.add(n/i)
        }
    }
    return answerSet.sorted().toIntArray()
}
