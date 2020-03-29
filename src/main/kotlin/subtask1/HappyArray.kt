package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.size <= 2) {
            return sadArray
        }
        val happyArray = ArrayList<Int>()
        happyArray.addAll(sadArray.asList())
        var flag = false
        while (true) {
            for ((i, el) in happyArray.withIndex()){
                if (i > 0 && i < happyArray.size-1){
                    if (happyArray[i] > happyArray[i-1] + happyArray[i+1]) {
                        happyArray.remove(el)
                        flag = true
                        break
                    }
                }
            }
            if (flag){
                flag = false
            }else{
                break
            }
        }
            return happyArray.toIntArray()
    }
}

