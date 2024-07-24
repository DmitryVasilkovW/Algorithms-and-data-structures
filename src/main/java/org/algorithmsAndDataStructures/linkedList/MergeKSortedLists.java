package org.algorithmsAndDataStructures.linkedList;
// https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }

        var heap = new PriorityQueue<ListNode>(Comparator.comparing(node -> node.val));
        ListNode ans = null;
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }

        while (!heap.isEmpty()) {
            ans = poll(heap, ans);
        }

        return ans;
    }

    private ListNode poll(PriorityQueue<ListNode> heap, ListNode node) {
        ListNode temp = heap.poll();
        if (temp == null) return node;

        int val = temp.val;

        temp = deleteHead(temp);
        if (temp != null) heap.add(temp);

        return add(node, val);
    }

    private ListNode deleteHead(ListNode head) {
        if (head == null) return null;

        ListNode temp = head.next;

        return temp;
    }

    private ListNode add(ListNode node, int val) {
        ListNode newNode = new ListNode(val);

        if (node == null) {
            node = newNode;
            return node;
        }

        ListNode temp = node;

        while (node.next != null) {
            node = node.next;
        }

        node.next = newNode;
        return temp;
    }

    public static void main(String[] args) {
        var list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        var list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        var list3 = new ListNode(2);
        list3.next = new ListNode(6);

        var list = new ListNode[]{null, null};

        var task = new MergeKSortedLists();

        Printer.printList(task.mergeKLists(list));
    }
}
