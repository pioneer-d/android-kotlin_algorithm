package com.pioneer.algorithm.introduction

fun main(){
    println(chickenCoupon(100))
}

/** 치킨 쿠폰 */
fun chickenCoupon(chicken: Int): Int {
    /**
     * 1081 / 10 -> 108
     * (108 + 1(나머지)) / 10 -> 10
     * (10 + 9(나머지)) / 10 -> 1
     * (1 + 9(나머지)) / 10 -> 1
     * => 120
     * */

    var answer = 0
    var temp = chicken

    var breakPoint = true
    while (breakPoint){
        answer += temp / 10
        temp = (temp / 10) + (temp % 10)
        if (temp / 10 < 1) breakPoint = false
    }

    return answer
}