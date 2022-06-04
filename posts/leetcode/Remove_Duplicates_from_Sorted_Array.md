---
layout: default
title: Remove Duplicates from Sorted Array
parent: Leetcode Index
nav_order: 1
description: "Leetcode - Remove Duplicates from Sorted Array"
permalink: /leetcode/remove-duplicates-from-sorted-array
---

> [leetcode link](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/)

# 문제 해석
* 주어진 배열은 오름차순으로 정렬되어 있음
* 배열 내의 값들은 중복될 수 있음
* 배열 내의 정수 중 Unique 한 값이 몇개인지 반환
* Input 으로 주어진 배열의 순서를 변경하여 unique 한 값이 오름차순으로 정렬된 배열로 설정해야함
* Unique 한 값의 갯수만큼만 배열을 확인하며 범위 밖의 배열의 값은 어떤 값이어도 상관없음 (문제에서는 underscore 로 표기함)
* 제약사항
  * 배열 길이는 1 ~ 312 사이를 가짐
  * 배열 안의 값은 -100 ~ 100 사이의 정수 값
  * 배열은 오름차순으로 정렬되어 있음

# Solution
* 나의 해법
````kotlin
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
````

* 어떤 빌런의 해법...
```kotlin
class Solution {
  fun removeDuplicates(nums: IntArray): Int {
    var k = 0
    var checkedIndex = 1
    while (checkedIndex <= nums.size - 1) {
      if (nums[k] != nums[checkedIndex]) {
        k++
        nums[k] = nums[checkedIndex]
      }
      checkedIndex++
    }
    
    return k + 1
  }
}
```