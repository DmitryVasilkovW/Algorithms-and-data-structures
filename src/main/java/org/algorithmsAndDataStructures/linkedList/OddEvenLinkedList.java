package org.algorithmsAndDataStructures.linkedList;
// https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75

public class OddEvenLinkedList
{
    public ListNode oddEvenList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode even=head.next;
        ListNode odd=head;
        ListNode evenHead=even;
        ListNode oddHead=odd;

        while (even != null && even.next != null)
        {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }

        odd.next=evenHead;
        if(even!=null)
        {
            even.next=null;
        }

        return oddHead;
    }

    public static void main(String[] args)
    {
        var node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);

        var prunter = new Printer();

        new OddEvenLinkedList().oddEvenList(node);

        prunter.printList(node);
    }
}


