---
layout: default
title: Reverse String
parent: Leetcode
nav_order: 2
description: "Leetcode - Reverse String"
permalink: /leetcode/reverse-string
---

# Problem

[Leetcode link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/)

---

# Interpretation

* 문자열 배열이 주어져 있음
* 문자열을 거꾸로 뒤집기

 ---

# Idea

* 문자열 배열을 순회하면서 현재 노드와 중앙을 기준으로 정반대의 위치(마치 데칼코마니 처럼)의 노드의 값을 바꿔치기 한다
* 모든 문자열을 순회할 필요 없이 딱 절반만 순회하면 된다

---

# Implementation

* My

````kotlin
class Solution {
    fun reverseString(s: CharArray): Unit {
        val length = s.size
        val partition = ceil(((length - 1) / 2.toDouble())).toInt()

        for (i in 0 until partition) {
            val decalcomania = length - (i + 1)
            val temp = s[decalcomania]

            s[decalcomani] = s[i]
            s[i] = temp
        }
    }
}
````

* Best

````kotlin
class Solution {
    fun reverseString(s: CharArray): Unit {
        var i = 0
        var j = s.size - 1

        // 무언가를 역순으로 뒤집는 방법에는 아래 방식을 참고하면 좋을듯!
        while (i < j) {
            val aux = s[i]

            // 후치 연산자를 멋지게 사용함
            s[i++] = s[j]
            s[j--] = aux
        }
    }
}
````