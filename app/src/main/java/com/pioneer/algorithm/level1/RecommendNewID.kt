package com.pioneer.algorithm.level1

fun main(){
    println(recommendNewID("...!@BaT#*..y.abcdefghijklm"))
}

fun recommendNewID(new_id: String): String {
    println("Input : $new_id")
    // 1. 대문자 -> 소문자 치환 / 3. .. 2개면 .개로 치환
    val filtered = new_id.lowercase().replace(Regex("[^a-z0-9._\\-]"), "").replace(Regex("""\.+"""), ".")
    val answer = StringBuilder(filtered)
    println("1, 2, 3 : $answer")

    // 4. .이 처음, 끝에 있으면 제거
    if (answer.isNotEmpty() && answer[0] == '.') answer.deleteAt(0)
    if (answer.isNotEmpty() && answer[answer.length-1] == '.') answer.deleteAt(answer.length-1)
    println("4. : $answer")
    // 5. 빈 문자열이면 a 대입
    if (answer.toString() == "") answer.append("a")
    println("5. : $answer")
    // 6. 15초과면 15로 만들고, 마지막이 .이면 제거
    if (answer.length > 15){
        answer.delete(15, answer.length)
        if (answer[answer.length-1] == '.') answer.deleteAt(answer.length-1)
    }
    println("6. : $answer")
    // 7. 3 미만이면 마지막 문자를 길이가 3일때까지 이어 붙이기
    while (answer.length < 3){
        answer.append(answer[answer.length-1])
    }
    println("7. : $answer")
    return answer.toString()
}