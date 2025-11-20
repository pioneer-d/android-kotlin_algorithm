package com.pioneer.algorithm.level1

import com.pioneer.algorithm.introduction.iSolution7

fun main(){
    getReportResult(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"), 2).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}

fun getReportResult(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val answerArray = IntArray(id_list.size)
    val reportSystemMap = mutableMapOf<String, MyReportCase>()
    repeat(id_list.size){
        reportSystemMap[id_list[it]] = MyReportCase(it, mutableSetOf(), mutableSetOf())
    }
    repeat(report.size){
        val (reporter, target) = report[it].split(" ")
        reportSystemMap[reporter]!!.setReport.add(target)   // 내가 신고한 사람 누적
        reportSystemMap[target]!!.getReport.add(reporter)   // 내가 신고 받은 사람 누적
        if (reportSystemMap[target]!!.getReport.size == k) reportSystemMap[target]!!.isRestrict = true
    }

    repeat(id_list.size){
        if (reportSystemMap[id_list[it]]!!.isRestrict){
            for (element in reportSystemMap[id_list[it]]!!.getReport) {
                answerArray[reportSystemMap[element]!!.index] += 1
            }
        }

    }
    return answerArray
}

data class MyReportCase(
    val index: Int,
    val setReport: MutableSet<String>,
    val getReport:  MutableSet<String>,
    var isRestrict: Boolean = false
)
