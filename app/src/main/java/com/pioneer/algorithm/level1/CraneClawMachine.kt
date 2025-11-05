package com.pioneer.algorithm.level1

import java.util.Stack

fun main(){
    println(craneClawMachine(
        arrayOf(intArrayOf(0,0,0,0,0), intArrayOf(0,0,1,0,3), intArrayOf(0,2,5,0,1), intArrayOf(4,2,4,4,2), intArrayOf(3,5,1,3,1)),
        intArrayOf(1,5,3,5,1,2,1,4)))
}

/** 크레인 인형뽑기 게임 */
fun craneClawMachine(board: Array<IntArray>, moves: IntArray): Int {
    /** 1번째 방법 */
//    var answer = 0
//    val boardList = board.toMutableList()
//    val basketList = mutableListOf<Int>()
//
//    for (m in 0 until moves.size){
//        for (b in 0 until board.size){
//            val targetClaw = boardList[b][moves[m]-1]
//            if (targetClaw != 0) {
//                if (basketList.isNotEmpty() && basketList.last() == targetClaw){
//                    basketList.removeLast()
//                    answer += 2
//                    if (basketList.size > 2){
//                        while (basketList[basketList.size-2] == basketList[basketList.size-1]){
//                            basketList.removeLast()
//                            answer += 2
//                        }
//                    }
//                } else {
//                    basketList.add(boardList[b][moves[m]-1])
//                }
//                boardList[b][moves[m]-1] = 0
//                break
//            }
//        }
//    }
//
//    return answer

    /** 2번째 방법 */
    var answer = 0
    val boardList = board.toMutableList()
    val basketStack = Stack<Int>()

    for (m in 0 until moves.size){
        for (b in 0 until board.size){
            val targetClaw = boardList[b][moves[m]-1]
            if (targetClaw != 0) {
                if (basketStack.isNotEmpty() && basketStack.peek() == targetClaw){
                    basketStack.pop()
                    answer += 2
                    if (basketStack.size > 2){
                        while (basketStack.last() == basketStack[basketStack.size-1]){
                            basketStack.pop()
                            answer += 2
                        }
                    }
                } else {
                    basketStack.add(boardList[b][moves[m]-1])
                }
                boardList[b][moves[m]-1] = 0
                break
            }
        }
    }
    return answer
}

/**
 *  Input - board
 *  [
 *      [0,0,0,0,0],
 *      [0,0,1,0,3],
 *      [0,2,5,0,1],
 *      [4,2,4,4,2],
 *      [3,5,1,3,1]
 *  ]
 *
 *  Input - moves
 *  [1,5,3,5,1,2,1,4]
 *
 *  Output
 *  4
 *
 *  */

//4, 3, 1, 1, 3, 2, 4