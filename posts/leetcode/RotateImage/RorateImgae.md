---
layout: default
title: Rotate Image
parent: Leetcode
nav_order: 3
description: "Leetcode - Rotate Image"
permalink: /leetcode/rotate-image
---

# Problem
[Leetcode link](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/)

---
# Interpretation
* n * n 의 정방형 2차원 배열이 주어짐
* 시계방향으로 90도 회전된 2차원 배열이 되도록 주어진 배열의 값을 수정
* 새로운 배열을 만들어서는 안되며 기존에 주어진 배열 내에서 in-place 로 값을 수정하여 결과를 만들어내야 함

 ---
# Idea
* 배열의 최대 길이을 m 이라고 할 때, [x, y] 을 90도 회전한 위치는 [y, |x-m|] 이다 (`|x|`: x 의 절대값 ) 
* [x, y] 의 값을 90도 회전한다고 할때, 밀어내는 위치의 값들(180/270/360도 회전한 값) 도 같이 연속적으로 치환한다.
  * 단순 2중 for 문을 돌았을 때는 이전의 값을 저장해두는 방법이 복잡하므로 한번 치환을 시작하면 해당 위치와 연관된 값들도 같이 회전시키는 방식
  * 다이아몬드 치환 방식 (개인적으로 붙여본 이름임) 

---
# Implementation
* My
````kotlin
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

                while (true) {
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
````

* Best

````kotlin
class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        // 2중 for 문의 루프 범위를 정교하게 지정함으로써 치환하는 범위를 조정 
        for (i: Int in 0..((n + 1) / 2 - 1)) {
            for (j: Int in 0..(n / 2 - 1)) {
                val saved = matrix[i][j]
                
                // 한번에 90/180/270/360 도 회전과 관련된 값들을 치환해버리는건 나와 동일한 방식                
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = saved
            }
        }
    }
}
````