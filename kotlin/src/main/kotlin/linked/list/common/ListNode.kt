package linked.list.common

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun List<Int>.toListNode(): ListNode? {
    if (isEmpty()) return null
    val dummy = ListNode(0)
    var current = dummy
    for (num in this) {
        current.next = ListNode(num)
        current = current.next!!
    }
    return dummy.next
}

fun printList(node: ListNode?) {
    var curr = node
    while (curr != null) {
        print("${curr.`val`}")
        if (curr.next != null) print(" -> ")
        curr = curr.next
    }
    println()
}
