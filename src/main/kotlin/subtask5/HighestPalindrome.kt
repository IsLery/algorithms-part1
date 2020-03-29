package subtask5

import java.lang.StringBuilder

class HighestPalindrome {


    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        // n the number of digits in the number
        // k the maximum number of changes allowed

        var changesNeeded = 0
        var changeInPosition = ArrayList<Boolean>(n/2)
        var maxValPos = ArrayList<Char>(n/2)
        for (i in digitString.indices) {
            if (i < n / 2) {
                if ( digitString[i] > digitString[n - i - 1]) {
                    changesNeeded++
                    changeInPosition.add(true)
                    maxValPos.add(digitString[i])
                }else if    ( digitString[i] < digitString[n - i - 1]){
                    changesNeeded++
                    changeInPosition.add(true)
                    maxValPos.add(digitString[n - i - 1])
                } else {
                    changeInPosition.add(false)
                    maxValPos.add(digitString[i])
                }
            }else {
                break
            }
        }

        if (changesNeeded > k){
            return "-1"
        }

        if (changesNeeded == k){
            if (n % 2 == 1){
                return maxValPos.toString() + digitString[n/2+1] + maxValPos.reversed().toString()
            }
            return maxValPos.joinToString("") + maxValPos.reversed().joinToString("")
        }

        var restChanges = k - changesNeeded
        for (j in maxValPos.indices){
            if (changeInPosition[j] && restChanges >= 1 && maxValPos[j] < '9'){
                maxValPos[j] = '9'
                restChanges--
            }else if (!changeInPosition[j] && restChanges >= 2 && maxValPos[j] < '9'){
                maxValPos[j] = '9'
                restChanges -= 2
            }else if (restChanges == 0){
                break
            }
        }

        if (n % 2 == 1){
            if (restChanges > 0){
                return maxValPos.toString() + 9 + maxValPos.reversed().toString()
            }
            return maxValPos.toString() + digitString[n/2+1] + maxValPos.reversed().toString()
        }
        return maxValPos.joinToString("") + maxValPos.reversed().joinToString("")
    }
}
