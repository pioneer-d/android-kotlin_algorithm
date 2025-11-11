package com.pioneer.algorithm.level1

import com.pioneer.algorithm.basic.solution95

fun main(){
    failureRate(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

// 성능 개선 버전
fun failureRate(N: Int, stages: IntArray): List<Int> {
    val rateList = mutableListOf<StageRate>()
    repeat(N){
        rateList.add(StageRate(it+1, 0, 0))
    }
    for (s in 0 until stages.size){
        if (stages[s] == N+1) { // All Clear 경우
            repeat(N){ rateList[it].tryCount += 1 }
            continue
        }
        for (c in 0 until  stages[s]){
            rateList[c].tryCount += 1
            if (c == stages[s]-1) rateList[c].failCount += 1
        }
    }
    return rateList.sortedWith(compareBy({ it.tryCount.toFloat() / it.failCount.toFloat() }, { it.stageNum })).map { it.stageNum }
}

data class StageRate(
    val stageNum: Int,
    var tryCount: Int,
    var failCount: Int,
)

// 성능 안좋은 버전
//fun failureRate(N: Int, stages: IntArray): List<Int> {
//    val failureStagesCountList = MutableList(N, { i -> 0 })
//    val tryStageCountList = MutableList(N, { i -> 0 })
//    val rateList = mutableListOf<StageRate>()
//    for (s in 0 until stages.size){
//        if (stages[s] == N+1) {
//            repeat(tryStageCountList.size){
//                tryStageCountList[it] += 1
//            }
//            continue
//        }
//        for (c in 0 until  stages[s]){
//            tryStageCountList[c] += 1
//            if (c == stages[s]-1) failureStagesCountList[c] += 1
//        }
//    }
//    for (r in 0 until N){
//        rateList.add(StageRate(r+1, tryStageCountList[r].toFloat() / failureStagesCountList[r].toFloat()))
//    }
//    return rateList.sortedWith(compareBy({ it.failureRate }, { it.stageNum })).map { it.stageNum }
//}
//
//data class StageRate(
//    val stageNum: Int,
//    val failureRate: Float
//)

//  N	    stages	                    result
//  5	    [2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
//  4	    [4,4,4,4,4]	                [4,1,2,3]