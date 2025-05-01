package org.algorithmsAndDataStructures.linkedList;
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75

public class MaximumTwinSumOfALinkedList
{
    public int pairSum(ListNode head)
    {
        int max = 0;
        int n = 0;

        ListNode newNode = new ListNode(head.val);
        ListNode copy = newNode;
        var temp = head;

        while(temp != null)
        {
            ListNode fwd = new ListNode(temp.val);

            newNode.next = fwd;
            temp = temp.next;
            newNode = newNode.next;
        }

        ListNode prev = null;
        ListNode curr = copy;

        while (curr != null)
        {
            n++;
            ListNode nextTemp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        n /= 2;

        while (head != null && prev != null && n > 0)
        {
            max = Math.max(max, head.val + prev.val);

            head = head.next;
            prev = prev.next;
            n--;
        }

        return max;
    }

    public static void main(String[] args)
    {
        var node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);

        var prunter = new Printer();
        prunter.printList(node);

        System.out.println();
        System.out.println(new MaximumTwinSumOfALinkedList().pairSum(node));
    }
}
