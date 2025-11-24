package com.pioneer.algorithm.level1

fun main(){
    println(mostReceivedGift(arrayOf("joy", "brad", "alessandro", "conan", "david"),
        arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"))
    )
}

// 가장 많이 받은 선물
fun mostReceivedGift(friends: Array<String>, gifts: Array<String>): Int {
    val answerMap = mutableMapOf<String, GiftChart>()
    var bestNextMonthGiftCount = 0
    repeat(friends.size){
        answerMap[friends[it]] = GiftChart(0, 0, 0, mutableMapOf(), 0)
    }
    repeat(gifts.size){
        val (left, right) = gifts[it].split(" ")
        answerMap[left].apply {
            this!!.giftTo += 1  // 준 횟수 +1
            giftPoint = giftTo - giftFrom   // 선물 지수 리프레시
            giftLinkMap[right] = if (giftLinkMap[right] != null) giftLinkMap[right]!! + 1 else 1  // 선물을 준 이력 저장
        }
        answerMap[right].apply {
            this!!.giftFrom += 1    // 받은 횟수 +1
            giftPoint = giftTo - giftFrom   // 선물 지수 리프레시
        }
    }

    for (i in 0 until friends.size){
        for (l in 0 until friends.size){
            if (friends[i] == friends[l]) continue
            val friendsIToLCount = answerMap[friends[i]]!!.giftLinkMap[friends[l]]
            val friendLToICount = answerMap[friends[l]]!!.giftLinkMap[friends[i]]
            val isLink = friendsIToLCount != null && friendLToICount != null

            if (isLink){    // 주고 받은 경험이 있는 경우
                when {
                    // I가 더 많이 준 경우
                    friendsIToLCount > friendLToICount -> answerMap[friends[i]]!!.nextMonthGift += 1
                    // L이 더 많이 준 경우
                    friendLToICount > friendsIToLCount -> {}
                    answerMap[friends[i]]!!.giftPoint > answerMap[friends[l]]!!.giftPoint -> answerMap[friends[i]]!!.nextMonthGift += 1
                }
            } else {    // 주고 받은 기록이 없는 경우
                when {
                    // I만 준 경우
                    friendsIToLCount != null -> answerMap[friends[i]]!!.nextMonthGift += 1
                    // L만 준 경우
                    friendLToICount != null -> {}
                    answerMap[friends[i]]!!.giftPoint > answerMap[friends[l]]!!.giftPoint -> answerMap[friends[i]]!!.nextMonthGift += 1
                }
            }
        }
    }

    repeat(friends.size){
        val someoneNextMonthGiftCount = answerMap[friends[it]]!!.nextMonthGift
        if (someoneNextMonthGiftCount > bestNextMonthGiftCount) bestNextMonthGiftCount = someoneNextMonthGiftCount
    }
    // 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.

    // 분기점 1 : 주고 받은 이력이 있는가
    // 서로 주고받은 기록이 있다면
        //  두사람 중 더 많이 준 사람이 다음달에 선물 하나.
    // 아예 없거나, 한명만 있으면,
        // 선물 지수가 높은 사람이 낮은 사람으로부터 하나 받기.
        // 만약 선물 지수도 같다면 아무일도 X

    // (선물 지수) : 내가 준 선물 - 내가 받은 선물

    // 이때, 선물을 가장 많이 받을 친구의 선물 의 수는?

    //
    return bestNextMonthGiftCount
}

data class GiftChart(
    var giftTo: Int,
    var giftFrom: Int,
    var giftPoint: Int,
    val giftLinkMap: MutableMap<String, Int>,
    var nextMonthGift: Int
)