package stack
// https://leetcode.com/problems/min-stack/description/

import java.util.Stack

class MinStack() {
    private val stack = Stack<Node<Int>>()

    fun push(`val`: Int) {
        if (!stack.empty()) {
            val curMin = stack.peek().min
            if (`val` > curMin) {
                stack.push(Node(`val`, curMin))
                return
            }
        }

        stack.push(Node(`val`, `val`))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().value
    }

    fun getMin(): Int {
        return stack.peek().min
    }

    private data class Node<T>(
        val value: T,
        val min: T
    )
}

fun main() {
    val sol = MinStack()

    sol.push(239)
    println(sol.getMin())
    sol.push(2)
    println(sol.getMin())
    sol.pop()
    println(sol.getMin())
}
