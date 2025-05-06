package org.algorithms.and.data.structures.linked.list;

public class Printer
{
    public static void printList(ListNode head)
    {
        ListNode curr = head;

        while (curr != null)
        {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }
}
