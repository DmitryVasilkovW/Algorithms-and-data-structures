package org.algorithmsAndDataStructures.linkedList;
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75

public class DeleteTheMiddleNodeOfALinkedList
{
    public ListNode deleteMiddle(ListNode head)
    {
        if(head.next == null) return null;

        int n = 0;
        ListNode current = head;

        while (current != null)
        {
            n++;
            current = current.next;
        }

        current = head;
        int i = 0;

        while (i < n / 2)
        {
            if (i == n / 2 - 1)
            {
                current.next = current.next.next;
            }
            else
            {
                current = current.next;
            }

            i++;
        }

        return head;
    }

    public static void main(String[] args)
    {
        var node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(7);
        node.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(6);

        var prunter = new Printer();

        new DeleteTheMiddleNodeOfALinkedList().deleteMiddle(node);

        prunter.printList(node);
    }
}

