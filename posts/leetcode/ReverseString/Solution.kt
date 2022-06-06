class Solution {
    fun reverseString(s: CharArray): Unit {
        val length = s.size
        val partition = ceil(((length - 1) / 2.toDouble())).toInt()

        for (i in 0 until partition) {
            val decalcomani = length - (i + 1)
            val temp = s[decalcomani]
            s[decalcomani] = s[i]
            s[i] = temp
        }
    }
}