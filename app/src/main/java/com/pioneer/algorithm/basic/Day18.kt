package com.pioneer.algorithm.basic

fun main(){
//    solution86("xabcxdefxghi").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    solution87("abxaabxxaasdexjxykjbx").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(solution88("43 + 12"))
//    println(solution89("ABBAA", "AAB B"))
    println(solution90("masterpiece"))
}

/** x 사이의 개수 */
fun solution86(myString: String): List<Int> {
    val returnList = mutableListOf<Int>()
    var count = 0
    for (i in 0 until myString.length){
        if (myString[i] == 'x') {
            returnList.add(count)
            count = 0
        } else count++
        if (i == myString.length-1) returnList.add(count)
    }
    return returnList
}

/** 문자열 잘라서 정렬하기 */
fun solution87(myString: String): List<String> {
    val returnList = mutableListOf<String>()
    var temp = ""
    for (i in 0 until myString.length){
        if (myString[i] == 'x') {
            if (temp != "") returnList.add(temp)
            temp = ""
        } else {
            temp += myString[i].toString()
        }
        if (i == myString.length-1 && temp != "") returnList.add(temp)
    }
    return returnList.sorted()
}

/** 간단한 식 계산하기 */
fun solution88(binomial: String): Int {
    val calList = binomial.split(" ")
    return when (calList[1]){
        "+" -> calList[0].toInt() + calList[2].toInt()
        "-" -> calList[0].toInt() - calList[2].toInt()
        "*" -> calList[0].toInt() * calList[2].toInt()
        else -> 0
    }

}

/** 문자열 바꿔서 찾기 */
fun solution89(myString: String, pat: String): Int {
    var answer = 0
    var reversString = ""
    repeat(myString.length){
        reversString += if (myString[it] == 'A') "B" else "A"
    }

    for (i in reversString.length - pat.length downTo 0){
        if (reversString.substring(i, i+pat.length) == pat) {
            answer = 1
            break
        }
    }
    return answer
}

/** rny_string */
fun solution90(rny_string: String): String {
    return rny_string.replace("m", "rn")
}

//ab
//x
//aab
//xx
//aasde
//x
//j
//x
//ykjb
//x