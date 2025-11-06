package com.pioneer.algorithm.basic

fun main(){
//    println(solution81("AbCdEFG", "dE"))
//    println(solution82("banana", "ana"))
//    solution83(arrayOf("and","notad","abcd")).apply {
//        repeat(this.size){
//            print(this[it]+" ")
//        }
//    }
//    solution84("programmers").apply {
//        repeat(this.size){
//            print(this[it]+" ")
//        }
//    }
    solution85("i    love  you").apply {
        repeat(this.size){
            print(this[it]+" ")
        }
    }
}

/** 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기 */
fun solution81(myString: String, pat: String): String {
    var answer = ""
    for (i in myString.length - pat.length downTo 0 ){
        if (myString.substring(i, i+pat.length) == pat) {
            answer = myString.substring(0, i+pat.length)
            break
        }
    }
    return answer
}

/** 문자열이 몇 번 등장하는지 세기 */
fun solution82(myString: String, pat: String): Int {
    var answer = 0
    for (i in 0 .. myString.length - pat.length){
        if (myString.substring(i, i+pat.length) == pat) answer++
    }
    return answer
}

/** ad 제거하기 */
fun solution83(strArr: Array<String>): List<String> {
    val answerList = mutableListOf<String>()
    for (s in 0 until strArr.size){

        val target = strArr[s]
        if (target.length < 2) {
            answerList.add(target)
            continue
        }

        for (i in 0 .. target.length - 2){
            if (target.substring(i, i+2) == "ad") break
            if (i == target.length - 2) answerList.add(target)
        }

    }
    return answerList
}

/** 공백으로 구분하기 1 */
fun solution84(my_string: String): List<String> {
    /*
    테스트 1 〉	통과 (7.10ms, 65.2MB)
    테스트 2 〉	통과 (6.99ms, 63.6MB)
    테스트 3 〉	통과 (6.81ms, 64.2MB)
    테스트 4 〉	통과 (7.63ms, 65MB)
    테스트 5 〉	통과 (11.13ms, 64.1MB)
    테스트 6 〉	통과 (7.12ms, 64.6MB)
    테스트 7 〉	통과 (10.83ms, 64.9MB)
     */
    return my_string.split(" ")
}

/** 공백으로 구분하기 2 */
fun solution85(my_string: String): List<String> {
    var temp = my_string.replace(Regex("""\s+"""), " ")
    if (temp[0].toString() == " ") temp = temp.substring(1, temp.length)
    if (temp[temp.length-1].toString() == " ") temp = temp.substring(0, temp.length-1)
    return temp.split(" ")
}

