package com.pioneer.algorithm.introduction

fun main(){
    println(nextNum(intArrayOf(1, 2, 3, 4)))
}

fun nextNum(common: IntArray): Int {
    var temp1 = common[1] - common[0]
    var temp2 = common[2] - common[1]
    var r = 0
    var d = 0

    if (temp1 == temp2) d = temp1 else r = common[2] / common[1]

    return if (r == 0) common[common.size-1] + d else common[common.size-1] * r
}