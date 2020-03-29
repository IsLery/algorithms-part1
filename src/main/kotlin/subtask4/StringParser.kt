package subtask4

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val brackets = mapOf('<' to '>', '[' to ']', '(' to ')' )
        // val brackets = mapOf('<' to '>' )
        var substrings = ArrayList<String>()
        for (i in inputString.indices){
            if (brackets.containsKey(inputString[i])){
                val openBracket = inputString[i]
                val closeBracket = brackets[openBracket]
              //  println("opening bracket pos $i")
                // чтобы позиция была по-любому меньше и было попадание в первый цикл
                var substrOpenIndex = inputString.substring(i + 1).indexOf(openBracket)
                var sameBracketPos = i + 1 + substrOpenIndex
             //   println("more opening bracket pos $sameBracketPos")
                // чтобы прошло в первый цикл - первая закрывающая скобка
                var substrCloseIndex = inputString.substring(i + 1).indexOf(closeBracket ?: error(""))
                var lastPos = i + 1 + substrCloseIndex
             //   println("more opening bracket pos$lastPos")

                // если в субстринге позиция открывающей скобки меньше, чем закрывающей, то надо найти еще одну закрывающую
                while (substrOpenIndex > 0 && sameBracketPos < lastPos ) {
                    var nextCloseBr = inputString.substring(lastPos + 1).indexOf(closeBracket ?: error(""))
                    lastPos = lastPos +  nextCloseBr + 1
                    substrOpenIndex = inputString.substring(sameBracketPos + 1).indexOf(openBracket)
                    sameBracketPos = sameBracketPos + 1 + substrOpenIndex
                }
                if (lastPos < 0){
                    break
                }
              //  println("start index substring $i, end index substring $lastPos")
                substrings.add(inputString.substring(i +1,lastPos))
              //  println(inputString.substring(i +1,lastPos+1))
            }
        }
        return substrings.toArray(emptyArray<String>())
    }
}
