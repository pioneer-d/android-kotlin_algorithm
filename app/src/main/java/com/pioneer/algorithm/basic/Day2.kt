package com.pioneer.algorithm.basic

fun main(){
//    solution6()
//    solution7()
//    solution8()
//    solution9()
    solution10("He11oWor1d", "lloWorl", 2)
}

/** 덧셈식 출력하기 */
fun solution6(){
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    print("$a + $b = ${a+b}")
}

/** 문자열 붙여서 출력하기 */
fun solution7(){
    val input = readLine()!!.split(' ')
    val s1 = input[0]
    val s2 = input[1]
    print("$s1$s2")
}

/** 문자열 돌리기 */
fun solution8(){
    val s1 = readLine()!!
    for(i in 0 until s1.length){
        if (i == s1.length -1) print(s1[i]) else println(s1[i])
    }

    // 다른 풀이
//    s1.map(::println)
}

/** 홀짝 구분하기 */
fun solution9(){
    val a = readLine()!!.toInt()
    if (a % 2 == 0) print("$a is even") else print("$a is odd")
}

/** 문자열 곂쳐쓰기 */
fun solution10(my_string: String, overwrite_string: String, s: Int): String {
    val frontString = my_string.substring(0 until s)
    val endString = overwrite_string.substring(0 until overwrite_string.length)+
        if (my_string.length > overwrite_string.length) my_string.substring(s+overwrite_string.length until my_string.length) else ""
    return frontString+endString
}