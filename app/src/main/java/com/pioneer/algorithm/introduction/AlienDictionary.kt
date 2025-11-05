package com.pioneer.algorithm.introduction

fun main(){
    print(alienDictionary(arrayOf("s", "o", "m", "d"), arrayOf("moos", "dzx", "smm", "sunmmo", "som")))
}

/** 외계어 사전 */
fun alienDictionary(spell: Array<String>, dic: Array<String>): Int {
    // dic의 개수만큼 순회
        // 하나의 단어 길이만큼 순회
            // Spell 개수 만큼 순회
            // -> 동일한게 있으면 continue,
                // -> Char형 List에 해당 값 있는지 확인 후 저장.
                    // -> 이미 있는 Char면 다시 break.
                // -> 끝까지 다 돌고, List의 길이와, spell의 개수가 동일하면 Return 1
            // -> 없으면 break
        //
    var answer = false

    for (d in 0 until dic.size){    // 단어 개수
        val spellExistSet = mutableSetOf<Char>()
        for (w in 0 until dic[d].length){   // 하나의 단어 길이

            var isContinue = true
            for (s in 0 until spell.size){      // Spell 단어 길이
                if (spell[s] == dic[d][w].toString()){  // 같은게 몇번 있는지 판단.
                    if (!spellExistSet.add(dic[d][w])) {
                        isContinue = false
                        break
                    }
                }
            }
            if (isContinue && w == dic[d].length - 1 && spellExistSet.size == spell.size){
                answer = true
            }
        }
    }

    return if (answer) 1 else 2
}