package com.pioneer.algorithm.basic

fun main(){
//    solution1()
//    solution2()
//    solution3()
    solution4()
//    solution5()
}

/** 문자열 출력하기 */
fun solution1(){
    val inputString = readLine()
    println(inputString)

    // 다른 방법
//    readLine()?.let(::println)
    // let : 자기자신 반환하는 확장함수
    // :: : 함수 프로퍼티
}

/** a와 b 출력하기 */
fun solution2(){
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("a = $a\nb = $b")
}

/** 문자열 반복해서 출력하기 */
fun solution3(){
    val input = readLine()!!.split(' ')
    val s1 = input[0]
    val a = input[1]!!.toInt()

    repeat(a){ print(s1) }
}

/** 대소문자 바꿔서 출력하기 */
fun solution4(){
    val s1 = readLine()!!
    for(i in 0 until s1.length){
        if (s1[i].isUpperCase()){
            print(s1[i].lowercase())
        } else print(s1[i].uppercase())
    }
}

/** 특수문자 출력하기 */
fun solution5(){
    print("!@#$%^&*(\\'\"<>?:;")

    // 다른 풀이
//    print("""!@#$%^&*(\'"<>?:;""")
}