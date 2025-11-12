package com.pioneer.algorithm.level1

fun main(){
    personalInformationExpiration(
        "2022.05.19",
        arrayOf("A 6", "B 12", "C 3"),
        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    ).apply {
        repeat(this.size){
            print("${this[it] }"+" ")
        }
    }
}

fun personalInformationExpiration(today: String, terms: Array<String>, privacies: Array<String>): List<Int> {
    val answerList = mutableListOf<Int>()
    // 모든 달은 28일
    val termsMap = mutableMapOf<String, Int>()
    repeat(terms.size){
        termsMap[terms[it].split(" ")[0]] = terms[it].split(" ")[1].toInt()
    }
    repeat(privacies.size){
        val endDate = calEndDate(
            privacies[it].split(" ")[0],
            termsMap[privacies[it].split(" ")[1]]!!
        )
        if (isExpired(today,endDate)) answerList.add(it+1)
    }
    return answerList
}

fun calEndDate(startDate: String, termMonth: Int): String{
    var (carYear, carMonth, carDay) = startDate.split(".")
    var finalMonth = carMonth.toInt()+termMonth
    while (finalMonth > 12){
        finalMonth += -12
        carYear = (carYear.toInt() + 1).toString()
    }
    if (finalMonth == 0) finalMonth = 1

    carDay = (carDay.toInt() - 1).toString()
    if (carDay == "0") {
        carDay = "28"
        finalMonth = (finalMonth - 1)
    }
    if (finalMonth == 0){
        finalMonth = 12
        carYear = (carYear.toInt() - 1).toString()
    }
    println("endDate : $carYear.$finalMonth.$carDay")
    return "$carYear.$finalMonth.$carDay"
}

fun isExpired(today: String, endDate: String): Boolean{
    var isExpired = false
    val (todayYear, todayMonth, todayDay) = today.split(".")
    val (endYear, endMonth, endDay) = endDate.split(".")
    when {
        todayYear.toInt() > endYear.toInt() -> isExpired = true
        todayYear.toInt() == endYear.toInt() && todayMonth.toInt() > endMonth.toInt() -> isExpired = true
        todayYear.toInt() == endYear.toInt() && todayMonth.toInt() == endMonth.toInt() && todayDay.toInt() > endDay.toInt() -> isExpired = true
    }
    return isExpired
}

/**
today	        terms	                privacies	                                                                        result
"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	                [1, 3]
"2020.01.01"	["Z 3", "D 5"]	        ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]
  */