package subtask2

class MiniMaxSum {


    fun getResult(input: IntArray): IntArray {
        var min = Int.MAX_VALUE
        var max = 0
        var sum = 0
        for (i in input.indices){
            if (input[i] < min){
                min = input[i]
            }
            if (input[i] > max){
                max = input[i]
            }
            sum += input[i]
        }
        return intArrayOf(sum-max, sum-min)
    }
}
