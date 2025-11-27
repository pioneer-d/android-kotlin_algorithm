package com.pioneer.algorithm.level2

fun main(){
    openChat(arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")).apply {
        repeat(this.size){
            print(this[it])
        }
    }
}

fun openChat(record: Array<String>): List<String> {
    /* 닉네임 변경 방법
    채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
    채팅방에서 닉네임을 변경한다.
     */
    // 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열
    /*
    Enter UserId 닉네임
    Leave UserId
    Change UserId 닉네임
     */


    /**
     * User를 관리하는 Map
     *  - User : 최종 닉네임
     *  - Enter 혹은 Change일 때 확인 후 리프레시 해줌
     */
    /**
     * Enter, Leave를 관리하는 List<EnterLeaveLog>
     *  - Enter인지 Leave인지
     *  - 그때 누구인지
     */
    val userNicknameMap = mutableMapOf<String, String>()
    val userLogList = mutableListOf<EnterLeaveLog>()
    repeat(record.size){
        val flag = record[it].split(" ")[0]
        val userId = record[it].split(" ")[1]
        when (flag){
            "Enter" -> {
                val nickname = record[it].split(" ")[2]
                userNicknameMap[userId] = nickname
                userLogList.add(EnterLeaveLog(userId, true))
            }
            "Change" -> {
                val userId = record[it].split(" ")[1]
                val nickname = record[it].split(" ")[2]
                userNicknameMap[userId] = nickname
            }
            "Leave" -> {
                val userId = record[it].split(" ")[1]
                userLogList.add(EnterLeaveLog(userId, false))
            }
        }
    }
    val answerList = mutableListOf<String>()
    repeat(userLogList.size){
        when (userLogList[it].isEnter){
            true -> {
                answerList.add("${userNicknameMap[userLogList[it].userId]}님이 들어왔습니다.")
            }
            false -> {
                answerList.add("${userNicknameMap[userLogList[it].userId]}님이 나갔습니다.")
            }
        }
    }
    return answerList
}
data class EnterLeaveLog(
    val userId: String,
    val isEnter: Boolean
)