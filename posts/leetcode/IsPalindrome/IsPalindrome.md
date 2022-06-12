---
layout: default
title: Is Palindrome
parent: Leetcode
nav_order: 4
description: "Leetcode - Is Palindrome"
permalink: /leetcode/is-palindrome
---

# Problem

[Leetcode link](https://leetcode.com/problems/palindrome-number/)
---

# Interpretation
* 주어진 숫자가 회문인지 여부를 반환
  * 회문: 거꾸로 뒤집어도 동일한 결과가 나오는 숫자/문자

 ---

# Idea
* 문자열 방식
  * 정수를 문자열로 변환한다
  * 문자열의 첫번째와 마지막에 각각 포인터를 두고, 포인터의 인덱스를 하나씩 (증가/감소) 시키면서 각각의 포인터가 가리키는 값이 동일한지 확인한다
  * 각각의 포인터가 가리키는 값이 다를 경우 false 를 리턴한다
  * 양쪽 끝에서 거리를 좁혀나가기 시작한 각각의 포인터가 서로 교차한 경우 반복문을 종료한다
* 정수형 방식
  * input 으로 주어진 값을 10 으로 나눈 나머지 값을 새로운 변수에 다시 10의 배수로 곱하여 더한다
---

# Implementation

* My
    * By Stringify
    ````kotlin
    class Solution {
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
    }
    ````
    * By Numeric
    ````kotlin
    class Solution {
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
  ````

* Best
````kotlin
class Solution {
    fun isPalindrome(x: Int): Boolean {
        var num = x
        if (num < 0) return false
        var reversed = 0
        var remainder: Int
        val original = num
        while (num != 0) {
            remainder = num % 10 // reversed integer is stored in variable
            reversed =
                reversed * 10 + remainder //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            num /= 10 //the last digit is removed from num after division by 10.
        }
        // palindrome if original and reversed are equal
        return original == reversed
    }


}
````