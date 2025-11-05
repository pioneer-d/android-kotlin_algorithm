package com.pioneer.algorithm.level1

fun main(){
    runningRace(arrayOf("mumu", "soe", "poe", "kai", "mine"), arrayOf("kai", "kai", "mine", "mine")).apply {
        repeat(this.size){
            print("${this[it] }"+" ")
        }
    }
}

/** 달리기 경주 */
fun runningRace(players: Array<String>, callings: Array<String>): List<String> {
    val keyIsName = mutableMapOf<String, Int>()
    for (i in 0 until players.size){
        keyIsName[players[i]] = i
    }

    val keyIsRank = mutableMapOf<Int, String>()
    for (i in 0 until players.size){
        keyIsRank[i] = players[i]
    }

    repeat(callings.size){ index ->
        val targetName = callings[index]
        val targetCurrentRank = keyIsName[targetName]!!
        val downName = keyIsRank[targetCurrentRank-1]!!
        val downCurrentRank = keyIsName[downName]!!

        keyIsRank[targetCurrentRank] = downName
        keyIsRank[downCurrentRank] = targetName

        keyIsName[targetName] = downCurrentRank
        keyIsName[downName] = targetCurrentRank
    }


    val returnList: List<String> = MutableList(players.size) { "" }.apply {
        for (i in players.indices) {
            val index = keyIsName[players[i]] ?: continue
            this[index] = players[i]
        }
    }

    return returnList
}

//["mumu", "soe", "poe", "kai", "mine"]

//["kai", "kai", "mine", "mine"]

//["mumu", "kai", "mine", "soe", "poe"]


//func solution(_ players:[String], _ callings:[String]) -> [String] {
//    var temp = Dictionary<String, Int>()
//    var players = players
//    players.enumerated().map{temp[$1] = $0}
//
//    for c in callings {
//        guard let i = temp[c] else { return [] }
//        players.swapAt(i, i - 1)
//
//        temp[c]! -= 1
//        temp[players[i]]! += 1
//    }
//
//    return players
//}













