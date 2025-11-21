package com.pioneer.algorithm.introduction

fun main(){
//    solution("programmers").apply {
//        repeat(this.size){
//            print("${this[it]} ")
//        }
//    }
//    println(iSolution10(intArrayOf(1, 2, 3, 4, 5)))
    println(iSolution11(intArrayOf(1, 0, 2)))
    iSolution12(15).apply {
        repeat(this.size){
            print("${this[it]} ")
        }
    }
}
/** 나머지 구하기 */
fun iSolution9(num1: Int, num2: Int): Int {
    return num1 % num2
}

/** 중앙값 구하기 */
fun iSolution10(array: IntArray): Int {
    val sortedArray = array.sortedArray()
    return sortedArray[(sortedArray.size-1)/2]
}

/** 최빈값 구하기 */
fun iSolution11(array: IntArray): Int {
    val setArray = array.toSet()
    when {
        array.isEmpty() -> return -1
        array.size == 1 -> return array[0]
        setArray.size == array.size -> return -1
        else -> {
            val sortedArray = array.sortedArray()
            var bestCount = 1
            var bestValue = sortedArray[0]
            var currentCount = 1
            var isDuplication = false
            for (i in 1 until sortedArray.size){
                val currentValue = sortedArray[i]
                val beforeValue = sortedArray[i-1]
                // 이전값과 현재 값이 같은 경우
                if (currentValue == beforeValue){
                    currentCount++  // 현재 카운트 증가

                    // 현재 카운트와 역대 베스트 카운트가 동일한 경우
                    if (bestCount == currentCount) isDuplication = true

                    // 현재 카운트가 최고 갱신 하는 경우
                    if (currentCount > bestCount) {
                        // 유일하게 최고 처리
                        isDuplication = false

                        // 최고값, 최고 count 갱신
                        bestCount = currentCount
                        bestValue = currentValue
                    }
                    // 이전값과 현재 값이 다른 경우
                } else currentCount = 1
            }
            return if (isDuplication) -1 else bestValue
        }
    }
    // array -> sort
    // 현재값과 이전 값 비교
        // 이전 값과 같다면 currentCount 증가
        // 만약 bestCount보다 같으면 중복 best를 true로 처리
        // 만약 bestCount보다 크면 중복 best를 false처리 하고 bestCount에 currentCount 입력
            // 이때 bestValue에 currentCount 입력
        // 이전 값과 다르다면 currentCount 1로 초기화
}

/** 짝수는 싫어요 */
fun iSolution12(n: Int): IntArray {
    val arraySize = if (n % 2 == 0) n/2 else (n+1) / 2
    val answerArray = IntArray(arraySize)
    var addValue = 1
    repeat(arraySize){
        answerArray[it] = addValue
        addValue += 2
    }
    return answerArray
}
