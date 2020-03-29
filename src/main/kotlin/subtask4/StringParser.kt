package subtask4

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val brackets = mapOf('<' to '>', '[' to ']', '(' to ')' )
        var substrings = ArrayList<String>()
        for (i in inputString.indices){
            if (brackets.containsKey(inputString[i])){
                val openBracket = inputString[i]
                val closeBracket = brackets[openBracket]


                var sameBracketPos = inputString.substring(i + 1).indexOf(openBracket)


                var lastPos = inputString.substring(i + 1).indexOf(closeBracket ?: error(""))


                while (sameBracketPos in 1 until lastPos) {
                    lastPos = inputString.substring(lastPos + 1).indexOf(closeBracket ?: error(""))
                    sameBracketPos = inputString.substring(sameBracketPos + 1).indexOf(openBracket)
                }
                if (lastPos < 0){
                    break
                }
                substrings.add(inputString.substring(i +1,i+lastPos+1))

            }
        }
        return substrings.toArray(emptyArray<String>())
    }
}
