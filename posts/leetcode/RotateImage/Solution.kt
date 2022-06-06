import java.lang.Math.abs

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        var min = 0
        var max = matrix.size - 1

        while (max > min) {
            for (i in min until max) {
                val startX = min
                val startY = i
                var (x, y) = startX to startY
                var temp: Int? = null

                while(true) {
                    val value = temp ?: matrix[x][y]
                    val switched = switchPosition(x, y, matrix.size - 1)

                    x = switched.first
                    y = switched.second

                    temp = matrix[x][y]
                    matrix[x][y] = value

                    if (x == startX && y == startY) {
                        break
                    }
                }
            }

            min++
            max--
        }
    }

    fun switchPosition(x: Int, y: Int, max: Int): Pair<Int, Int> {
        val switchedX = y
        val switchedY = abs(x - max)

        return switchedX to switchedY
    }
}