package com.pioneer.algorithm.basic

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(solution116(arrayOf("cafelatte", "americanoice", "hotcafelatte", "anything")))
//    solution117(arrayOf(".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."), 2).apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    solution118(intArrayOf(1, 2, 3, 100, 99, 98), 2).apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(solution119("abcdevwxyz"))
    solution120(3).apply {
        repeat(this.size){
            print("${this[it].contentToString()} ")
        }
    }
}

/** 커피 심부름 */
fun solution116(order: Array<String>): Int {
    var americano = 0
    var cafelatte = 0
    repeat(order.size){
        for (i in 0 until order[it].length - 1){
            when(order[it].substring(i, i+2)){
                "am" -> { americano++; break }
                "ca" -> { cafelatte++; break }
                "an" -> { americano++; break }
            }
        }
    }
    return (americano*4500)+(cafelatte*5000)
}

/** 그림 확대 */
fun solution117(picture: Array<String>, k: Int): List<String> {

    val answerList = mutableListOf<String>()
    repeat(picture.size){
        var lowAnswer = ""
        var beforeText = picture[it][0].toString()
        for (i in 1 until picture[it].length){
            if (beforeText[beforeText.length-1] == picture[it][i]) beforeText += picture[it][i].toString()
            else {
                repeat(k){
                    lowAnswer += beforeText
                }
                beforeText = picture[it][i].toString()
            }
        }
        repeat(k){
            lowAnswer += beforeText
        }
        repeat(k){
            answerList.add(lowAnswer)
        }
    }

    return answerList
}

/** 조건에 맞게 수열 변환하기 3 */
fun solution118(arr: IntArray, k: Int): IntArray {
    when (k % 2 == 0){
        true -> repeat(arr.size){ arr[it] = arr[it]+k }
        false -> repeat(arr.size){ arr[it] = arr[it]*k }
    }
    return arr
}

/** l로 만들기 */
fun solution119(myString: String): String {
    var answer = ""
    repeat(myString.length){
        if (myString[it] < 'l') answer += "l"
        else answer += myString[it].toString()
    }
    return answer
    // 다른 유용한 풀이
    // myString.replace("[a-k]".toRegex(), "l")
}

/** 특별한 이차원 배열 1 */
fun solution120(n: Int): List<IntArray> {
    val answerList = mutableListOf<IntArray>()
    for (i in 0 until n){
        answerList.add(IntArray(n).apply { this[i] = 1 })
    }
    return answerList
}