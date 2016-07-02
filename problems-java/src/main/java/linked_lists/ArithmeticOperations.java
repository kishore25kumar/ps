package linked_lists;

import org.junit.*;
import utils.list.*;

public class ArithmeticOperations {
    public SingleLinkedListNode<Integer> add(SingleLinkedListNode<Integer> head1, SingleLinkedListNode<Integer> head2) {
        head1 = new RevereLinkedList().reverseIterative(head1);
        head2 = new RevereLinkedList().reverseIterative(head2);
        int carry = 0;
        SingleLinkedListNode sumHead = null;
        while (head1 != null || head2 != null) {
            int sum = (head1!= null?head1.getValue():0 )+ (head2!= null?head2.getValue():0) + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            SingleLinkedListNode<Integer> node = new SingleLinkedListNode<Integer>(sum);
            node.setNext(sumHead);
            sumHead = node;
            head1 = head1 != null ? head1.getNext() : null;
            head2 = head2 != null ? head2.getNext() : null;
        }

        if(carry == 1) {
            SingleLinkedListNode<Integer> node = new SingleLinkedListNode<Integer>(1);
            node.setNext(sumHead);
            sumHead = node;
        }

        return sumHead;
    }

    public SingleLinkedListNode<Integer> subtract(SingleLinkedListNode<Integer> head1, SingleLinkedListNode<Integer> head2) {
        head1 = new RevereLinkedList().reverseIterative(head1);
        head2 = new RevereLinkedList().reverseIterative(head2);
        int borrow = 0;
        SingleLinkedListNode head = null;

        while (head1 != null || head2 != null) {
            int val1 = head1 != null ? head1.getValue():0;
            int val2 = head2 != null ? head2.getValue():0;
            if (borrow == 1) {
                val1 -= 1;
            }

            if (val1 < val2) {
                val1 += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            int res = val1 - val2;
            SingleLinkedListNode node = new SingleLinkedListNode(res);
            node.setNext(head);
            head = node;

            head1 = head1 != null ? head1.getNext() : null;
            head2 = head2 != null ? head2.getNext() : null;
        }

        return head;
    }


    @Test
    public void addTest1() {
        SingleLinkedListNode<Integer> head1 = new SingleLinkedListUtils<Integer>().createList(new Integer[]{9, 9});
        SingleLinkedListNode<Integer> head2 = new SingleLinkedListUtils<Integer>().createList(new Integer[]{9});
        SingleLinkedListNode<Integer> sum = add(head1, head2);
        SingleLinkedListUtils.printLinkedList(sum);
    }

    @Test
    public void subtractTest1() {
        SingleLinkedListNode<Integer> head1 = new SingleLinkedListUtils<Integer>().createList(new Integer[]{9, 0, 0, 0, 0, 9});
        SingleLinkedListNode<Integer> head2 = new SingleLinkedListUtils<Integer>().createList(new Integer[]{9, 9, 9});
        SingleLinkedListNode<Integer> sub = subtract(head1, head2);
        SingleLinkedListUtils.printLinkedList(sub);
    }
}
