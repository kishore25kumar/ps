package linked_lists;

import org.junit.*;
import utils.list.*;

public class RevereLinkedList {
    public SingleLinkedListNode reverseIterative(SingleLinkedListNode head) {
        SingleLinkedListNode prev = null;
        SingleLinkedListNode current = head;
        SingleLinkedListNode next = head;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        return prev;
    }

    public SingleLinkedListNode reverseRecursive(SingleLinkedListNode head, SingleLinkedListNode prev) {
        if (head == null) {
            return prev;
        }

        SingleLinkedListNode next = head.getNext();
        head.setNext(prev);
        return reverseRecursive(next, head);
    }

    public SingleLinkedListNode reverseRecursiveSingleParam(SingleLinkedListNode head) {
        if (head == null) {
            return null;
        }else if (head.getNext() == null) {
            return head;
        }

        SingleLinkedListNode newHead = reverseRecursiveSingleParam(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;
    }

    @Test
    public void test1() {
        SingleLinkedListNode head = new SingleLinkedListUtils<Integer>().createList(new Integer[]{1, 2, 3, 4});
        SingleLinkedListNode newHead = reverseIterative(head);
        SingleLinkedListUtils.printLinkedList(newHead);
    }

    @Test
    public void test2() {
        SingleLinkedListNode head = new SingleLinkedListUtils<Integer>().createList(new Integer[]{1, 2, 3, 4});
        SingleLinkedListNode newHead = reverseRecursive(head, null);
        SingleLinkedListUtils.printLinkedList(newHead);
    }

    @Test
    public void test3() {
        SingleLinkedListNode head = new SingleLinkedListUtils<Integer>().createList(new Integer[]{1, 2, 3, 4});
        SingleLinkedListNode newHead = reverseRecursiveSingleParam(head);
        SingleLinkedListUtils.printLinkedList(newHead);
    }
}
