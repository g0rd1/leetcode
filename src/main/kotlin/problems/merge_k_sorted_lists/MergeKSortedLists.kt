package problems.merge_k_sorted_lists

import java.util.*

fun main() {
    val result = Solution().mergeKLists(
        arrayOf(
            getListNodeFromList(listOf(1, 4, 5)),
            getListNodeFromList(listOf(1, 3, 4)),
            getListNodeFromList(listOf(2, 6)),
        )
    )
    println(result) // 1, 1, 2, 3, 4, 4, 5, 6
}

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        val listNodeQueue = PriorityQueue<ListNode>(compareBy { it.`val` })
        listNodeQueue.addAll(lists.filterNotNull())
        if (listNodeQueue.isEmpty()) return null
        val firstListNode = listNodeQueue.remove()
        val result = ListNode(firstListNode.`val`)
        if (firstListNode.next != null) listNodeQueue.add(firstListNode.next)
        var lastListNode: ListNode = result
        while (listNodeQueue.isNotEmpty()) {
            val listNode = listNodeQueue.remove()
            val newListNode = ListNode(listNode.`val`)
            lastListNode.next = newListNode
            lastListNode = newListNode
            if (listNode.next != null) listNodeQueue.add(listNode.next)
        }
        return result
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun getListNodeFromList(list: List<Int>): ListNode? {
    var result: ListNode? = null
    for (i in list.size - 1 downTo 0) {
        result = ListNode(list[i]).apply { next = result }
    }
    return result
}