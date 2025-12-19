package com.pioneer.algorithm


fun main(){
}

/** Introduction -> Day 20 -> 다항식 더하기 */
fun again80(polynomial: String): String {
    /*
    "3x + 7 + x"	"4x + 7"
    "x + x + x"	"3x"
     */
    var xCount = 0
    var intCount = 0
    val calList = polynomial.split(" ")
    for (i in 0 until calList.size){
        val target = calList[i]
        when {
            target == "+" -> continue
            target == "x" -> xCount++
            target[target.length-1] == 'x' -> xCount += target.replace("x" ,"").toInt()
            else -> intCount += target.toInt()
        }
    }

    return when {
        xCount != 0 && intCount != 0 -> xCount.toString()+"x + $intCount"
        xCount != 0 && intCount == 0 -> xCount.toString()+"x"
        xCount == 0 && intCount != 0 -> intCount.toString()
        else -> "0"
    }



    /*
    var xCount = BigInteger("0")
    var intCount = BigInteger("0")
    val calList = polynomial.split(" ")
    for (i in 0 until calList.size){
        val target = calList[i]
        when {
            target == "+" -> continue
            target == "x" -> xCount++
            target[target.length-1] == 'x' -> xCount += BigInteger(target.replace("x" ,""))
            else -> intCount += BigInteger(target)
        }
    }

    return when {
        xCount.toString() != "0" && intCount.toString() != "0" -> xCount.toString()+"x + $intCount"
        xCount.toString() != "0" && intCount.toString() == "0" -> xCount.toString()+"x"
        xCount.toString() == "0" && intCount.toString() != "0" -> intCount.toString()
        else -> "0"
    }
     */
}