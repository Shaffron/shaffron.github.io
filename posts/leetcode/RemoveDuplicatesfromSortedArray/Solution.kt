class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var length = 1
        val replaceTarget = mutableListOf(nums[0])

        for (i in 1 until nums.size) {
            if (nums[i] > nums[i-1]) {
                length += 1
                replaceTarget.add(nums[i])
            }
        }

        replaceTarget.forEachIndexed { index, it ->
            nums[index] = it
        }

        return length
    }
}