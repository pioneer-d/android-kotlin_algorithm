package com.pioneer.algorithm.basic

fun main(){
//    println(solution76("aBcDeFg"))
//    println(solution77("aBcDeFg"))
//    solution78(arrayOf("AAA","BBB","CCC","DDD")).apply {
//        repeat(this.size){
//            print("${this[it] }"+" ")
//        }
//    }
//    println(solution79("abstract algebra"))
    println(solution80("programmers", "p"))
}

/** 대문자로 바꾸기 */
fun solution76(myString: String): String {
    return myString.uppercase()
}

/** 소문자로 바꾸기 */
fun solution77(myString: String): String {
    return myString.lowercase()
}

/** 배열에서 문자열 대소문자 변환 */
fun solution78(strArr: Array<String>): List<String> {
    val returnList = mutableListOf<String>()
    for (i in 0 until strArr.size){
        returnList.add(if (i % 2 == 0) strArr[i].lowercase() else strArr[i].uppercase())
    }
    return returnList
}

/** A 강조하기 */
fun solution79(myString: String): String {
    var answer = ""
    for (i in 0 until myString.length){
        answer += if (myString[i] == 'a') myString[i].uppercase() else if (myString[i] == 'A') myString[i] else myString[i].lowercase()
    }
    return answer
    // 다른 사람 풀이 (성능은 더 안좋음.)
    // return myString.lowercase().replace("a", "A")
}

/** 특정한 문자를 대문자로 바꾸기 */
fun solution80(my_string: String, alp: String): String {
    var answer = ""
    for (i in 0 until my_string.length){
        answer += if (my_string[i].toString() == alp) my_string[i].uppercase() else my_string[i]
    }
    return answer
}