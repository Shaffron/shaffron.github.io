
class Solution {
    // by Stringify
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }

        val str = x.toString()
        var i = 0
        var j = str.length -1

        while (i < j) {
            if (str[i++] != str[j--]) {
                return false
            }
        }

        return true
    }

    // by Numeric
    fun isPalindrome(x: Int): Boolean {
        var origin = x
        var reversed = 0

        while(origin > 0) {
            reversed = (reversed * 10) + (origin % 10)
            origin /= 10
        }

        return reversed == x
    }
}