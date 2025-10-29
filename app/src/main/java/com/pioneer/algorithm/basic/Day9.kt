package com.pioneer.algorithm.basic

fun main(){

//    solution41(arrayOf("0123456789","9876543210","9999999999999"), 50000, 5, 5).apply {
//        repeat(this.size){
//            println(this[it])
//        }
//    }
//    println(solution42(arrayOf("progressive", "hamburger", "hammer", "ahocorasick"),
//        arrayOf(intArrayOf(0, 4), intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(7, 7))))

//    println(solution43("ProgrammerS123", 11))

//    solution44("banana").apply {
//        repeat(this.size){
//            println(this[it])
//        }
//    }

    println(solution45("banana", "nan"))
}

/** 배열 만들기 5 */
fun solution41(intStrs: Array<String>, k: Int, s: Int, l: Int): List<Int>{

    val returnArray = mutableListOf<Int>()
    var cutString = ""

    repeat(intStrs.size){
        for (i in s until s+l){
            cutString += intStrs[it][i].toString()
        }
        if (cutString.toInt() > k) returnArray.add(cutString.toInt())
        cutString = ""
    }

    return returnArray
}

/** 부분 문자열 이어 붙여 문자열 만들기 */
fun solution42(my_strings: Array<String>, parts: Array<IntArray>): String{
    var answerString = ""

    repeat(my_strings.size){
        for (i in parts[it][0] .. parts[it][1]){
            answerString += my_strings[it][i]
        }
    }

    return answerString
}

/** 문자열의 뒤의 n글자 */
fun solution43(my_string: String, n: Int): String{
    val startPoint = my_string.length - n
    return my_string.substring(startPoint, my_string.length)
}

/** 접미사 배열 */
fun solution44(my_string: String): List<String> {
    val sortedList = mutableListOf<String>()
    repeat(my_string.length){
        val subString = my_string.substring(it, my_string.length)
        sortedList.add(subString)
    }

    return sortedList.sorted()
}

/** 접미사인지 확인하기 */
fun solution45(my_string: String, is_suffix: String): Int {
    val subStringMap = mutableMapOf<String, Int>()
    repeat(my_string.length){
        val subString = my_string.substring(it, my_string.length)
        subStringMap[subString] = 1
    }

    return if (subStringMap.containsKey(is_suffix)) 1 else 0
}


