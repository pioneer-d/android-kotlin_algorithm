package com.pioneer.algorithm


fun main(){
}

// com.pioneer.algorithm.introduction Day 12
// 현재 문제 : 2의 제곱수들이 무한 루프 현상 됨.
/** 소인수분해 */
fun iSolution48(n: Int): IntArray {
    if (n == 2) return intArrayOf(2)
    var breakPoint = true
    var innerBreak = false
    var startPoint = 0
    val unitList = mutableListOf(n)
    while (breakPoint){
        for (i in startPoint until unitList.size){
            println("${unitList[i]} 차례")
            for (l in 2 .. unitList[i]-1){
                if (l == 2 && unitList[i] == 2) continue
                println("${unitList[i]} 를 $l 로 나눴을 때")
                if (unitList[i] % l == 0){
                    println("약수 발견 : $l")
                    unitList.add(unitList[i] / l)
                    unitList.add(l)
                    unitList.apply {
                        repeat(this.size){
                            println("추가 후 list[$it] : ${unitList[it]}")
                        }
                    }
                    unitList.removeAt(i)
                    unitList.apply {
                        repeat(this.size){
                            println("제거 후 list[$it] : ${unitList[it]}")
                        }
                    }
                    startPoint = i
                    innerBreak = true
                    break
                }
                if (l == unitList[i]-1) breakPoint = false
            }
            if (innerBreak) {
                innerBreak = false
                break
            }
        }
    }
    val answerSet = mutableSetOf<Int>()
    repeat(unitList.size){
        answerSet.add(unitList[it])
    }
    return answerSet.toIntArray().sortedArray()
}
