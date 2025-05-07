package linked.list
// https://leetcode.com/problems/add-two-numbers/description/

import linked.list.common.ListNode
import linked.list.common.printList
import linked.list.common.toListNode

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val ans = ListNode(0)
        var temp = ans
        var carry = 0

        var l1Current = l1
        var l2Current = l2

        while (l1Current != null || l2Current != null || carry != 0) {
            val val1 = l1Current?.`val` ?: 0
            val val2 = l2Current?.`val` ?: 0

            val sum = val1 + val2 + carry
            carry = sum / 10
            temp.next = ListNode(sum % 10)
            temp = temp.next!!

            l1Current = l1Current?.next
            l2Current = l2Current?.next
        }

        return ans.next
    }
}

fun main() {
    val sol = AddTwoNumbers()

    val l1 = listOf(2, 4, 9).toListNode()
    val l2 = listOf(5, 6, 4, 9).toListNode()
    val result = sol.addTwoNumbers(l1, l2)

    printList(result)
}
